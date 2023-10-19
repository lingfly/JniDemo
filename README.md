

## c

### 生成头文件

```shell
javac -h .  meta/*.java

#or

javac meta/*.java
javah meta.HelloMeta
```

### 编译

头文件和c文件放同一目录
```sh
gcc -Wl,--add-stdcall-alias -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o hello.dll HelloImpl.c

# or

gcc -Wl,--add-stdcall-alias -I"%CLASS_PATH%\include" -I"%CLASS_PATH%\include\win32" -shared -o hello.dll HelloImpl.c

```
查看dll内的函数

```shell
nm hello.dll | grep hello
```

### 运行

```shell
java -Djava.library.path=./c meta.HelloMeta
```

## cpp
```shell
# VM参数
-Djava.library.path=./src/main/java/cpp
```

```shell
g++ -Wl,--add-stdcall-alias -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o hellocpp.dll HelloImpl.cpp
```

## jna

```shell
g++ -Wl,--add-stdcall-alias -shared -o hello.dll hello.cpp

```

## 性能对比

test object, n=1000000
jni time: 1194
jna time: 2732

test int, n=1000000
java time: 2
jni time: 5
jna time: 660

## proto

```shell
protoc --java_out=./ ./proto/hello.proto
protoc --cpp_out=./ ./proto/hello.proto
```

n=1000000
proto total time: 505

## callback

```shell
# VM参数
-Djava.library.path=./src/main/java/callback
```

```shell
g++ -Wl,--add-stdcall-alias -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o ./callback/callback.dll callback/callback.cpp
```