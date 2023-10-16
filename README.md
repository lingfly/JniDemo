

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
g++ -Wl,--add-stdcall-alias -I"%JAVA_HOME%\include" -I"%JAVA_HOME%\include\win32" -shared -o hellocpp.dll HelloImpl.cpp
```