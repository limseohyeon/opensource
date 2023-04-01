package com.example.challenge02;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSend, btnColse;
    EditText edtText;
    TextView textView;
    String input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend=(Button) findViewById(R.id.btnSend);
        btnColse=(Button) findViewById(R.id.btnClose);
        edtText=(EditText) findViewById(R.id.edtText);
        textView=(TextView) findViewById(R.id.textView);


        edtText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                input = edtText.getText().toString();
                textView.setText(input.length() + " / 80 바이트");
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),edtText.getText(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}