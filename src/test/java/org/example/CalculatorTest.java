package org.example;

import io.qameta.allure.junit4.DisplayName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class CalculatorTest {

    private int first;
    private int second;
    private int expected;

    public CalculatorTest(int first, int second, int expected) {
        this.first = first;
        this.second = second;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] getMultiplicationData(){
        return new Object[][]{
                {1, 2, 2},
                {1, 0, 0},
                {-1, -1, 1},
                {0,0,0},
                {-1, 1, -1}
        };
    }

    @org.junit.Test
    @DisplayName("Ясос Убибу")
    public void multiplicate() {
        Calculator calc = new Calculator();
        int actual = calc.multiplicate(first, second);
        assertEquals(expected, actual);
    }
}