import com.sun.jna.Library;
import com.sun.jna.Native;
import jna.Request;
import jna.Response;
import meta.HelloMetaCpp;


/**
 * Simple example of JNA interface mapping and usage.
 */

/** Simple example of JNA interface mapping and usage. */
public class JNADemo {
    static {
        System.loadLibrary("hellocpp");
    }

    public interface CLibrary extends Library {
        CLibrary INSTANCE = Native.load("hello", CLibrary.class);

        int add(int a, int b);
        Response hello(Request req);
    }

    public static void main(String[] args) {
        testAdd();
    }
    static void testAdd() {
        HelloMetaCpp helloMetaCpp = new HelloMetaCpp();
        int n = 1000 * 1000;
        System.out.println("test int, n=" + n);
        long st = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int add = add(i, i);
        }
        System.out.println("java time: " + (System.currentTimeMillis() - st));

        st = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int add = helloMetaCpp.add(1, 2);
        }
        System.out.println("jni time: " + (System.currentTimeMillis() - st));

        st = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            int add = CLibrary.INSTANCE.add(1, 2);
        }
        System.out.println("jna time: " + (System.currentTimeMillis() - st));
    }

    static void testHello() {
        HelloMetaCpp helloMetaCpp = new HelloMetaCpp();
        int n = 1000 * 1000;
        System.out.println("test object, n=" + n);
        meta.Request jniReq = new meta.Request();
        jniReq.setId(1L);
        jniReq.setName("test");
        Request jnaReq = new Request();
        jnaReq.setId(1L);
        jnaReq.setName("test");
        long st = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            meta.Response resp = helloMetaCpp.hello(jniReq);
        }
        System.out.println("jni time: " + (System.currentTimeMillis() - st));

        st = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            Response resp = CLibrary.INSTANCE.hello(jnaReq);
        }
        System.out.println("jna time: " + (System.currentTimeMillis() - st));
    }

    static int add(int a, int b) {
        return a + b;
    }
}
