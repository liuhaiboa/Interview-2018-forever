package LeetCode;

public class num50 {
//    实现 pow(x, n) ，即计算 x 的 n 次幂函数。
//    示例 1:输入: 2.00000, 10 输出: 1024.00000
//    示例 2:输入: 2.10000, 3  输出: 9.26100
//    示例 3:输入: 2.00000, -2 输出: 0.25000
//    解释: 2-2 = 1/22 = 1/4 = 0.25
//    说明:     -100.0 < x < 100.0    n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1]

    //递归：
//    算7的10次方，先算7乘7得49，则7的5次方为49乘49乘7，再算它的平方，共进行了4次乘法。
//    模仿这样的过程，也就是快速幂

//    public double myPow(double x, int n)
//    {
//        if (n == 0)
//            return 1;
//        else if (n % 2 == 1)
//            return myPow(x, n - 1) * x;
//
//        else{
//            double temp = myPow(x, n / 2);
//            return temp * temp;
//        }
//    }

    //3官方答案
//    public double quickMul(double x, long N) {
//        if (N == 0) {
//            return 1.0;
//        }
//        double y = quickMul(x, N / 2);
//        return N % 2 == 0 ? y * y : y * y * x;
//    }
//
//    public double myPow(double x, int n) {
//        long N = n;
//        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
//    }


    public double myPow(double x, int n) {

        //2
        if (n == 0){
            return 1;
        }
        else if (n > 0 && n % 2 == 0){
            return myPow(x * x, n / 2);
        }
        else if (n > 0){
            return myPow(x, n - 1) * x;
        }
        else {
            //这里会 java.lang.StackOverflowError
            return 1 / myPow(x, -n);
        }
    }

        //1
//        if (x == 0 || n == 1) {
//            return x;
//        }
//        if (x == 1 || n == 0) {
//            return 1;
//        }
//        //整数
//        double a = 0l;
//        for (int i = 0; i < n; i++) {
//            if(i==0){
//                a = x;
//            }else {
//                a = a*x;
//            }
//        }
//        if(n>0){
//            return a;
//
//        }else{
//           //这里会出现 负无穷
//            return 1/a;
//        }



}
