package com.diegolopes.paysim;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.diegolopes.paysim.controller.AuthController;
import com.diegolopes.paysim.model.User;

@SpringBootTest
public class AuthControllerTest {
    
    @Test
    public void createUser() {
        final AuthController ctrl = new AuthController();
        final ResponseEntity<JSONObject> res = ctrl.createUser(new User("test@test.com", "password123"));

        assertTrue(res.getStatusCodeValue() == 200);
        assertTrue(res.getBody().optInt("id", 0) != 0);
    }

}
