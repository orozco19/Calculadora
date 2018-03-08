package com.orozcoh.santiago.calculadora;

import android.support.annotation.ColorInt;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    private TextView screen;
    private String str, str1, str2, str3, sign;
    boolean comp1, comp2;
    private double a, b, result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        screen = (TextView)findViewById(R.id.pantalla);
        str ="";
        a = 0;
        b = 0;
        comp1 = false;
        comp2 = false;
    }

    public void onClick (View v){
        Button button = (Button) v;
        if ((str == "") & (button.getText().toString() ==".")){
            str = "0.";
            return;
        }

        if ((comp1 == true) & (comp2 == true)){
            a = Double.parseDouble("0");
            b = Double.parseDouble("0");
            comp1 = false;
            comp2 = false;
            str ="";
        }

        if ((comp1 == false)&(comp2 == false)){
            screen.setText("");
            str += button.getText().toString();
            screen.setText(str);
            a = Double.parseDouble(str);
        }
        else if ((comp1 == true) & (comp2 == false)){
            screen.setText("");

            if(button.getText().toString() == ".")
                str = "0.";
            str += button.getText().toString();
            screen.setText(str);
            b = Double.parseDouble(str);
        }
    }

    public void onClickSign(View v){
        Button button = (Button) v;
        if ((comp1 == true) & (comp2 == true)){
            a = result;
            comp2 = false;

        }
        if (comp1 == false)
            comp1 = true;

        sign = button.getText().toString();
        screen.setText(sign);
        str ="";
    }

    public void calcular(View v){
        comp2 = true;
        if ((comp1 == true)&(comp2 == true)&(b != 0)){

            if (sign.equals("+")){
                result = a + b ;
                result = Double.parseDouble(new DecimalFormat("##.###").format(result));
            }
            else if (sign.equals("-")){
                result = a - b ;
                result = Double.parseDouble(new DecimalFormat("##.###").format(result));
            }
            else if (sign.equals("*")){
                result = a * b ;
                result = Double.parseDouble(new DecimalFormat("##.###").format(result));
            }
            else if (sign.equals("/")){
                result = (a / b);
                result = Double.parseDouble(new DecimalFormat("##.###").format(result));
            }
            else
                screen.setText("Error");
            screen.setText(""+result);
        }
        else{
            screen.setText("Repita la operacion");
            b = 0;
            a = 0;
        }

    }

    public void OnBorrar(View view) {
        str = "0";
        a = Double.parseDouble(str);
        b = Double.parseDouble(str);
        screen.setText("");
    }
}
