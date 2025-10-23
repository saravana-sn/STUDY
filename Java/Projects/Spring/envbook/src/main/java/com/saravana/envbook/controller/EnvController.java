package com.saravana.envbook.controller;

import com.saravana.envbook.model.Env;
import com.saravana.envbook.service.EnvPersistanceService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/env")
public class EnvController {
    private static Map<Long, Env> envMap = new HashMap<>();

    @Autowired
    EnvPersistanceService envPersistanceService;

    @PostConstruct
    public void init() {
        envMap = envPersistanceService.loadEnvMapFromFile();
    }

    @PreDestroy
    public void end(){
        envPersistanceService.saveEnvMapToFile(envMap);
    }

    @PutMapping
    public boolean createEnv(@RequestBody Env env) {
        envMap.put(env.getId(), env);
        return true;
    }

    @GetMapping
    public List<Env> getAllEnv() {
        return new ArrayList<>(envMap.values());
    }

    @GetMapping("{id}")
    public Env getEnvById(@PathVariable Long id) {
        return envMap.get(id);
    }

    @PostMapping("{id}")
    public boolean updateEnv(@PathVariable Long id, @RequestBody Env env) {
        envMap.put(id, env);
        return true;
    }

    @DeleteMapping("{id}")
    public boolean deleteEnv(@PathVariable Long id) {
        envMap.remove(id);
        return true;
    }
}
