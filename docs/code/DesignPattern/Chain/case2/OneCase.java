package DesignPattern.Chain.case2;

/**
 * @author haibo
 * @date 19-9-19
 */
public class OneCase implements BaseCase {
    @Override
    public void doSomething(String input, BaseCase baseCase) {
        if ("1".equals(input)) {
            // TODO do something
            System.out.println(getClass().getName());
            return;
        }
        //当前没法处理，回调回去，让下一个去处理
        baseCase.doSomething(input, baseCase);
    }


    public static void main(String[] args) {
        String input = "3";
        CaseChain caseChain = new CaseChain();
        caseChain.addBaseCase(new OneCase())
                .addBaseCase(new TwoCase());
        caseChain.doSomething(input, caseChain);
    }
}
