//
// Created by lenovo on 2017/4/19.
//

#include<com_huishouge_hellojni_jni_JniUtil.h>
#include<string.h>

/**
 * java字符串转C的字符指针
 * @param env
 * @param jstr
 * @return
 */
char *Jstring2CStr(JNIEnv *env, jstring jstr) {
    char *rtn = NULL;
    jclass clsstring = (*env)->FindClass(env, "java/lang/String");
    jstring strencode = (*env)->NewStringUTF(env, "GB2312");
    jmethodID mid = (*env)->GetMethodID(env, clsstring, "getBytes", "(Ljava/lang/String;)[B");
    jbyteArray barr = (jbyteArray)(*env)->CallObjectMethod(env, jstr, mid,strencode); // String .getByte("GB2312");
    jsize alen = (*env)->GetArrayLength(env, barr);
    jbyte *ba = (*env)->GetByteArrayElements(env, barr, JNI_FALSE);
    if (alen > 0) {
        rtn = (char *) malloc(alen + 1);         //"\0"
        memcpy(rtn, ba, alen);
        rtn[alen] = 0;
    }
    (*env)->ReleaseByteArrayElements(env, barr, ba, 0);  //
    return rtn;
}

JNIEXPORT jstring Java_com_huishouge_hellojni_jni_JniUtil_helloFromC(JNIEnv *env, jobject thiz) {
    char *cstr = "hello from c!";
    return (*env)->NewStringUTF(env, cstr);
}

JNIEXPORT jint Java_com_huishouge_hellojni_jni_JniUtil_add(JNIEnv *env, jobject thiz, jint x, jint y) {

    int result = x + y;
    return result;
}

JNIEXPORT jstring JNICALL Java_com_huishouge_hellojni_jni_JniUtil_updateStr
        (JNIEnv *env, jobject thiz, jstring jstr) {

    char *charPointFromJava = Jstring2CStr(env, jstr);//_JString2Str看不懂不会写先不管
    char *charPointFromC = "i m from C";
    //strcat();string.h中strcat()方法拼接结果放在第一个参数里
    strcat(charPointFromJava, charPointFromC);//使用此方法拼接字符串

    return (*env)->NewStringUTF(env, charPointFromJava);
}

