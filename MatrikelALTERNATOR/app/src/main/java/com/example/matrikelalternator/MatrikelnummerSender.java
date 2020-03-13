package com.example.matrikelalternator;

import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.SocketException;

public class MatrikelnummerSender extends AsyncTask<Object, Object, Object> {

    private Socket s;
    private DataOutputStream dos;
    private BufferedReader bufferedReader;
    private String sentMatrikelnummer;
    private String recievedMessage;


    MatrikelnummerSender(Object sentMatrikelnummer) {
        this.sentMatrikelnummer = sentMatrikelnummer.toString();
    }

    @Override
    protected Object doInBackground(Object... params) {

        try {
            s = new Socket("se2-isys.aau.at", 53212);
            if (!s.isConnected())
                throw new SocketException("Socket not connected!");

            dos = new DataOutputStream(s.getOutputStream());
            bufferedReader = new BufferedReader(new InputStreamReader(s.getInputStream()));

            //sending Data to Server
            try {
                dos.writeBytes(sentMatrikelnummer + '\n');
                // wait(50000);
            } catch (Exception e) {
                System.out.println("Failed to send MNr to Server");
            }

            //reading Data from Server
            recievedMessage = bufferedReader.readLine();


            //closing Socket
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recievedMessage;
    }

    String getRecievedMessage() {
        return this.recievedMessage;
    }

}
