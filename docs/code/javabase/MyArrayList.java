package javabase;


import java.util.ArrayList;

public class MyArrayList<E> {

    private static final int defSize=2;
    private static final int initSize = 1 << 4;
    private Object[] empty = {};
    private Object[] object;
    private int size;
    private int modCount;

    public MyArrayList(){
        this.object = empty;
    }

    public MyArrayList(int initialCapacity){
       if(initialCapacity < 0){
           throw new IllegalArgumentException("Illegal Capacity: "+
                   initialCapacity);
       }
       if(initialCapacity > 0){
           this.object = new Object[initialCapacity];
       }
       if(initialCapacity == 0){
           this.object = empty;

       }
    }

    public int size(){
        return size;
    }


    public static void main(String[] args) {
        System.out.println(testTwo(3));
    }
    public static int testTwo(int max){
        if(max > 0){
            max = testTwo(max -1);
            max = testTwo(max -1);
        }
        return max;
    }

    public boolean isPalindrome(String s) {
        String s1 = s.toUpperCase();
        for (int i = 0; i <  s1.length(); i++) {
            for (int j =  s1.length() -1 ; j <  s1.length(); j--) {
                if(i == j){
                    return  true;
                }
                if(i>='a'&&i<='z' || i>='A'&&i<='Z'){
                    i++;
                }
                if(j>='a'&&j<='z' || j>='A'&&j<='Z'){
                    j--;
                }
                if(s.charAt(i) == s.charAt(j)){
                    continue;
                }else {
                    return false;
                }
            }
        }
        return true;

    }


}
