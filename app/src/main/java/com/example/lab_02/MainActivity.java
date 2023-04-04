package com.example.lab_02;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    Boolean isNew = true;
    String oldNumber;
    String operator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         editText = findViewById(R.id.editText);
    }

    public void clickNumber(View view){
        if(isNew)
            editText.setText("");
            isNew=false;
        String number = editText.getText().toString();
        switch (view.getId()){
            case R.id.bn1:
                if(zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                } number = number + "1"; break;
            case R.id.bn2:
                if(zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                } number = number + "2"; break;
            case R.id.bn3:
                if(zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                } number = number + "3"; break;
            case R.id.bn4:
                if(zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                } number = number + "4"; break;
            case R.id.bn5:
                if(zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                } number = number + "5"; break;
            case R.id.bn6:
                if(zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                } number = number + "6"; break;
            case R.id.bn7:
                if(zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                } number = number + "7"; break;
            case R.id.bn8:
                if(zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                } number = number + "8"; break;
            case R.id.bn9:
                if(zeroIsFirst(number) && number.length() == 1){
                    number = number.substring(1);
                } number = number + "9"; break;
            case R.id.bn0:
                if(zeroIsFirst(number) && number.length() == 1){
                    number = "0";
                } else {
                number = number + "0";
                } break;

            case R.id.bnCom:
                if (comIsPresent(number)){

                }  else if(zeroIsFirst(number)){
                    number = "0.";
                    }
                else number = number + "."; break;

            case R.id.bnPlusMin:
                if(numberIsZero(number)){
                    number = "0";
                } else {
                    if (minusIsPresent(number)) {
                        number = number.substring(1);
                    } else number = "-" + number;
                }
                    break;

        }
        editText.setText(number);
    }

    private boolean zeroIsFirst(String number) {
        if(number.equals("")) return true;
        if (number.charAt(0) == '0') return true;
        else return false;
    }

    private boolean numberIsZero(String number) {
        if(number.equals("0") || number.equals("")) return true;
        else return false;
    }

    private boolean minusIsPresent(String number) {
        if (number.charAt(0) == '-'){
            return true;
        } else return false;
    }

    public void operation (View view){
        isNew = true;
        oldNumber = editText.getText().toString();
        switch (view.getId()){
            case R.id.bnPlus: operator = "+"; break;
            case R.id.bnMinus: operator = "-"; break;
            case R.id.bnDivide: operator = "/"; break;
            case R.id.bnMulti: operator = "*"; break;
            case R.id.bnSQRT: editText.setText(sqrtOperation(oldNumber)); break;
            case R.id.bnFrac: editText.setText(fracOperation(oldNumber)); break;
         }
    }

    @SuppressLint("SuspiciousIndentation")
    private String fracOperation(String oldNumber) {
        if(Double.parseDouble(oldNumber) < 0.0000001)
            Toast.makeText(MainActivity.this,"На нуль делить нелья", Toast.LENGTH_SHORT).show();
        else
            oldNumber = String.valueOf(1/Double.parseDouble(oldNumber));
            return oldNumber;
    }

    public void clickEqual (View view){
        String newNumber = editText.getText().toString();
        Double result = 0.0;

        if(Double.parseDouble(newNumber) < 0.0000001 && operator == "/"
                || newNumber.length() == 1 && operator == "/")
            Toast.makeText(MainActivity.this,"На нуль делить нелья", Toast.LENGTH_SHORT).show();
        else {
            switch (operator) {
                case "+":
                    result = Double.parseDouble(oldNumber) + Double.parseDouble(newNumber);
                    break;
                case "-":
                    result = Double.parseDouble(oldNumber) - Double.parseDouble(newNumber);
                    break;
                case "/":
                    result = Double.parseDouble(oldNumber) / Double.parseDouble(newNumber);
                    break;
                case "*":
                    result = Double.parseDouble(oldNumber) * Double.parseDouble(newNumber);
                    break;
            }
            String formattedResult = String.format("%.8f", result);
            editText.setText(formattedResult);
        }
    }

    @SuppressLint("SuspiciousIndentation")
    private String sqrtOperation(String oldNumber) {
    if (Double.parseDouble(oldNumber) > 0){
        oldNumber = String.valueOf(Math.sqrt(Double.parseDouble(oldNumber)));
        return oldNumber;
    } else  Toast.makeText(MainActivity.this,"Операция проводится с положительными значениями", Toast.LENGTH_SHORT).show();
            return "0";
    }

    public void clearClick (View view){
        editText.setText("0");
        isNew = true;
    }

    private Boolean comIsPresent(String number) {
        if (number.indexOf(".") == -1) {
            return false;
        } else return true;
    }
}