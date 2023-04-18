package com.example.lutemons;

import java.util.HashMap;

public class Storage {
    private static Storage storage = null;

    HashMap<Integer, Lutemon> lutemonHashMap = new HashMap<>();


    public static Storage getInstance(){
        if(storage == null){
            storage = new Storage();
        }
        return storage;
    }
}
