package com.example.nigma;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class NonlinearList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonlinear_list);
        Button nsve = findViewById(R.id.btn_is);
        nsve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openIncrementalSearch();
            }

        });
        Button bis = findViewById(R.id.btn_bis);
        bis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openBisectionInput();
            }

        });
    }
    public void openIncrementalSearch(){
        Intent intent = new Intent(this, IncrementalSearch.class);
        startActivity(intent);
    }

    public void openBisectionInput(){
        Intent intent = new Intent(this, Bisection_input.class);
        startActivity(intent);
    }
}
