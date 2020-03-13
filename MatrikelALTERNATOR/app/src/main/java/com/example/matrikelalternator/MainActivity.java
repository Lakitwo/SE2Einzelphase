package com.example.matrikelalternator;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText Matrikelnummer;
    private TextView EnterMNr;
    private TextView ServerAntwort;
    private Button Abschicken;
    private Button Alternate;
    private TextView resAlternate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Assigns to ID etMNr in XML
        Matrikelnummer = findViewById(R.id.etMNr);
        EnterMNr = findViewById(R.id.tvMNR);
        Abschicken = findViewById(R.id.btnAbschicken);
        Alternate = findViewById(R.id.btnAlternate);
        ServerAntwort = findViewById(R.id.servResp);
        resAlternate = findViewById(R.id.tvAlternate);
        Abschicken.setEnabled(false);
        Alternate.setEnabled(false);


        //To enable/disable Buttons when no input/no input
        Matrikelnummer.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before,
                                      int count) {
                if (Matrikelnummer.getText().length() == 0) {
                    Abschicken.setEnabled(false);
                    Alternate.setEnabled(false);
                } else {
                    Abschicken.setEnabled(true);
                    Alternate.setEnabled(true);
                }
            }
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {}

            @Override
            public void afterTextChanged(Editable s) {}
        });


        Abschicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MatrikelnummerSender ms = new MatrikelnummerSender(Matrikelnummer.getText().toString());
                ms.execute();
                try {
                    ms.get();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                ServerAntwort.setText(ms.getRecievedMessage());
            }
        });

    }

    public void sendAlternate(View v) {
        CalcAlternate ca = new CalcAlternate();
        String output = ca.calcAlternate(Matrikelnummer.getText().toString());
                resAlternate.setText(output);
    }


}
