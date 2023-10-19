import callback.CallbackJNI;
import callback.MyCallback;
import callback.MyCallbackImpl;

public class CallbackDemo {
    static {
        System.loadLibrary("callback");
    }

    public static void main(String[] args) {
        CallbackJNI jni = new CallbackJNI();
        MyCallback callback = new MyCallbackImpl();

        jni.setCallback(callback); // 调用 JNI 设置回调的方法
        jni.handle(1);
    }


}
