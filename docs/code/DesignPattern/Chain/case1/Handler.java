package DesignPattern.Chain.case1;

/**
 * @author haibo
 * @date 19-9-19
 */
public abstract class Handler {
    private Handler nextHandler;

    public abstract  void handleRequest();

    public Handler getNextHandler() {
        return nextHandler;
    }

    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }
}
