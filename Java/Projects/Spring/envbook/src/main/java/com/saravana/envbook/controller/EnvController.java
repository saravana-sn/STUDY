package com.saravana.envbook.controller;

import com.saravana.envbook.model.Env;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/env")
public class EnvController {
    private Map<Long, Env> envMap = new HashMap<>();

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
