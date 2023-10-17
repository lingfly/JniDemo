#include<iostream>

class Request {
public:
    long id;
    const char* name;

    // Request(__int64 id, char* name) : id(id), name(name){}
};

class Response {
public:
    long id;
    const char* name;

    // Request(__int64 id, char* name) : id(id), name(name){}
};
#ifdef __cplusplus
extern "C" {
#endif

int add(int a, int b);
Response hello(Request req);
#ifdef __cplusplus
}
#endif

