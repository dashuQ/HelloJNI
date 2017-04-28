package com.huishouge.hellojni.jni;

/**
 * Created by lenovo on 2017/4/19.
 */

public class JniUtil {

    static {
        System.loadLibrary("hello");//jni模块加载名称
    }

    public native String helloFromC();//这个方法AS会报红，不用管是这样的

    public native int add(int x, int y);//

    public native String updateStr(String str);//


}

/*
1.在app\src\main\java下
执行javah com.*.JniUtil
javah com.huishouge.hellojni.jni.JniUtil
注意：提示“错误: 编码GBK的不可映射字符”不用管它
2.在项目build/intermaediates/class/debug下
执行javah -classpath . -jni 类完整路径.jni类
javah -classpath . -jni com.huishouge.hellojni.jni.JniUtil
*/

//简写
//javah -d jni -classpath D:\Android\sdk\platforms\android-14\android.jar;..\..\build\intermediates\classes\debug com.huishouge.hellojni.jni.JniUtil
//全写
//javah -d jni -classpath D:\Android\sdk\platforms\android-14\android.jar;G:\AndroidStudioProjects20170410\HelloJNI\app\build\intermediates\classes\debug com.huishouge.hellojni.jni.JniUtil
//javah -d jni -classpath D:\Android\sdk\platforms\android-14\android.jar;G:\AndroidStudioProjects20170410\HelloJNI\app\build\intermediates\classes\debug com.huishouge.hellojni.jni.JniUtil



