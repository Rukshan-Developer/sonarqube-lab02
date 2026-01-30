package main.java.com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    private final Calculator calc = new Calculator();

    @Test
    void testAdd() {
        assertEquals(15, calc.calculate(10, 5, "add"));
        assertEquals(15, calc.calculate(10, 5, "add-again"));
    }

    @Test
    void testSub() {
        assertEquals(5, calc.calculate(10, 5, "sub"));
        assertEquals(5, calc.calculate(10, 5, "sub-again"));
    }

    @Test
    void testMul() {
        assertEquals(50, calc.calculate(10, 5, "mul"));
    }

    @Test
    void testDiv() {
        assertEquals(2, calc.calculate(10, 5, "div"));
        assertEquals(0, calc.calculate(10, 0, "div"));
    }

    @Test
    void testMod() {
        assertEquals(0, calc.calculate(10, 5, "mod"));
        assertEquals(1, calc.calculate(10, 3, "mod"));
    }

    @Test
    void testPow() {
        assertEquals(100, calc.calculate(10, 2, "pow"));
    }

    @Test
    void testUnknown() {
        assertEquals(0, calc.calculate(10, 5, "unknown"));
        assertEquals(0, calc.calculate(10, 5, null));
    }
}
