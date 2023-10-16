import meta.HelloMetaCpp;
import meta.Request;
import meta.Response;

public class Main {
    static {
        System.loadLibrary("hellocpp");
    }
    public static void main(String[] args) {
        HelloMetaCpp helloMetaCpp = new HelloMetaCpp();

        int add = helloMetaCpp.add(1, 2);
        System.out.println("add result: " + add);

        String toStr = helloMetaCpp.toString(100);
        System.out.println("int2string result: " + toStr);

        Integer toInt = helloMetaCpp.toInt("123");
        System.out.println("string2int result: " + toInt);

        Request req = new Request();
        req.setId(1L);
        req.setName("test");
        Response resp = helloMetaCpp.hello(req);
        System.out.println("hello: " + resp);
    }
}
