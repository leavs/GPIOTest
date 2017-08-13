package com.chipsee.gpiodemo;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    private Timer timer = new Timer();
    static int j;

    private ImageView imageViewInput;
    private Switch switchOutput7;
    private Switch switchOutput8;
    private Switch switchOutput9;
    private Switch switchOutput10;

    ArrayList<GPIO> gpioInList;
    ArrayList<GPIO> gpioOutList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer.schedule(timerTask,100,100);

        /* If your board changed , please modify this */
        //init_COMAC_GPIO();
        init_Normal_GPIO();

        switchOutput7 = (Switch) findViewById(R.id.switchOutput7);
        switchOutput7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if((HardwareControler.setGPIOValue(gpioOutList.get(0).getGPIONum(),GPIOEnum.HIGH)) < 0 )
                        Log.e(TAG, "onCheckedChanged: setGPIOValue 1 error for gpio"+gpioOutList.get(0).getGPIONum());
                }else{
                    if((HardwareControler.setGPIOValue(gpioOutList.get(0).getGPIONum(),GPIOEnum.LOW)) <0 )
                        Log.e(TAG, "onCheckedChanged: setGPIOValue 0 error for gpio"+gpioOutList.get(0).getGPIONum());
                }
            }
        });

        switchOutput8 = (Switch) findViewById(R.id.switchOutput8);
        switchOutput8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if((HardwareControler.setGPIOValue(gpioOutList.get(1).getGPIONum(),GPIOEnum.HIGH)) < 0 )
                        Log.e(TAG, "onCheckedChanged: setGPIOValue 1 error for gpio"+gpioOutList.get(1).getGPIONum());
                }else{
                    if((HardwareControler.setGPIOValue(gpioOutList.get(1).getGPIONum(),GPIOEnum.LOW)) <0 )
                        Log.e(TAG, "onCheckedChanged: setGPIOValue 0 error for gpio"+gpioOutList.get(1).getGPIONum());
                }
            }
        });

        switchOutput9 = (Switch) findViewById(R.id.switchOutput9);
        switchOutput9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if((HardwareControler.setGPIOValue(gpioOutList.get(2).getGPIONum(),GPIOEnum.HIGH)) < 0 )
                        Log.e(TAG, "onCheckedChanged: setGPIOValue 1 error for gpio"+gpioOutList.get(2).getGPIONum());
                }else{
                    if((HardwareControler.setGPIOValue(gpioOutList.get(2).getGPIONum(),GPIOEnum.LOW)) <0 )
                        Log.e(TAG, "onCheckedChanged: setGPIOValue 0 error for gpio"+gpioOutList.get(2).getGPIONum());
                }
            }
        });

        switchOutput10 = (Switch) findViewById(R.id.switchOutput10);
        switchOutput10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    if((HardwareControler.setGPIOValue(gpioOutList.get(3).getGPIONum(),GPIOEnum.HIGH)) < 0 )
                        Log.e(TAG, "onCheckedChanged: setGPIOValue 1 error for gpio"+gpioOutList.get(3).getGPIONum());
                }else{
                    if((HardwareControler.setGPIOValue(gpioOutList.get(3).getGPIONum(),GPIOEnum.LOW)) <0 )
                        Log.e(TAG, "onCheckedChanged: setGPIOValue 0 error for gpio"+gpioOutList.get(3).getGPIONum());
                }
            }
        });

    }

    private Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    for(int i=0; i<gpioInList.size(); i++){
                        imageViewInput = (ImageView) findViewById(gpioInList.get(i).getGPIOImageID());
                        if(HardwareControler.getGPIOValue(gpioInList.get(i).getGPIONum()) == GPIOEnum.LOW)
                            imageViewInput.setImageResource(R.drawable.io_low);
                        else {
                            if((HardwareControler.getGPIOValue(gpioInList.get(i).getGPIONum())) < 0 )
                                Log.e(TAG, "handleMessage: getGPIOValue Error!!");
                            else
                                imageViewInput.setImageResource(R.drawable.io_high);
                        }
                    }

                    break;
            }
            super.handleMessage(msg);
        }
    };

    private TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }
    };

    /* FOR COMAC BOARD*/
    private void init_COMAC_GPIO(){
        // Input GPIO
        gpioInList = new ArrayList<GPIO>();
        GPIO gpio = new GPIO(GPIOEnum.GPIO1,R.id.imageViewInput1);
        gpioInList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO2,R.id.imageViewInput2);
        gpioInList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO3,R.id.imageViewInput3);
        gpioInList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO4,R.id.imageViewInput4);
        gpioInList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO5,R.id.imageViewInput5);
        gpioInList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO6,R.id.imageViewInput6);
        gpioInList.add(gpio);

        // Output GPIO
        gpioOutList = new ArrayList<GPIO>();
        gpio = new GPIO(GPIOEnum.GPIO7,GPIOEnum.LOW,R.id.switchOutput7);
        gpioOutList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO8,GPIOEnum.LOW,R.id.switchOutput8);
        gpioOutList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO9,GPIOEnum.LOW,R.id.switchOutput9);
        gpioOutList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO10,GPIOEnum.LOW,R.id.switchOutput10);
        gpioOutList.add(gpio);

        for (int i=0; i<gpioOutList.size(); i++){
            if((HardwareControler.setGPIOValue(gpioOutList.get(i).getGPIONum(),GPIOEnum.LOW)) < 0 )
                Log.e(TAG, "init_COMAC_GPIO: setGPIOValue 0 error for gpio"+gpioOutList.get(i).getGPIONum());
        }
    }

    private void init_Normal_GPIO(){
        // Input GPIO
        gpioInList = new ArrayList<GPIO>();
        GPIO gpio = new GPIO(GPIOEnum.GPIO5,R.id.imageViewInput1);
        gpioInList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO6,R.id.imageViewInput2);
        gpioInList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO7,R.id.imageViewInput3);
        gpioInList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO8,R.id.imageViewInput4);
        gpioInList.add(gpio);

        // Output GPIO
        gpioOutList = new ArrayList<GPIO>();
        gpio = new GPIO(GPIOEnum.GPIO1,GPIOEnum.LOW,R.id.switchOutput7);
        gpioOutList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO2,GPIOEnum.LOW,R.id.switchOutput8);
        gpioOutList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO3,GPIOEnum.LOW,R.id.switchOutput9);
        gpioOutList.add(gpio);
        gpio = new GPIO(GPIOEnum.GPIO4,GPIOEnum.LOW,R.id.switchOutput10);
        gpioOutList.add(gpio);

        for (int i=0; i<gpioOutList.size(); i++){
            if((HardwareControler.setGPIOValue(gpioOutList.get(i).getGPIONum(),GPIOEnum.LOW)) < 0 )
                Log.e(TAG, "init_Normal_GPIO: setGPIOValue 0 error for gpio"+gpioOutList.get(i).getGPIONum());
        }
    }

    @Override
    public void onDestroy() {
        timer.cancel();
        super.onDestroy();
    }

}
