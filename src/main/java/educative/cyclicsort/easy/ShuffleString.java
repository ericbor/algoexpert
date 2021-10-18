package educative.cyclicsort.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/shuffle-string/
public class ShuffleString {
    public String restoreString(String s, int[] indices) {
        char[] result = s.toCharArray();

        /*for(int i = 0; i < indices.length; i++){
            result[indices[i]] = s.charAt(i);
        }*/

        int start = 0;
        while(start != indices.length - 1) {
            if (indices[start] == start) {
                start++;
            } else {
                char tmp = result[start];
                result[start] = result[indices[start]];
                result[indices[start]] = tmp;

                //swap(indices, start, indices[start]);
                int tmpIdx = indices[start];
                indices[start] = indices[indices[start]];
                indices[tmpIdx] = tmpIdx;
            }
        }

        return String.valueOf(result);
    }

    private void swap(int[]arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void test(){
        Assert.assertEquals("leetcode", restoreString("codeleet", new int[] {4,5,6,7,0,2,1,3}));
    }
}
