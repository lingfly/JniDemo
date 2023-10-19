package callback;

public class CallbackJNI {

    public native void setCallback(MyCallback callback);

    public native void handle(int num);

}
