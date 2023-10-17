#include<jni.h>
#include<iostream>
#include"meta_HelloMetaCpp.h"
#include"request.h"

using namespace std;

JNIEXPORT jobject JNICALL Java_meta_HelloMetaCpp_hello(JNIEnv *env, jobject thisObj, jobject req) {
    jclass javaObjectClass = env->GetObjectClass(req);

    jfieldID field1Id = env->GetFieldID(javaObjectClass, "id", "Ljava/lang/Long;");
    jfieldID field2Id = env->GetFieldID(javaObjectClass, "name", "Ljava/lang/String;");

    Request request;
    if (field1Id == NULL) {
        cout << "id null" << endl;
    } else {
        jobject field1Obj = env->GetObjectField(req, field1Id);
        jclass field1Clazz = env->GetObjectClass(field1Obj);
        jmethodID field1Method = env->GetMethodID(field1Clazz, "longValue", "()J");
        jlong value = env->CallIntMethod(field1Obj, field1Method);
        request.id = value;
    }
    if (field2Id == NULL) {
        cout << "name null" << endl;
    } else {
        jstring stringField = static_cast<jstring>(env->GetObjectField(req, field2Id));
        const char* cStringField = env->GetStringUTFChars(stringField, NULL);
        request.name = cStringField;
    }


    jclass clazz = env->FindClass("java/lang/Long"); 
    jmethodID ctor = env->GetMethodID(clazz, "<init>", "(J)V");
    jobject id = env->NewObject(clazz, ctor, request.id);

    clazz = env->FindClass("meta/Response");
    ctor = env->GetMethodID(clazz, "<init>", "(Ljava/lang/Long;Ljava/lang/String;)V");

    return env->NewObject(clazz, ctor, id, env->NewStringUTF(request.name));
}

JNIEXPORT jint JNICALL Java_meta_HelloMetaCpp_add(JNIEnv * env, jobject thisObj, jint a, jint b) {
//    jint result = a + b;
//    cout << a << " + " << b << " = " << result << endl;
    return a + b;
}

JNIEXPORT jstring JNICALL Java_meta_HelloMetaCpp_toString(JNIEnv *env, jobject thisObj, jobject num) {
    jclass integerClazz = env->GetObjectClass(num);
    jmethodID intValueMethod = env->GetMethodID(integerClazz, "intValue", "()I");
    jint value = env->CallIntMethod(num, intValueMethod);
    string str = std::to_string(value);
    return env->NewStringUTF(str.c_str());
}

JNIEXPORT jobject JNICALL Java_meta_HelloMetaCpp_toInt(JNIEnv * env, jobject thisObj, jstring str) {
    const char* chars = env->GetStringUTFChars(str, JNI_FALSE);
    int num = std::stoi(chars);
    env->ReleaseStringUTFChars(str, chars);

    jclass integerClazz = env->FindClass("java/lang/Integer");
    jmethodID integerCtor = env->GetMethodID(integerClazz, "<init>", "(I)V");

    return env->NewObject(integerClazz, integerCtor, num);
}
