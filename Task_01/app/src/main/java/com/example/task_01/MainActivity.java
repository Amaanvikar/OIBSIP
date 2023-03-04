package com.example.task_01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button convert,switch_01;
    TextView unit_01,unit_02,res;
    EditText value;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value     =  findViewById(R.id.value);
        convert   = findViewById(R.id.convert);
        switch_01 = findViewById(R.id.switchbtn);
        unit_01   = findViewById(R.id.unit_01);
        unit_02   = findViewById(R.id.unit_02);
        res       = findViewById(R.id.answer);
        convert.setOnClickListener(v->{
            String val = value.getText().toString();
            if(!TextUtils.isEmpty(val)) {
                if (unit_01.getText().toString().equals("KiloGrams")) {
                    int ans = Integer.parseInt(val) * 1000;
                    res.setText(ans + " grams");
                } else {
                    double ans = Integer.parseInt(val)*0.001;
                    res.setText(ans + " Kilograms");
                }
            }else
                Toast.makeText(this, "Empty Value", Toast.LENGTH_SHORT).show();
        });

        switch_01.setOnClickListener(v->{
            if(unit_01.getText().toString() == "KiloGrams"){
                unit_01.setText("Grams");
                unit_02.setText("KiloGrams");
            }else{
                unit_01.setText("KiloGrams");
                unit_02.setText("Grams");
            }
        });
    }
}