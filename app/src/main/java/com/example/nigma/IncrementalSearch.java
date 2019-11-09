package com.example.nigma;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class IncrementalSearch extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_incremental_search);
        Button calc = findViewById(R.id.is_calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularIS();
            }
        });
    }

    public void calcularIS(){
        JNICaller.prepareCall();
        EditText func = findViewById(R.id.id_is_fx);
        EditText ex0 = findViewById(R.id.is_x0);
        EditText edelta = findViewById(R.id.is_delta);
        EditText eniter = findViewById(R.id.is_niter);
        TextView eRes = findViewById(R.id.id_res);

        JNICaller.setf(func.getText().toString());
        double x0 = Double.parseDouble(ex0.getText().toString());
        double delta = Double.parseDouble(edelta.getText().toString());
        int niter = Integer.parseInt(eniter.getText().toString());
        String result = JNICaller.incrementalSearch(x0, delta, niter);
        eRes.setText(result);
    }
    static {
        System.loadLibrary("nigmaEcs");
    }
}
