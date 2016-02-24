package com.gx303.dbflowdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.gx303.dbflowdemo.bean.A;
import com.gx303.dbflowdemo.bean.A_Table;
import com.gx303.dbflowdemo.bean.BeanC;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void insert_A(View v)
    {
        A a1=new A();
        a1.setNameA("呵呵123");
        a1.save();
    }
    public void select_A_all(View v)
    {
       List<A> alist= SQLite.select().from(A.class).queryList();
        if(alist==null)
        {
            return;
        }
        String result="";
        for (int i=0;i<alist.size();i++)
        {
            result+="id:"+alist.get(i).getId()+"|namea:"+alist.get(i).getNameA()+"\n";
        }
        T(result);

    }
    public void select_A(View v)
    {
        List<A> alist=SQLite.select().from(A.class).where(A_Table.id.eq(5)).queryList();
        if(alist==null)
        {
            return;
        }
        String result="";
        for (int i=0;i<alist.size();i++)
        {
            result+="id:"+alist.get(i).getId()+"|namea:"+alist.get(i).getNameA()+"\n";
        }
        T(result);
    }
    public void insert_C(View v)
    {
        //com.gx303.dbflowdemo.bean.C c1=new com.gx303.dbflowdemo.bean.A();
        BeanC c1=new BeanC();
        A a1=new A();
        a1.setNameA("C的");
        a1.save();
        c1.setA1(a1);
        c1.save();

    }
    public void select_C(View v)
    {
        List<BeanC> clist=SQLite.select().from(BeanC.class).queryList();
        if(clist==null)
        {
            return;
        }
        String result="";
        for(int i=0;i<clist.size();i++)
        {
            result+="C_ID:"+clist.get(i).getId()+" 其中A_ID:"+clist.get(i).getA1().getId()+" A_Name:"+clist.get(i).getA1().getNameA()+"\n";
        }
        T(result);

    }
    public void T(final String s)
    {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(getApplicationContext(),s,Toast.LENGTH_SHORT).show();
            }
        });
    }
    public void L(String s)
    {
        Log.e("Unity",s);
    }
}
