package com.djodevs.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    TextView imputText, outputText;

    private String input, output, newoutput;

    private Button b0,b1,b2,b3,b4,b5,b6,b7,b8,b9, badd, bsub, bmul, bdiv, bdot, bpow, bequ, bc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imputText = findViewById(R.id.text_operation);
        outputText = findViewById(R.id.text_result);
        b0 = findViewById(R.id.btn_0); b1 = findViewById(R.id.btn_1);
        b2 = findViewById(R.id.btn_2); b3 = findViewById(R.id.btn_3);
        b4 = findViewById(R.id.btn_4); b5 = findViewById(R.id.btn_5);
        b6 = findViewById(R.id.btn_6); b7 = findViewById(R.id.btn_7);
        b8 = findViewById(R.id.btn_8); b9 = findViewById(R.id.btn_9);
        badd = findViewById(R.id.btn_add); bsub = findViewById(R.id.btn_moin);
        bdiv = findViewById(R.id.btn_div); bmul = findViewById(R.id.btn_multiply);
        bequ = findViewById(R.id.btn_equ); bdot = findViewById(R.id.btn_dot);
        bpow = findViewById(R.id.btn_pow); bc = findViewById(R.id.btn_c);


    }

    private void solve(){
        if(input.split("\\+").length == 2){
            String numbers[] = input.split("\\+");
            try{
                double d= Double.parseDouble(numbers[0]) + Double.parseDouble(numbers[1]);
                output= Double.toString(d);
                newoutput = cutDecimal(output);
                outputText.setText(newoutput);
                input = d + "";
            }catch(Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\*").length == 2){
            String numbers[] = input.split("\\*");
            try{
                double d= Double.parseDouble(numbers[0]) * Double.parseDouble(numbers[1]);
                output= Double.toString(d);
                newoutput = cutDecimal(output);
                outputText.setText(newoutput);
                input = d + "";
            }catch(Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\-").length == 2){
            String numbers[] = input.split("\\-");
            try {
                if (Double.parseDouble(numbers[0]) < Double.parseDouble(numbers[1])) {
                    double d = Double.parseDouble(numbers[1]) - Double.parseDouble(numbers[0]);
                    output = Double.toString(d);
                    newoutput = cutDecimal(output);
                    outputText.setText("-" + newoutput);
                    input = (d * -1) + "";
                }
                else{
                    double d = Double.parseDouble(numbers[0]) - Double.parseDouble(numbers[1]);
                    output = Double.toString(d);
                    newoutput = cutDecimal(output);
                    outputText.setText(newoutput);
                    input = d + "";
                }
            }catch(Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\/").length == 2){
            String numbers[] = input.split("\\/");
            try{
                double d= Double.parseDouble(numbers[0]) / Double.parseDouble(numbers[1]);
                output= Double.toString(d);
                newoutput = cutDecimal(output);
                outputText.setText(newoutput);
                input = d + "";
            }catch(Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
        if(input.split("\\^").length == 2){
            String numbers[] = input.split("\\^");
            try{
                double d= Math.pow(Double.parseDouble(numbers[0]) , Double.parseDouble(numbers[1]));
                output= Double.toString(d);
                newoutput = cutDecimal(output);
                outputText.setText(newoutput);
                input = d + "";
            }catch(Exception e){
                outputText.setError(e.getMessage().toString());
            }
        }
    }

    public void OnbuttonClicked(View view) {
        Button button = (Button) view;
        String data = button.getText().toString();
        switch(data){
            case "AC":
                input = null;
                output = null;
                newoutput = null;
                outputText.setText("");
                break;
            case "^":
                solve();
                input+="^";
                break;
            case "*":
                solve();
                input += "*";
                break;
            case "=":
                solve();
                break;
            case "%":
                input+="%";
                double d = Double.parseDouble(imputText.getText().toString()) / 100 ;
                outputText.setText(String.valueOf(d));
                break;
            default:
                if(input == null){
                    input = "";
                }
                if(data.equals("-") || data.equals("+") || data.equals("/"))
                {
                    solve();
                }
                input+=data;
        }
        imputText.setText(input);

    }
    private String cutDecimal(String number){
        String n[] = number.split("\\.");
        if(n.length > 1){
            if(n[1].equals("0")){
                number = n[0];
            }
        }
        return number;
    }
}