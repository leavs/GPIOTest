package com.chipsee.gpiodemo;

import android.widget.ImageView;

/**
 * Created by Chipsee on 2017/8/10.
 */

public class GPIO {
    private int gpioNum;
    private int gpioValue;
    private String gpioDirection;
    private int gpioImageID;
    private int gpioSwitchID;

    // For Input GPIO
    public GPIO(int gpioNum, int gpioImageID) {
        super();
        this.gpioNum = gpioNum;
        this.gpioImageID = gpioImageID;
    }

    // For Output GPIO
    public GPIO(int gpioNum, int gpioValue, int gpioSwitchID) {
        super();
        this.gpioNum = gpioNum;
        this.gpioValue = gpioValue;
        this.gpioSwitchID = gpioSwitchID;
    }

    public void setGPIONum(int gpioNum){
        this.gpioNum = gpioNum;
    }

    public int getGPIONum(){
        return gpioNum;
    }

    public void setGPIOValue(int gpioValue){
        this.gpioValue = gpioValue;
    }

    public int getGPIOValue(){
        return gpioValue;
    }

    public void setGPIODirection(String gpioDirection){
        this.gpioDirection = gpioDirection;
    }

    public String getGPIODirection(){
        return gpioDirection;
    }

    public void setGPIOImageID(int gpioImageID){
        this.gpioImageID = gpioImageID;
    }

    public int getGPIOImageID(){
        return gpioImageID;
    }

    public void setGPIOSwitchID(int gpioSwitchID){
        this.gpioSwitchID = gpioSwitchID;
    }

    public int getGPIOSwitchID(){
        return gpioSwitchID;
    }
}
