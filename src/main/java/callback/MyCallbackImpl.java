package callback;

public class MyCallbackImpl implements MyCallback {
    public void onCallback(int message) {
        System.out.println("Callback message: " + message);
    }

}
