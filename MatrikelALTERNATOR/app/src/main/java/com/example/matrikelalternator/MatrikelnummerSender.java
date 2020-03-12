package com.example.matrikelalternator;

import android.os.AsyncTask;
import android.view.contentcapture.DataRemovalRequest;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class MatrikelnummerSender extends AsyncTask<String, Void, String> {

    Socket s;
    DataOutputStream dos;
    BufferedReader bufferedReader;
    String sentMatrikelnummer;
    String recievedMessage;

    @Override
    protected String doInBackground(String... voids) {



        try {
            s = new Socket("se2-isys.aau.at", 53212);
            if(!s.isConnected())
                throw new SocketException("Socket not connected!");
            dos = new DataOutputStream(s.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));

            //sending Data to Server
            dos.writeBytes(sentMatrikelnummer + '\n');

            //reading Data from Server
            recievedMessage = bufferedReader.readLine();

            //closing Socket
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recievedMessage;
    }
}
