package com.diegolopes.paysim;

import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

import com.diegolopes.paysim.services.SELIC;

@SpringBootTest
public class SELICTest {
    
    @Test
    public void testCurrent() {
        final double value = SELIC.current();
        assertTrue(() -> value > 0.0);
    }

    @Test
    public void testAccumulated() {
        final double accum = SELIC.accumulated30Days();
        assertTrue(() -> accum > 0.0);
    }

}
