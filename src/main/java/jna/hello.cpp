#include"hello.h"

using namespace std;
int add(int a, int b) {
    return a+b;
}

Response hello(Request req) {
    Response resp;
    resp.id = req.id;
    resp.name = req.name;
    return resp;
}