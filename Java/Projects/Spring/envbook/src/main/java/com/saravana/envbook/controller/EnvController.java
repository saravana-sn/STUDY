package com.saravana.envbook.controller;

import com.saravana.envbook.model.Env;
import com.saravana.envbook.service.EnvPersistenceService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.util.*;

@RestController
@RequestMapping("/env")
public class EnvController {
    private static Map<Long, Env> envMap = new HashMap<>();
    private final EnvPersistenceService envPersistenceService;

    @Autowired
    public EnvController(EnvPersistenceService envPersistenceService) {
        this.envPersistenceService = envPersistenceService;
    }

    @PostConstruct
    public void init() {
        envMap = envPersistenceService.loadEnvMapFromFile();
    }

    @PreDestroy
    public void end(){
        envPersistenceService.saveEnvMapToFile(envMap);
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

    @GetMapping("/{id}")
    public Env getEnvById(@PathVariable Long id) {
        return envMap.get(id);
    }

    @PostMapping("/{id}")
    public boolean updateEnv(@PathVariable Long id, @RequestBody Env env) {
        envMap.put(id, env);
        return true;
    }

    @DeleteMapping("/{id}")
    public boolean deleteEnv(@PathVariable Long id) {
        envMap.remove(id);
        return true;
    }
}
