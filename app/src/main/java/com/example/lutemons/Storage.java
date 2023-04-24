package com.example.lutemons;

import android.content.Context;

import com.example.lutemons.fragments.CreateLutemonFragment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

public class Storage {
    private static Storage storage = null;

    private Integer id = 0;

    HashMap<Integer, Lutemon> lutemonHashMap = new HashMap<>();

    public void addLutemon(Lutemon lutemon){
        lutemonHashMap.put(id, lutemon);
        id += 1;
    }
    public static Storage getInstance(){
        if(storage == null){
            storage = new Storage();
        }
        return storage;
    }

    public void saveLutemons(Context context) {
        try {
            ObjectOutputStream lutemonWriter = new ObjectOutputStream(context.openFileOutput("lutemons.data", Context.MODE_PRIVATE));
            lutemonWriter.writeObject(lutemonHashMap);
            lutemonWriter.close();
        } catch (IOException e) {
            System.out.println("General I/O exception: " + e.getMessage());
            System.out.println("Lutemonien tallentaminen ei onnistunut");
            e.printStackTrace();
        }

    }
    public void loadLutemons(Context context) {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("lutemons.data"));
            lutemonHashMap = (HashMap<Integer, Lutemon>) userReader.readObject();
            id = lutemonHashMap.size();
            userReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Lutemonien lukeminen ei onnistunut");
            e.printStackTrace();
        }

    }

    public HashMap<Integer, Lutemon> getLutemonHashMap() {
        return lutemonHashMap;
    }


}
