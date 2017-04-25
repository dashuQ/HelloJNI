//
// Created by lenovo on 2017/4/19.
//

#include<jni.h>
#include<com_huishouge_hellojni_jni_JniUtil.h>
jstring Java_com_huishouge_hellojni_jni_JniUtil_helloFromC(JNIEnv* env,jobject thiz){
    char* cstr="hello from c!";
    return (*env)->NewStringUTF(env,cstr);
}
//简写
//javah -d jni -classpath D:\Android\sdk\platforms\android-14\android.jar;..\..\build\intermediates\classes\debug com.huishouge.hellojni.jni.JniUtil
//全写
//javah -d jni -classpath D:\Android\sdk\platforms\android-14\android.jar;G:\AndroidStudioProjects20170410\HelloJNI\app\build\intermediates\classes\debug com.huishouge.hellojni.jni.JniUtil