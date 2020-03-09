package com.example.matrikelalternator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Matrikelnummer;
    private TextView EnterMNr;
    private Button Abschicken;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigns to ID etMNr in XML
        Matrikelnummer = findViewById(R.id.etMNr);
        EnterMNr = findViewById(R.id.tvMNR);
        Abschicken = findViewById(R.id.btnAbschicken);
    }
}
