package com.gx303.dbflowdemo.bean;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Administrator on 2016/2/24.
 */
@Table(database = ColonyDatabase.class)
public class BeanC extends BaseModel {
    @PrimaryKey(autoincrement = true)
    long id;
    @Column
    @ForeignKey(saveForeignKeyModel = false)
    A a1;

    public A getA1() {
        return a1;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setA1(A a1) {
        this.a1 = a1;
    }
}
