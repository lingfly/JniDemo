import com.google.protobuf.InvalidProtocolBufferException;
import proto.Hello;
import proto.HelloProto;

public class ProtoDemo {
    static {
        System.loadLibrary("libprotobuf");
        System.loadLibrary("libprotobuf-lite");
        System.loadLibrary("helloproto");
    }

    public static void main(String[] args) throws InvalidProtocolBufferException {
        Hello.RequestList.Builder reqListBuilder = Hello.RequestList.newBuilder();
        Hello.Request.Builder reqBuilder = Hello.Request.newBuilder();
        int m = 100;
        for (int i = 0; i < m; i++) {
            Hello.Request request = reqBuilder.setId(i).setName("test"+i).build();
            reqListBuilder.addRequestList(request);
        }
        Hello.RequestList requestList = reqListBuilder.build();
        System.out.println(requestList);
        byte[] byteArray = requestList.toByteArray();
        Hello.RequestList requestList1 = Hello.RequestList.parseFrom(byteArray);
        System.out.println(requestList1);

    }

    static void test1() throws InvalidProtocolBufferException {
        Hello.Request.Builder builder = Hello.Request.newBuilder();
        builder.setId(1L).setName("test");
        Hello.Request request = builder.build();
        int n = 1000 * 1000;
        System.out.println("n=" + n);
        long st = System.currentTimeMillis();
        for (int i = 0; i < n; i++) {
            byte[] reqBytes = request.toByteArray();
            byte[] respBytes = HelloProto.hello(reqBytes);
            Hello.Response response = Hello.Response.parseFrom(respBytes);
        }

        System.out.println("total time: " + (System.currentTimeMillis() - st));
    }


}
