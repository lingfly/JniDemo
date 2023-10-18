#include<stdio.h>
#include <iostream>
#include "hello.pb.h"
#include "proto_HelloProto.h"

using namespace std;

JNIEXPORT jbyteArray JNICALL Java_proto_HelloProto_hello(JNIEnv* env, jclass clazz, jbyteArray protoBytes) {
    jsize length = env->GetArrayLength(protoBytes);
    jbyte* byteArrayElements = env->GetByteArrayElements(protoBytes, NULL);
    Request req;
    req.ParseFromArray(byteArrayElements, length);
    Response resp;
    resp.set_id(req.id());
    resp.set_name(req.name());
    env->ReleaseByteArrayElements(protoBytes, byteArrayElements, 0);

    int respLength = resp.ByteSizeLong();
    vector<jbyte> bytes(respLength);
    resp.SerializeToArray(bytes.data(), respLength);
    jbyteArray respBytes = env->NewByteArray(respLength);
    env->SetByteArrayRegion(respBytes, 0, respLength, bytes.data());
    return respBytes;
}

