package com.example.nigma;

import android.app.ActionBar;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;

public class Bisection_Table extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_bisection__table);
        String json = getIntent().getExtras().getString("json");
        JSONParser parser = new JSONParser();
        JSONObject result = parser.parse(json);

        TableLayout table = (TableLayout)findViewById(R.id.tlGridTable);
        TextView finalRow = new TextView(this);

        /**Textview config**/
        finalRow.setId(2+ 122);
        finalRow.setGravity(Gravity.CENTER);
        float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                9, this.getResources().getDisplayMetrics());
        finalRow.setTextSize((int)pixels);
        finalRow.setPadding(20, 10, 20, 10);
        /****/

        for (int i = 0; i<result.length()-1;i++){
            TableRow newRow = new TableRow(this);
            try {
                JSONArray arr = (JSONArray) result.get(Integer.toString(i));
                for(int j=0; j< arr.length();j++) {
                    if(j==4 || j==5){
                        setText(String.format("%.2e",arr.get(j)), newRow, j);
                    }
                    else if(j==1 || j==2 || j==3){
                        if(j==2) {
                            finalRow.setText(String.format("%.2f", arr.get(j))+ " is a root with " +
                                    "the given conditions");
                        }
                        setText(String.format("%.2f",arr.get(j)), newRow, j);
                    }
                    else{
                        setText(arr.get(j).toString(), newRow, j);
                    }
                }
                table.addView(newRow);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        table.addView(finalRow);

    }

    public void setText(String text, TableRow newRow, int i){
        TextView tv = new TextView(this);
        tv.setId(i+111);
        tv.setGravity(Gravity.CENTER);
        newRow.setBackgroundResource(R.drawable.cell_border);
        tv.setBackgroundResource(R.drawable.cell_border);
        tv.setText(text);
        float pixels = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,
                15, this.getResources().getDisplayMetrics());
        tv.setTextSize((int)pixels-15);
        tv.setPadding(20, 10, 20, 10);
        newRow.addView(tv);
    }

}
