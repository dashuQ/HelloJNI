package com.huishouge.hellojni.jni;

/**
 * Created by lenovo on 2017/4/19.
 */

public class JniUtil {

    static{
        System.loadLibrary("hello");//jni模块加载名称
    }

    public native String helloFromC();//这个方法AS会报红，不用管是这样的

}
//javah -d jni -classpath D:\Android\sdk\platforms\android-14\android.jar;G:\AndroidStudioProjects20170410\HelloJNI\app\build\intermediates\classes\debug com.huishouge.hellojni.jni.JniUtil