package com.example.matrikelalternator;

import android.os.AsyncTask;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

public class MatrikelnummerSender extends AsyncTask<String, Void, Void> {

    Socket s;
    DataOutputStream dos;
    PrintWriter pw;

    @Override
    protected Void doInBackground(String... voids) {

        String recievedMatrikelnummer = voids[0];

        try {
            s = new Socket("se2-isys.aau.at", 53212);
            pw = new PrintWriter(s.getOutputStream());
            pw.write(recievedMatrikelnummer);
            pw.flush();
            pw.close();
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
