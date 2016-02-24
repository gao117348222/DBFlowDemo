package com.gx303.dbflowdemo.bean;


import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

/**
 * Created by Administrator on 2016/2/24.
 */
@Table(database = ColonyDatabase.class)
public class A extends BaseModel {
    @PrimaryKey(autoincrement = true)
    long id;
    @Column
    String nameA;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNameA() {

        return nameA;
    }

    public void setNameA(String nameA) {
        this.nameA = nameA;
    }
}
