package com.example.gonkey_choro.viewsapplication.NeuralClasses;

import android.content.Context;

import com.example.gonkey_choro.viewsapplication.ShC;
import java.util.Random;

import static com.example.gonkey_choro.viewsapplication.MainActivity.NEURON;

public class NeuralOptions {
    public static void removeAllPreferences(Context context) {
        ShC nCode = new ShC(context, NEURON);

        String iv;
        for (int i = 0; i < 9; i++) {
            iv = String.valueOf(i);
            nCode.setFloat("money_w"+iv, new Random().nextFloat());
            nCode.setFloat("money_incr"+iv, 0f);
            nCode.setFloat("money_incr_prev"+iv, 0f);
            nCode.setFloat("grad_money"+iv, 0f);

            nCode.setFloat("add_w"+iv, new Random().nextFloat());
            nCode.setFloat("add_w_incr"+iv, 0f);
            nCode.setFloat("add_w_incr_prev"+iv, 0f);
            nCode.setFloat("grad_add"+iv, 0f);

            nCode.setFloat("subtract_w"+iv, new Random().nextFloat());
            nCode.setFloat("subtract_w_incr"+iv, 0f);
            nCode.setFloat("subtract_w_incr_prev"+iv, 0f);
            nCode.setFloat("grad_subtract"+iv, 0f);

            nCode.setFloat("synapse_w"+iv, new Random().nextFloat());
            nCode.setFloat("synapse_in"+iv, 0f);
            nCode.setFloat("synapse_out"+iv, 0f);
            nCode.setFloat("synapse_w_incr"+iv, 0f);
            nCode.setFloat("synapse_w_incr_prev"+iv, 0f);
            nCode.setFloat("grad_synapse"+iv, 0f);

            nCode.setFloat("delta_hidden"+iv, 0f);
        }
        nCode.setFloat("out_in", 0f);
        nCode.setFloat("out_out", 0f);
        nCode.setFloat("error", 0f);
        nCode.setFloat("delta_out", 0f);
        nCode.setFloat("training_speed", 0.7f);
        nCode.setFloat("moment", 0.3f);
    }
}
