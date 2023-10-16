package meta;

public class HelloMeta {
    static {
        System.loadLibrary("hello");
    }

    public native void hello();

    public static void main(String[] args) {
        new HelloMeta().hello();
    }
}
