package com.example.matrikelalternator;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class MatrikelnummerSender extends AsyncTask<String, Integer, String> {

    Socket s;
    DataOutputStream dos;
    BufferedReader bufferedReader;
    String sentMatrikelnummer;
    String recievedMessage;
    //PrintWriter printWriter;

    public MatrikelnummerSender(String sentMatrikelnummer) {
        this.sentMatrikelnummer = sentMatrikelnummer;
    }

    @Override
    protected String doInBackground(String[] strings) {



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

            //printWriter.write(recievedMessage);

            //closing Socket
            s.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return recievedMessage;
    }

    public String getRecievedMessage(){
        return this.recievedMessage;
    }
}
