package com.gx303.dbflowdemo;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;


/**
 * Created by Administrator on 2016/2/24.
 */
public class ExampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
