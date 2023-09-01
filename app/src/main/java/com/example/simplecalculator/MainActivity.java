package com.example.simplecalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button buttonAdd, buttonSub, buttonMul, buttonDiv, buttonClear;
    EditText editTextN1, editTextN2;
    TextView textView;
    int num1, num2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        buttonClear = findViewById(R.id.btn_clear);

        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);

        textView = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextN1.getText().clear();
                editTextN2.getText().clear();
                textView.setText("");
            }
        });

    }

    public int getIntFromEditText(EditText editText){
        if (editText.getText().toString().equals("")){
            Toast.makeText(this, "Please Enter Number", Toast.LENGTH_SHORT).show();
            return 0;
        }else
            return Integer.parseInt(editText.getText().toString());
    }

    @Override
    public void onClick(View view) {
        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);

        if (view.getId() == R.id.btn_add) {
            textView.setText("Answer = " + (num1 + num2));
        } else if (view.getId() == R.id.btn_sub) {
            textView.setText("Answer = " + (num1 - num2));
        } else if (view.getId() == R.id.btn_mul) {
            textView.setText("Answer = " + (num1 * num2));
        }
        else {
            textView.setText("Answer = " + ((float)num1 / (float) num2));
        }
    }
}