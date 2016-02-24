###1. 项目gradle增加mave地址
```java
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```
###2. app gradle增加以下代码
``` java
apply plugin: 'com.neenbedankt.android-apt'
def dbflow_version = "3.0.0-beta3"
dependencies {


    apt "com.github.Raizlabs.DBFlow:dbflow-processor:${dbflow_version} "
    compile "com.github.Raizlabs.DBFlow:dbflow-core:${dbflow_version} "
    compile "com.github.Raizlabs.DBFlow:dbflow:${dbflow_version} "

    // sql-cipher database encyrption (optional)
    compile "com.github.Raizlabs.DBFlow:dbflow-sqlcipher:${dbflow_version} "
}
```
###3. 在application中增加DBFlow初始化
``` java
FlowManager.init(this);
```
###4. 增加数据库base类
```java 
@Database(name=ColonyDatabase.NAME,version = ColonyDatabase.VERSION)
public class ColonyDatabase {
    public static final String NAME="DBFlowDemo";
    public static final int VERSION=1 ;
}
```
###5.增加其他数据库类
```java 
@Table(database = ColonyDatabase.class)
public class A extends BaseModel {
    @PrimaryKey (autoincrement = true)
    long id;
    @Column
    String nameA;
}
```
###6.常用代码
增加一行
```java
A a1=new A();
//设置属性值
a1.save();
```
查询
List<A> alist=SQLite.select().from(A.class).where(A_Table.id.eq( 5)).queryList();

###7.外链
```java
@Table(database = ColonyDatabase.class)
public class BeanC extends BaseModel {
    @PrimaryKey (autoincrement = true)
    long id;
    @Column
    @ForeignKey(saveForeignKeyModel = false)
    A a1 ;

    public A getA1() {
        return a1;
    }

    public void setA1(A a1) {
        this .a1 = a1;
    }
```

插入代码
```java
BeanC c1=new BeanC();
A a1=new A();
a1.setNameA("C的" );
a1.save();
c1.setA1(a1);
c1.save();
}
```
