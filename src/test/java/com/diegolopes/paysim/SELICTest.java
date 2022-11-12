package com.diegolopes.paysim;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.diegolopes.paysim.model.SELICTax;
import com.diegolopes.paysim.services.SELICTaxService;

@SpringBootTest
public class SELICTest {
    
    @Test
    public void testCurrent() {
        final SELICTax value = SELICTaxService.current();
        assertTrue(() -> value.getValue() > 0.0);
    }

    @Test
    public void testAccumulated() {
        final double accum = SELICTaxService.accumulated30Days();
        assertTrue(() -> accum > 0.0);
    }

}
