package com.example.tempapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnCalculate;
    EditText etTemp;
    RadioGroup rgTemp;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //bind programming vvars with the views in xml

        btnCalculate = findViewById(R.id.btnCalc);
        etTemp = findViewById(R.id.etTemp);
        rgTemp = findViewById(R.id.rgTemp);
        tvResult = findViewById(R.id.tvResult);

        //anonimus class - use one time
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAnswer();
            }
        });
    }

    public void calculateAnswer(){

        String temperature = etTemp.getText().toString(); //get value in text view and assign it to var

        //check for empty
        if(temperature.equals("")){
            Toast.makeText(this, "Please add a value", Toast.LENGTH_LONG).show();
        }
        else{

            Float d = 0.0f;
            Boolean error =Boolean.FALSE;

            try{
                d = Float.parseFloat(temperature);
            }catch(NumberFormatException e){
                Toast.makeText(this, "Invalid Value", Toast.LENGTH_LONG).show();
                error=Boolean.TRUE;
            }

            if(!error){

                int checkedRadioButton = rgTemp.getCheckedRadioButtonId();

                if(checkedRadioButton==R.id.rbCel){
                    tvResult.setText(CovertFahrenheitToCelcius(d)+"");
                }else{
                    tvResult.setText(CovertCelciusToFahren(d)+"");
                }

            }

        }




    }

    public float CovertFahrenheitToCelcius(float num){
        float celValue;
        celValue = (num - 32) * 5/9;
        return celValue;
    }

    public float CovertCelciusToFahren(float num){
        float FahrenValue;
        FahrenValue =num * 9/5 + 32 ;
        return FahrenValue;
    }


}
