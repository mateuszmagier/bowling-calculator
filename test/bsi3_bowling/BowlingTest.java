/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsi3_bowling;

import java.util.ArrayList;
import java.util.List;
import junitparams.JUnitParamsRunner;
import static junitparams.JUnitParamsRunner.$;
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
public class BowlingTest {
    
    List<Frame> incorrectFramesList;
    
    public BowlingTest() {
    }

    @Before
    public void beforeTest() throws Exception {
        incorrectFramesList = new ArrayList<>();
    }
    
    /*
        testy konstruktora
    */
    
    @Test
    public void testBowling_NotNullObject() {
        Bowling b = new Bowling();
        assertNotNull(b);
    }
    
    @Test
    @Parameters({"0", "6", "9", "13", "15"})
    public void testBowling_FramesListIsIncorrect_Exception(int listSize) throws Exception {
        String expectedMsg = "Liczba rund musi być równa 10, 11 lub 12.";
        String msg = "";
        Bowling b = null;
        for(int i = 1; i <= listSize; i++)
            incorrectFramesList.add(new Frame(4,5));
        
        try {
            b = new Bowling(incorrectFramesList);
        }
        catch(Exception ex) {
            msg = ex.getMessage();
        }
        
        assertEquals(expectedMsg, msg);
        assertNull(b);
    }
    
    @Test
    public void testBowling_FramesListIsCorrect_NotNullObject() throws Exception {
        for(int i = 1; i <= 10; i++)
            incorrectFramesList.add(new Frame(4,5));
            
        Bowling b = new Bowling(incorrectFramesList);
        
        assertNotNull(b);
    }
    
    /*
        calculateResult()
    */
    
    @Test
    @Parameters(method = "parametersFor_FramesWithoutAnyExceptions")
    public void testCalculateResult_FramesWithoutAnyExceptions_ResultCalculatedCorrectly(List<Frame> frames, int expected) throws Exception {
        int result;
        Bowling b = new Bowling(frames);
        
        result = b.calculateResult();
        
        assertEquals(expected, result);
    }
    
    @Test
    @Parameters(method = "parametersFor_ThreeStrikes")
    public void testCalculateResult_ThreeStrikes_ResultCalculatedCorrectly(List<Frame> frames, int expected) throws Exception {
        int result;
        Bowling b = new Bowling(frames);
        
        result = b.calculateResult();
        
        assertEquals(expected, result);
    }
    
    @Test
    @Parameters(method = "parametersFor_TenStrikesAndNonStrikesBonusFrames")
    public void testCalculateResult_TenStrikesAndNonStrikeBonusFrames_ResultCalculatedCorrectly(List<Frame> frames, int expected) throws Exception {
        int result;
        Bowling b = new Bowling(frames);
        
        result = b.calculateResult();
        
        assertEquals(expected, result);
    }
    
    @Test
    @Parameters(method = "parametersFor_TenStrikesPlusBonusStrikes")
    public void testCalculateResult_TenStrikesPlusBonusStrikes_ResultCalculatedCorrectly(List<Frame> frames, int expected) throws Exception {
        int result;
        Bowling b = new Bowling(frames);
        
        result = b.calculateResult();
        
        assertEquals(expected, result);
    }
    
    @Test
    @Parameters(method = "parametersFor_LastFrameIsStrike")
    public void testCalculateResult_LastFrameIsStrike_ResultCalculatedCorrectly(List<Frame> frames, int expected) throws Exception {
        int result;
        Bowling b = new Bowling(frames);
        
        result = b.calculateResult();
        
        assertEquals(expected, result);
    }
    
    @Test
    @Parameters(method = "parametersFor_ThreeSpares")
    public void testCalculateResult_ThreeSpares_ResultCalculatedCorrectly(List<Frame> frames, int expected) throws Exception {
        int result;
        Bowling b = new Bowling(frames);
        
        result = b.calculateResult();
        
        assertEquals(expected, result);
    }
    
    @Test
    @Parameters(method = "parametersFor_LastFrameIsSpare")
    public void testCalculateResult_LastFrameIsSpare_ResultCalculatedCorrectly(List<Frame> frames, int expected) throws Exception {
        int result;
        Bowling b = new Bowling(frames);
        
        result = b.calculateResult();
        
        assertEquals(expected, result);
    }
    
    @Test
    @Parameters(method = "parametersFor_TwoStrikesFourSpares")
    public void testCalculateResult_TwoStrikesFourSpares_ResultCalculatedCorrectly(List<Frame> frames, int expected) throws Exception {
        int result;
        Bowling b = new Bowling(frames);
        
        result = b.calculateResult();
        
        assertEquals(expected, result);
    }
    
    @Test
    @Parameters(method = "parametersFor_TenSpares")
    public void testCalculateResult_TenSpares_ResultCalculatedCorrectly(List<Frame> frames, int expected) throws Exception {
        int result;
        Bowling b = new Bowling(frames);
        
        result = b.calculateResult();
        
        assertEquals(expected, result);
    }
    
    /*
        METODY POMOCNICZE
    */
    private Object[] parametersFor_FramesWithoutAnyExceptions() throws Exception {
        int[] _throws = {3,6, 2,7, 1,5, 4,4, 9,0, 0,7, 1,6, 2,2, 7,1, 4,3};
        int expected = 74;
        
        List<Frame> frames = prepareFrames(_throws);
        
        return $($(frames, expected));
    }
    
    private Object[] parametersFor_ThreeStrikes() throws Exception {
        int[] _throws = {10,0, 2,7, 1,5, 4,4, 10,0, 0,7, 10,0, 2,2, 7,1, 4,3};
        int expected = 99;
        
        List<Frame> frames = prepareFrames(_throws);
        
        return $($(frames, expected));
    }
    
    private Object[] parametersFor_TenStrikesAndNonStrikesBonusFrames() throws Exception {
        int[] _throws = {10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 5,0, 3,0};
        int expected = 283;
        
        List<Frame> frames = prepareFrames(_throws);
        
        return $($(frames, expected));
    }
    
    private Object[] parametersFor_TenStrikesPlusBonusStrikes() throws Exception {
        int[] _throws = {10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0, 10,0};
        int expected = 300;
        
        List<Frame> frames = prepareFrames(_throws);
        
        return $($(frames, expected));
    }
    
    private Object[] parametersFor_LastFrameIsStrike() throws Exception {
        int[] _throws = {5,3, 9,0, 4,4, 1,7, 1,5, 3,4, 6,2, 2,0, 3,6, 10,0, 5,0, 3,0};
        int expected = 83;
        
        List<Frame> frames = prepareFrames(_throws);
        
        return $($(frames, expected));
    }
    
    private Object[] parametersFor_ThreeSpares() throws Exception {
        int[] _throws = {5,5, 9,0, 4,1, 3,7, 1,5, 3,4, 6,4, 2,0, 3,6, 3,6};
        int expected = 89;
        
        List<Frame> frames = prepareFrames(_throws);
        
        return $($(frames, expected));
    }
    
    private Object[] parametersFor_LastFrameIsSpare() throws Exception {
        int[] _throws = {5,4, 9,0, 4,1, 2,7, 1,5, 3,4, 2,4, 2,0, 3,6, 3,7, 9,0};
        int expected = 81;
        
        List<Frame> frames = prepareFrames(_throws);
        
        return $($(frames, expected));
    }
    
    private Object[] parametersFor_TwoStrikesFourSpares() throws Exception {
        int[] _throws = {10,0, 9,1, 4,1, 10,0, 1,5, 3,7, 2,8, 2,0, 3,6, 3,7, 9,0};
        int expected = 115;
        
        List<Frame> frames = prepareFrames(_throws);
        
        return $($(frames, expected));
    }
    
    private Object[] parametersFor_TenSpares() throws Exception {
        int[] _throws = {7,3, 9,1, 9,1, 2,8, 5,5, 3,7, 2,8, 4,6, 4,6, 3,7, 7,0};
        int expected = 148;
        
        List<Frame> frames = prepareFrames(_throws);
        
        return $($(frames, expected));
    }
    
    private List<Frame> prepareFrames(int[] _throws) throws Exception {
        List<Frame> frames = new ArrayList<>();
        int j = 0;
        while(j < _throws.length - 1) {
            frames.add(new Frame(_throws[j], _throws[j+1]));
            j += 2;
        }
        return frames;
    }
    
}