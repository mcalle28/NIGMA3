package com.example.nigma;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button nsve = findViewById(R.id.btn_nsve);
        nsve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNonlinearList();
            }
        });
    }

    public void openNonlinearList(){
        Intent intent = new Intent(this, NonlinearList.class);
        startActivity(intent);
    }


}
