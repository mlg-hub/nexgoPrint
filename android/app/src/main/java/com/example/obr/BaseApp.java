package com.example.obr;

import com.nexgo.oaf.apiv3.APIProxy;
import com.nexgo.oaf.apiv3.DeviceEngine;
import io.flutter.app.FlutterApplication;

public class BaseApp extends FlutterApplication {
    public DeviceEngine deviceEngine;
    @Override
    public void onCreate() {
        super.onCreate();
        deviceEngine = APIProxy.getDeviceEngine(this);
        deviceEngine.getEmvHandler("app2");
    }
}
