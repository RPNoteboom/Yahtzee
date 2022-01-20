/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import constants.Constants;
import java.util.Random;

/**
 *
 * @author Richard Noteboom
 */
public class Die {

    /**
     * @return the faceValue
     */
    public int getFaceValue() {
        return faceValue;
    }

    /**
     * @param faceValue the faceValue to set
     */
    public void setFaceValue(int faceValue) {
        this.faceValue = faceValue;
    }
    private int faceValue;
    
    public void rollDie() {
        Random random = new Random();
        faceValue = random.nextInt(Constants.MAX_DIE_VALUE) + 1;
    }
    
}
