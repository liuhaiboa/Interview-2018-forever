package DesignPattern.Chain.case1;

/**
 * @author haibo
 * @date 19-9-19
 */
public class Chain
{

    public static void main(String[] args) {
        Handler h1=new CoreHandler();
        Handler h2=new CoreHandler();
        h1.setNextHandler(h2);
        h1.handleRequest();
    }
}
