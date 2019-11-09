package com.example.nigma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class Bisection_input extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bisection_input);
        Button calc = findViewById(R.id.is_calc);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calcularBis();
            }
        });
    }

    public void calcularBis(){
        JNICaller.prepareCall();
        EditText func = findViewById(R.id.bis_fx);
        EditText ex0 = findViewById(R.id.bis_x0);
        EditText ex1 = findViewById(R.id.bis_x1);
        EditText eError = findViewById(R.id.bis_error);
        EditText eniter = findViewById(R.id.bis_niter);
        RadioGroup eErrorType= findViewById(R.id.bis_radioGroup);

        JNICaller.setf(func.getText().toString());
        double x0 = Double.parseDouble(ex0.getText().toString());
        double x1 = Double.parseDouble(ex1.getText().toString());
        double error = Double.parseDouble(eError.getText().toString());
        int niter = Integer.parseInt(eniter.getText().toString());
        int rbtn_id = eErrorType.getCheckedRadioButtonId();
        RadioButton rbtn = (RadioButton)findViewById(rbtn_id);
        boolean type = rbtn.getText().equals("Significant Digits");
        String result = JNICaller.bisection(x0, x1, error, niter, type);
        Intent table = new Intent(this, Bisection_Table.class);
        table.putExtra("json", result);
        startActivity(table);
    }


    static {
        System.loadLibrary("nigmaEcs");
    }
}
