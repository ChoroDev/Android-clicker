package com.example.gonkey_choro.viewsapplication.NeuralClasses;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import com.example.gonkey_choro.viewsapplication.R;
import com.example.gonkey_choro.viewsapplication.ShC;
import static com.example.gonkey_choro.viewsapplication.MainActivity.NEURON;

public class NeuralFragment extends Fragment {
    EditText money_e;
    EditText add_e;
    EditText subtract_e;
    EditText ideal_e;
    TextView synapse_input;
    TextView money_weights;
    TextView add_weights;
    TextView subtract_weights;
    TextView synapse_output;
    TextView synapse_weights;
    TextView out_in;
    TextView out_out;
    TextView error;
    Button training;
    ShC code;

    public void showInform() {
        money_weights.setText(String.format("1. %s;\n 2. %s;\n 3. %s;\n 4. %s;\n 5. %s;\n 6. %s;\n 7. %s;\n 8. %s;\n 9. %s;",
                code.getFloat("money_w0"), code.getFloat("money_w1"), code.getFloat("money_w2"),
                code.getFloat("money_w3"), code.getFloat("money_w4"), code.getFloat("money_w5"),
                code.getFloat("money_w6"), code.getFloat("money_w7"), code.getFloat("money_w8")));
        add_weights.setText(String.format("1. %s;\n 2. %s;\n 3. %s;\n 4. %s;\n 5. %s;\n 6. %s;\n 7. %s;\n 8. %s;\n 9. %s;",
                code.getFloat("add_w0"), code.getFloat("add_w1"), code.getFloat("add_w2"),
                code.getFloat("add_w3"), code.getFloat("add_w4"), code.getFloat("add_w5"),
                code.getFloat("add_w6"), code.getFloat("add_w7"), code.getFloat("add_w8")));
        subtract_weights.setText(String.format("1. %s;\n 2. %s;\n 3. %s;\n 4. %s;\n 5. %s;\n 6. %s;\n 7. %s;\n 8. %s;\n 9. %s;",
                code.getFloat("subtract_w0"), code.getFloat("subtract_w1"), code.getFloat("subtract_w2"),
                code.getFloat("subtract_w3"), code.getFloat("subtract_w4"), code.getFloat("subtract_w5"),
                code.getFloat("subtract_w6"), code.getFloat("subtract_w7"), code.getFloat("subtract_w8")));
        synapse_input.setText(String.format("1. %s;\n 2. %s;\n 3. %s;\n 4. %s;\n 5. %s;\n 6. %s;\n 7. %s;\n 8. %s;\n 9. %s;",
                code.getFloat("synapse_in0"), code.getFloat("synapse_in1"), code.getFloat("synapse_in2"),
                code.getFloat("synapse_in3"), code.getFloat("synapse_in4"), code.getFloat("synapse_in5"),
                code.getFloat("synapse_in6"), code.getFloat("synapse_in7"), code.getFloat("synapse_in8")));
        synapse_output.setText(String.format("1. %s;\n 2. %s;\n 3. %s;\n 4. %s;\n 5. %s;\n 6. %s;\n 7. %s;\n 8. %s;\n 9. %s;",
                code.getFloat("synapse_out0"), code.getFloat("synapse_out1"), code.getFloat("synapse_out2"),
                code.getFloat("synapse_out3"), code.getFloat("synapse_out4"), code.getFloat("synapse_out5"),
                code.getFloat("synapse_out6"), code.getFloat("synapse_out7"), code.getFloat("synapse_out8")));
        synapse_weights.setText(String.format("1. %s;\n 2. %s;\n 3. %s;\n 4. %s;\n 5. %s;\n 6. %s;\n 7. %s;\n 8. %s;\n 9. %s;",
                code.getFloat("synapse_w0"), code.getFloat("synapse_w1"), code.getFloat("synapse_w2"),
                code.getFloat("synapse_w3"), code.getFloat("synapse_w4"), code.getFloat("synapse_w5"),
                code.getFloat("synapse_w6"), code.getFloat("synapse_w7"), code.getFloat("synapse_w8")));
        out_in.setText(String.valueOf(code.getFloat("out_in")));
        out_out.setText(String.valueOf(code.getFloat("out_out")));
        error.setText(String.valueOf(code.getFloat("error")));
    }

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.neural_fragment, container, false);
        code = new ShC(getContext(), NEURON);
        money_weights = (TextView) view.findViewById(R.id.money_weights);
        add_weights = (TextView) view.findViewById(R.id.add_weights);
        subtract_weights = (TextView) view.findViewById(R.id.subtract_weights);
        training = (Button) view.findViewById(R.id.training);
        synapse_input = (TextView) view.findViewById(R.id.synaps_input);
        synapse_output = (TextView) view.findViewById(R.id.synaps_out);
        synapse_weights = (TextView) view.findViewById(R.id.synaps_weights);
        out_in = (TextView) view.findViewById(R.id.out_input);
        out_out = (TextView) view.findViewById(R.id.out_out);
        error = (TextView) view.findViewById(R.id.error);
        money_e = (EditText) view.findViewById(R.id.money_e);
        add_e = (EditText) view.findViewById(R.id.add_e);
        subtract_e = (EditText) view.findViewById(R.id.subtract_e);
        ideal_e = (EditText) view.findViewById(R.id.ideal);

        training.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!money_e.getText().toString().equals("") && !add_e.getText().toString().equals("")
                        && !subtract_e.getText().toString().equals("") && !ideal_e.getText().toString().equals("")) {
                    float mon_e = Float.valueOf(money_e.getText().toString());
                    float plu_e = Float.valueOf(add_e.getText().toString());
                    float sub_e = Float.valueOf(subtract_e.getText().toString());
                    float ide_e = Float.valueOf(ideal_e.getText().toString());
                    new NeuronClass().FindAnswer(mon_e, sub_e, plu_e, ide_e, code);
                    showInform();
                } else Toast.makeText(getContext(), "не введены данные", Toast.LENGTH_LONG).show();
            }
        });

        showInform();
        return view;
    }
}
