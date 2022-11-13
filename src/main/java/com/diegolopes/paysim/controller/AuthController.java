package com.diegolopes.paysim.controller;

import org.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.diegolopes.paysim.model.User;

@RestController
@RequestMapping("auth")
public class AuthController {

    public ResponseEntity<JSONObject> createUser(User user) {
        return null;
    }
    


}
