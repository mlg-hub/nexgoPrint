package com.example.obr;

import com.nexgo.oaf.apiv3.APIProxy;
import com.nexgo.oaf.apiv3.DeviceEngine;

import io.flutter.app.FlutterApplication;

public class BaseApp extends FlutterApplication {
    public DeviceEngine deviceEngine;
    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }
    private void init(){
        System.out.println("okay okay");
        deviceEngine = APIProxy.getDeviceEngine(this);
    }
}
