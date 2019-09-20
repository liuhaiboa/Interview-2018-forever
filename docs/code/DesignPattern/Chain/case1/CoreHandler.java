package DesignPattern.Chain.case1;

/**
 * @author haibo
 * @date 19-9-19
 */
public class CoreHandler extends Handler {
    @Override
    public void handleRequest() {
        System.out.println("CoreHandler+++++"+this.toString());

        if(getNextHandler()!=null){
            getNextHandler().handleRequest();

        }
    }
}
