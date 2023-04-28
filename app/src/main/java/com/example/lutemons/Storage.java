package com.example.lutemons;

import android.content.Context;
import android.view.View;

import com.example.lutemons.fragments.CreateLutemonFragment;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {
    private static Storage storage = null;

    private Integer id = 0;

    HashMap<Integer, Lutemon> lutemonHashMap = new HashMap<>();

    ArrayList<Lutemon> lutemonArrayList = new ArrayList<>();
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

    public ArrayList<Lutemon> getLutemonArrayList(){
        ArrayList<Lutemon> lutemons = new ArrayList<>();
        storage = Storage.getInstance();
        HashMap<Integer, Lutemon> lutemonHashMap = storage.getLutemonHashMap();
        for(HashMap.Entry<Integer, Lutemon> set :lutemonHashMap.entrySet()){
            lutemons.add(set.getValue());
        }
        return lutemons;
    }
    public void removeLutemon(Lutemon lutemon){
        Iterator<Map.Entry<Integer, Lutemon>> it = lutemonHashMap.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<Integer, Lutemon> entry = it.next();
            if (entry.getValue().equals(lutemon)) {
                // remove the matching entry
                it.remove();
            }
        }


    public ArrayList<Lutemon> sortArrayListByLvl(){
        makeNewArrayList();
        lutemonArrayList.sort(Lutemon.LvlComparator);
        return lutemonArrayList;
    }
    public ArrayList<Lutemon> sortArrayListByHP(){
        makeNewArrayList();
        lutemonArrayList.sort(Lutemon.HPComparator);
        return lutemonArrayList;
    }
    public ArrayList<Lutemon> sortArrayListByWins(){
        makeNewArrayList();
        lutemonArrayList.sort(Lutemon.WinsComparator);
        return lutemonArrayList;
    }

    public ArrayList<Lutemon> makeNewArrayList (){
        lutemonArrayList.clear();
        for (HashMap.Entry<Integer,Lutemon> entry : lutemonHashMap.entrySet()) {
            lutemonArrayList.add(entry.getValue());
        }
        return lutemonArrayList;

    }

}
