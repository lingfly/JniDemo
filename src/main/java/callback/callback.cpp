#include <jni.h>
#include<iostream>
#include"callback_CallbackJNI.h"

using namespace std;
// 保存 Java 回调对象的引用
static jobject javaCallback;

JNIEXPORT void JNICALL Java_callback_CallbackJNI_setCallback(JNIEnv *env, jobject obj, jobject callback) {
    // 保存 Java 回调对象的引用
    javaCallback = env->NewGlobalRef(callback);
}

JNIEXPORT void JNICALL Java_callback_CallbackJNI_handle(JNIEnv *env, jobject obj, jint num) {
    // 调用 Java 回调方法
    jclass callbackClass = env->GetObjectClass(javaCallback);
    cout<<callbackClass<<endl;
    jmethodID callbackMethod = env->GetMethodID(callbackClass, "onCallback", "(I)V");
    env->CallVoidMethod(javaCallback, callbackMethod, num);

}
