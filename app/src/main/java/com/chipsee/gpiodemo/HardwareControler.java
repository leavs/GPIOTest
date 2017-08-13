package com.chipsee.gpiodemo;

import android.util.Log;

/**
 * Created by Chipsee on 2017/8/10.
 */

public class HardwareControler {
    private static final String TAG = "HardwareControler";

    /* GPIO */
    //GPIOEnum.LOW or GPIOEnum.HIGH
    static public native int setGPIOValue(int pin, int value);
    static public native int getGPIOValue(int pin);

    /* I2C */
    static public native int openI2CDevice();
    static public native int writeByteDataToI2C(int fd, int pos, byte byteData);
    static public native int readByteDataFromI2C(int fd, int pos);

    static {
        try {
            System.loadLibrary("chipsee-hardware");
        } catch (UnsatisfiedLinkError e) {
            Log.d(TAG, "libchipsee-hardware library not found!");
        }
    }
}
