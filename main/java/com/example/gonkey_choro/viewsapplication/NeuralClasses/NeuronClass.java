package com.example.gonkey_choro.viewsapplication.NeuralClasses;

import com.example.gonkey_choro.viewsapplication.ShC;
import static java.lang.Math.exp;

class NeuronClass {
    void FindAnswer(float money, float minus, float plus, float ideal, ShC code) {
        code.setFloat("out_in", 0f);
        code.setFloat("out_out", 0f);
        code.setFloat("synapse_in", 0f);
        code.setFloat("synapse_out", 0f);
        money = Normalization(money);
        minus = Normalization(minus);
        plus = Normalization(plus);
        String iv;
        for (int i = 0; i < 9; i++) {
            iv = String.valueOf(i);
            code.setFloat("synapse_in"+iv, (money*code.getFloat("money_w"+iv)
                    -minus*code.getFloat("subtract_w"+iv)+plus*code.getFloat("add_w"+iv)));
            code.setFloat("synapse_out"+iv, Normalization(code.getFloat("synapse_in"+iv)));
        }
        for (int i = 0; i < 9; i++) {
            iv = String.valueOf(i);
            code.setFloat("out_in", code.getFloat("out_in")+code.getFloat("synapse_in"+iv)*code.getFloat("synapse_w"+iv));
        }

        code.setFloat("out_out", Normalization(code.getFloat("out_in")));
        ErrorCounting(code, ideal);
        DeltaCalculating(code, ideal, money, plus, minus);
    }

    private static float Normalization(float norm) {
        return (float)(1/(1+exp(-norm)));
    }

    private static void ErrorCounting(ShC code, float ideal) {
        code.setFloat("error", (ideal - code.getFloat("out_out"))*(ideal - code.getFloat("out_out")));
    }

    private void DeltaCalculating(ShC code, float ideal, float money, float plus, float minus) {
        code.setFloat("delta_out", (ideal - code.getFloat("out_out"))*(1 - code.getFloat("out_out"))*code.getFloat("out_out"));
        String iv;

        for (int i = 0; i < 9; i++) {
            iv = String.valueOf(i);
            code.setFloat("delta_hidden"+String.valueOf(i), (ideal - code.getFloat("synapse_out"+iv))
                    *code.getFloat("synapse_out"+iv)*code.getFloat("synapse_w"+iv)
                    *code.getFloat("delta_out"));

            code.setFloat("grad_synapse"+iv, code.getFloat("delta_out")*code.getFloat("synapse_out"+iv));
            code.setFloat("synapse_w_incr"+iv, code.getFloat("training_speed")*code.getFloat("grad_synapse")
                    +code.getFloat("moment")*code.getFloat("synapse_w_incr_prev"+iv));
            code.setFloat("synapse_w_incr_prev"+iv, code.getFloat("synapse_w_incr"+iv));
            code.setFloat("synapse_w"+iv, code.getFloat("synapse_w_incr"+iv)+code.getFloat("synapse_w"+iv));

            code.setFloat("grad_money"+iv, code.getFloat("delta_hidden"+iv)*money);
            code.setFloat("grad_add"+iv, code.getFloat("delta_hidden"+iv)*plus);
            code.setFloat("grad_add"+iv, code.getFloat("delta_hidden"+iv)*minus);

            code.setFloat("money_w_incr"+iv, code.getFloat("training_speed")*code.getFloat("grad_money"+iv)
                    +code.getFloat("moment")*code.getFloat("money_w_incr_prev"+iv));
            code.setFloat("money_w_incr_prev"+iv, code.getFloat("money_w_incr"));
            code.setFloat("money_w"+iv, code.getFloat("money_w_incr"+iv)+code.getFloat("money_w"+iv));

            code.setFloat("add_w_incr"+iv, code.getFloat("training_speed")*code.getFloat("grad_add"+iv)
                    +code.getFloat("moment")*code.getFloat("add_w_incr_prev"+iv));
            code.setFloat("add_w_incr_prev"+iv, code.getFloat("add_w_incr"));
            code.setFloat("add_w"+iv, code.getFloat("add_w_incr"+iv)+code.getFloat("add_w"+iv));

            code.setFloat("subtract_w_incr"+iv, code.getFloat("training_speed")*code.getFloat("grad_subtract"+iv)
                    +code.getFloat("moment")*code.getFloat("subtract_w_incr_prev"+iv));
            code.setFloat("subtract_w_incr_prev"+iv, code.getFloat("subtract_w_incr"));
            code.setFloat("subtract_w"+iv, code.getFloat("subtract_w_incr"+iv)+code.getFloat("subtract_w"+iv));
        }
    }
}
