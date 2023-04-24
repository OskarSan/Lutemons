package com.example.lutemons;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class EventLogger {
    final private String FILENAME;

    public EventLogger(){
        FILENAME = "log.txt";
    }

    public void writeLog(String logText){
        try {
            BufferedWriter logWriter = new BufferedWriter(new FileWriter(FILENAME));
            logWriter.write(logText +"\n");
            logWriter.close();
        } catch (IOException e) {
            System.out.println("Virhe kirjoitettaessa logitiedostoa");
            throw new RuntimeException(e);
        }
    }
    public void readLog(){

    }
}
