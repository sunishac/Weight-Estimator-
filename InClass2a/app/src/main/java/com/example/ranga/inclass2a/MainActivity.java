package com.example.ranga.inclass2a;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String bmi;
    double value = 0;
    double value1= 0;
    double value2=0;
    Double hgtint_in=-1.0;
    Double hgtint_ft=-1.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                EditText hgt_in=(EditText) findViewById(R.id.editText2);
                EditText hgt_ft=(EditText) findViewById(R.id.editText);

                try {
                    hgtint_in = Double.parseDouble(hgt_in.getText().toString());
                    hgtint_ft = Double.parseDouble(hgt_ft.getText().toString());
                }
                catch(Exception e){

                }
                RadioGroup rg = (RadioGroup) findViewById(R.id.rg);

                RadioButton rgbmi = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                bmi= rgbmi.getText().toString();
               // double bmi1 = Double.parseDouble(bmi);
                TextView result = (TextView) findViewById(R.id.result);
               if(hgtint_ft>0 && hgtint_in>0) {
                   if (bmi.equals("<18.5")) {

                       value = (18.5 * (hgtint_ft * 12 +hgtint_in)*(hgtint_ft * 12 +hgtint_in)) / 703;
                       Toast.makeText(MainActivity.this, "Weight Calculated", Toast.LENGTH_LONG).show();
                       result.setText("Your weight should be less than " + value + " amount");


                   } else if (bmi.equals("18.5 to 24.9")) {
                       Log.d("demo",""+hgtint_ft+" "+hgtint_in);

                       value1 = (18.5 * (hgtint_ft * 12 +hgtint_in)*(hgtint_ft * 12 +hgtint_in)) / 703;
                       value2 = (24.9 *(hgtint_ft * 12 +hgtint_in)*(hgtint_ft * 12 +hgtint_in)) / 703;
                       Toast.makeText(MainActivity.this, "Weight Calculated", Toast.LENGTH_LONG).show();
                       result.setText("Your weight should be in between " + value1 + "to " + value2 + "lb");

                   } else if (bmi.equals("25.0 to 29.9")) {
                       value1 = (25.0 * (hgtint_ft * 12 +hgtint_in)*(hgtint_ft * 12 +hgtint_in)) / 703;
                       value2 = (29.9 * (hgtint_ft * 12 +hgtint_in)*(hgtint_ft * 12 +hgtint_in)) / 703;
                       Toast.makeText(MainActivity.this, "Weight Calculated", Toast.LENGTH_LONG).show();
                       result.setText("Your weight should be in between " + value1 + "to " + value2 + "lb");

                   } else if (bmi.equals(">29.9")) {

                       value = (29.9 * (hgtint_ft * 12 +hgtint_in)*(hgtint_ft * 12 +hgtint_in)) / 703;
                       Toast.makeText(MainActivity.this, "Weight Calculated", Toast.LENGTH_LONG).show();
                       result.setText("Your weight should be greater than " + value + " amount");
                   }

               }
                else
               {
                   Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_LONG).show();
               }
            }
        });


    }
}
