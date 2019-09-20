package DesignPattern.Chain.case2;

/**
 * @author haibo
 * @date 19-9-19
 */
public class TwoCase implements BaseCase {
    @Override
    public void doSomething(String input, BaseCase baseCase) {
        if ("2".equals(input)) {
            // TODO do something
            System.out.println(getClass().getName()+"2222");
            return;
        }
        //当前没法处理，回调回去，让下一个去处理
        baseCase.doSomething(input, baseCase);
    }

}
