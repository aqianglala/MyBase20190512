package com.example.mybase20190512.app;

import android.app.Application;

public class ExampleApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://192.168.31.80:20002/api/")
                .configure();
    }
}
