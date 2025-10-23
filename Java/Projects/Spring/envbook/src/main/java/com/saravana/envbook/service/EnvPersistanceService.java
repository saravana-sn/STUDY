package com.saravana.envbook.service;

import com.saravana.envbook.model.Env;
import jakarta.annotation.*;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

// Provide data persistence using a serialized Object file (env.ser)
@Service
public class EnvPersistanceService {
    @SuppressWarnings("unchecked")
    public Map<Long,Env> loadEnvMapFromFile() {
        Map<Long,Env> envMap = new HashMap<>();
        try(ObjectInputStream in = new ObjectInputStream( new FileInputStream("env.ser"))){
            envMap =  (Map<Long, Env>) in.readObject();
        }catch (FileNotFoundException e){
            System.out.println("File env.ser not found. starting fresh.");
        }catch (IOException | ClassNotFoundException e){
            System.out.println("Error loading pets.ser");
        }
        return envMap;
    }

    public void saveEnvMapToFile(Map<Long, Env> envMap){
        try{
            ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("env.ser"));
            out.writeObject(envMap);
            out.flush();
            System.out.println("Saved at env.ser successfully! GoodBye!");
        }catch (IOException e){
            System.out.println("Error saving env.ser: " + e.getMessage());
        }
    }
}
