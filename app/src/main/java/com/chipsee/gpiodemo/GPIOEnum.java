package com.chipsee.gpiodemo;

/**
 * Created by Chipsee on 2017/8/10.
 */

public class GPIOEnum {

    //Direction
    public final static int IN = 1;
    public final static int OUT = 2;

    //Value
    public final static int LOW = 0;
    public final static int HIGH = 1;

    /*For COMAC Board Uncomment Follow */
//    //INPUT GPIO
//    public final static int GPIO1 = 49;
//    public final static int GPIO2 = 50;
//    public final static int GPIO3 = 51;
//    public final static int GPIO4 = 52;
//    public final static int GPIO5 = 53;
//    public final static int GPIO6 = 54;
//
//    //OUTPUT GPIO
//    public final static int GPIO7 = 55;
//    public final static int GPIO8 = 56;
//    public final static int GPIO9 = 57;
//    public final static int GPIO10 = 58;

    /* For Normal Board Uncomment Follow */
    // OUTPUT GPIO
    public final static int GPIO1 = 49;
    public final static int GPIO2 = 50;
    public final static int GPIO3 = 51;
    public final static int GPIO4 = 52;

    // INPUT GPIO
    public final static int GPIO5 = 53;
    public final static int GPIO6 = 54;
    public final static int GPIO7 = 55;
    public final static int GPIO8 = 56;
    /* Normal Board has no these two gpio, enable it to be compatible with COMMAC Board */
    public final static int GPIO9 = 57;
    public final static int GPIO10 = 58;


}