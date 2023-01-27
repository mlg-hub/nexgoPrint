package com.example.obr;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.nexgo.oaf.apiv3.DeviceEngine;
import com.nexgo.oaf.apiv3.device.printer.AlignEnum;
import com.nexgo.oaf.apiv3.device.printer.OnPrintListener;
import com.nexgo.oaf.apiv3.device.printer.Printer;

import java.util.Objects;

import io.flutter.embedding.android.FlutterActivity;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.MethodChannel;

public class MainActivity extends FlutterActivity {
    private static final String CHANNEL = "flutter.native/nexgo";
    private DeviceEngine deviceEngine;
    private Printer printer;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        deviceEngine = ((BaseApp) getApplication()).deviceEngine;
        printer = deviceEngine.getPrinter();
    }

    @Override
    public void configureFlutterEngine(@NonNull FlutterEngine flutterEngine) {
        super.configureFlutterEngine(flutterEngine);
        new MethodChannel(flutterEngine.getDartExecutor().getBinaryMessenger(), CHANNEL)
                .setMethodCallHandler(
                        (call, result) -> {
                            if(Objects.equals(call.method, "printing")){
                                printer.initPrinter();
                                printer.appendPrnStr(
                                        "** morisho ** \n",
                                        30,
                                        AlignEnum.LEFT,
                                        true
                                );
                                printer.startPrint(false, new OnPrintListener() {       //roll paper or not
                                    @Override
                                    public void onPrintResult(final int retCode) {
                                        runOnUiThread(new Runnable() {
                                            @Override
                                            public void run() {

                                            }
                                        });
                                    }
                                });
                                result.success("morisho noma");
                            }
                        }
                );
    }
}
