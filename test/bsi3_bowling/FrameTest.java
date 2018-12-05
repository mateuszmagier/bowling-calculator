/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsi3_bowling;

import junitparams.JUnitParamsRunner;
import junitparams.Parameters;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.runner.RunWith;

/**
 *
 * @author HP
 */
@RunWith(JUnitParamsRunner.class)
public class FrameTest {
    
    public FrameTest() {
    }

    @Before
    public void beforeTest() {
        
    }
    
    /*
        testy konstruktora
    */
    
    @Test
    public void testFrame_ThrowsAreCorrect_NotNullObject() throws Exception {
        Frame f = new Frame(6,3);
        assertNotNull(f);
    }
    
    /*
        testy getterów i setterów
    */
    
    @Test
    public void testGetFirstThrow_ReturnedFirstThrow() throws Exception {
        int expected = 4;
        Frame f = new Frame(expected, 2);
        
        int result = f.getFirstThrow();
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testSetFirstThrow_FirstThrowUpdated() throws Exception {
        int expected = 4;
        Frame f = new Frame(3,6);
        
        f.setFirstThrow(expected);
        
        int result = f.getFirstThrow();
        assertEquals(expected, result);
    }
    
    @Test
    public void testGetSecondThrow_ReturnedSecondThrow() throws Exception {
        int expected = 4;
        Frame f = new Frame(2, expected);
        
        int result = f.getSecondThrow();
        
        assertEquals(expected, result);
    }
    
    @Test
    public void testSetSecondThrow_SecondThrowUpdated() throws Exception {
        int expected = 4;
        Frame f = new Frame(3,6);
        
        f.setSecondThrow(expected);
        
        int result = f.getSecondThrow();
        assertEquals(expected, result);
    }
    
    /*
        testy validateThrows(int, int)
    */
    
    @Test
    @Parameters({"4,7", "2,10", "5,6"})
    public void testValidateThrows_ThrowsSumIsGreaterThanTen_Exception(int a, int b) {
        String expectedMsg = "Błąd: Suma rzutów w rundzie jest większa od 10.";
        String msg = "";
        try {
            Frame.validateThrows(a,b);
        }
        catch(Exception ex) {
            msg = ex.getMessage();
        }
        assertEquals(expectedMsg, msg);
    }
    
    @Test
    @Parameters({"-1,7", "2,-3", "-5,-4"})
    public void testValidateThrows_ThrowIsNegativeNumber_Exception(int a, int b) {
        String expectedMsg = "Błąd: Wartość rzutu nie może być liczbą ujemną.";
        String msg = "";
        try {
            Frame.validateThrows(a,b);
        }
        catch(Exception ex) {
            msg = ex.getMessage();
        }
        assertEquals(expectedMsg, msg);
    }
    
    /*
        testy sum()
    */
    
    @Test
    @Parameters({"3,5,8", "10,0,10", "3,7,10","1,2,3"})
    public void testSum_ThrowsAreCorrect_ReturnedCorrectSum(int a, int b, int expected) throws Exception {
        Frame f = new Frame(a, b);
        
        int result = f.sum();
        
        assertEquals(expected, result);
    }
}
