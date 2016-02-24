package com.gx303.dbflowdemo.bean;


import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by Administrator on 2016/2/24.
 */
@Database(name=ColonyDatabase.NAME,version = ColonyDatabase.VERSION)
public class ColonyDatabase {
    public static final String NAME="DBFlowDemo";
    public static final int VERSION=1;
}
