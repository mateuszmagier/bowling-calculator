/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bsi3_bowling;

import java.util.List;

/**
 *
 * @author HP
 */
public class Bowling {
    
    List<Frame> frames;
    
    public Bowling() {}
    
    public Bowling(List<Frame> _frames) throws Exception {
        if(_frames.size() < 10 || _frames.size() > 12)
            throw new Exception("Liczba rund musi być równa 10, 11 lub 12.");
        frames = _frames;
    }
    
    public int calculateResult() {
        int result = 0;
        boolean lastStrike = false;
        boolean lastSpare = false;
        Frame f, nextFrame, nextToNextFrame;
        
        if(frames.size() == 12)
            lastStrike = true;
        if(frames.size() == 11)
            lastSpare = true;
        
        for(int i = 0; i < 10; i++) {
            f = frames.get(i);
            
            result += f.sum();
            
            if(f.getFirstThrow() == 10) { // strike
                if(i < 8 || lastStrike) {
                    nextFrame = frames.get(i+1);
                    result += nextFrame.sum();
                    if(nextFrame.getFirstThrow() == 10 || lastStrike) {
                        nextToNextFrame = frames.get(i+2);
                        result += nextToNextFrame.getFirstThrow();
                    }
                }
            }
            else if(f.sum() == 10) { // spare
                if(i < 9 || lastSpare) {
                    nextFrame = frames.get(i+1);
                    result += nextFrame.getFirstThrow();
                }
            }
        }
        
        return result;
    }
}
