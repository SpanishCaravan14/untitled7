package org.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import static org.junit.Assert.*;
@RunWith(Parameterized.class)
public class PalindromServiceTest {

    final String testString;
    final boolean expected;
    public PalindromServiceTest(String testString, boolean expected){
        this.testString = testString;
        this.expected = expected;
    }

    @Parameterized.Parameters
    public static Object[][] provideTestString(){
        return new Object[][]{
                {"NotPali", false},
                {"Ma am", false},
                {"ma aM", false},
                {"maam", true},
                {"ma am", true},
                {"q", true}
        };
    }

    @Test
    public void isPalindrome() {
        PalindromService palindromService = new PalindromService();
        boolean actual = palindromService.isPalindrome(testString);
        assertEquals(expected, actual);
    }
}