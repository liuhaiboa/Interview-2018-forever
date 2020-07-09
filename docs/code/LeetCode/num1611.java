package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class num1611 {
    public int[] divingBoard(int shorter, int longer, int k) {

        int[] ret = new int[]{};
        HashMap<Integer,Integer> hashMap = new HashMap();
        if(k == 0){
            return ret;
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        for (int i = 0; i < k+1; i++) {
            int a =  shorter * i + longer * (k-i);
            if(!hashMap.containsKey(a)){
                hashMap.put(a,a);
            }
        }


        ArrayList<Integer> arrayList = new ArrayList();
        for (Integer value : hashMap.values()) {
            arrayList.add(value);
        }

        ret = new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            ret[i] = arrayList.get(i);
        }
        Arrays.sort(ret);

        return ret;



    }


}
