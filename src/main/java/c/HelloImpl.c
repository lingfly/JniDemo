#include<jni.h>
#include<stdio.h>
#include"meta_HelloMeta.h"

JNIEXPORT void JNICALL Java_meta_HelloMeta_hello(JNIEnv *env, jobject thisObj) {
    printf("hello\n");

}
