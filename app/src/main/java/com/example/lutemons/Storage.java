package com.example.lutemons;

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

    public HashMap<Integer, Lutemon> getLutemonHashMap() {
        return lutemonHashMap;
    }
}
