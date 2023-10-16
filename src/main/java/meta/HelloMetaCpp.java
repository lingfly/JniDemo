package meta;

public class HelloMetaCpp {

    public native Response hello(Request request);

    public native int add(int a, int b);

    public native String toString(Integer num);

    public native Integer toInt(String num);

}
