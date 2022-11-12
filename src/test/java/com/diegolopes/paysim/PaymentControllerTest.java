package com.diegolopes.paysim;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.diegolopes.paysim.controller.PaymentController;
import com.diegolopes.paysim.model.InstallmentDefinition;
import com.diegolopes.paysim.model.Payment;
import com.diegolopes.paysim.model.PaymentPayload;
import com.diegolopes.paysim.model.Product;

@SpringBootTest
public class PaymentControllerTest {
    
    @Test
    public void testPayment() {
        final PaymentPayload input = new PaymentPayload(
            new Payment(2500.0, 12),
            new Product(123, "Black Scooter", 5000.0)
        );
        
        final PaymentController ctrl = new PaymentController();
        final ResponseEntity<ArrayList<InstallmentDefinition>> res = ctrl.performPayment(input);

        assertEquals(200, res.getStatusCodeValue());
        assertNotNull(res.getBody());
        assertTrue(!res.getBody().isEmpty());
        assertTrue(res.getBody().size() == 13);
    }

}
