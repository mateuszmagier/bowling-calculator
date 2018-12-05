/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsi3_bowling;

/**
 *
 * @author HP
 */
public class Frame {
    int firstThrow;
    int secondThrow;
    
    public Frame(int _firstThrow, int _secondThrow) throws Exception {
        validateThrows(_firstThrow, _secondThrow);
        firstThrow = _firstThrow;
        secondThrow = _secondThrow;
    }
    
    public int getFirstThrow() {
        return firstThrow;
    }
    
    public void setFirstThrow(int _firstThrow) throws Exception {
        validateThrows(_firstThrow, secondThrow);
        firstThrow = _firstThrow;
    }
    
    public int getSecondThrow() {
        return secondThrow;
    }
    
    public void setSecondThrow(int _secondThrow) throws Exception {
        validateThrows(firstThrow, _secondThrow);
        secondThrow = _secondThrow;
    }
    
    public static void validateThrows(int a, int b) throws Exception {
        if(a + b > 10)
            throw new Exception("Błąd: Suma rzutów w rundzie jest większa od 10.");
        if(a < 0 || b < 0)
            throw new Exception("Błąd: Wartość rzutu nie może być liczbą ujemną.");
    }
    
    public int sum() {
        return firstThrow + secondThrow;
    }
}
