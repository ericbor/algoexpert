package educative.binsearch.medium;

import org.junit.Assert;
import org.junit.Test;

/*
Given an array of lowercase letters sorted in ascending order, find the smallest letter in the given array greater than a given ‘key’.

Assume the given array is a circular list, which means that the last letter is assumed to be connected with the first letter.
This also means that the smallest letter in the given array is greater than the last letter of the array and is also the first letter of the array.

Write a function to return the next letter of the given ‘key’.

Input: ['a', 'c', 'f', 'h'], key = 'f' ... Output: 'h'
Explanation: The smallest letter greater than 'f' is 'h' in the given array.

Input: ['a', 'c', 'f', 'h'], key = 'b' ... Output: 'c'
Explanation: The smallest letter greater than 'b' is 'c'.

Input: ['a', 'c', 'f', 'h'], key = 'm' ... Output: 'a'
Explanation: As the array is assumed to be circular, the smallest letter greater than 'm' is 'a'.

Input: ['a', 'c', 'f', 'h'], key = 'h' ... Output: 'a'
Explanation: As the array is assumed to be circular, the smallest letter greater than 'h' is 'a'.
 */
public class NextLetter {
    public static char searchNextLetter(char[] letters, char key) {
        int start = 0;
        int end = letters.length - 1;

        while(start <= end){
            int mid = start + (end - start) / 2;

            if(key >= letters[mid]){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        int index = start % letters.length;
        return letters[index];
    }

    @Test
    public void main() {
        Assert.assertEquals('h', searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'f'));
        Assert.assertEquals('c', searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'b'));
        Assert.assertEquals('a', searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'm'));
        Assert.assertEquals('a', searchNextLetter(new char[] { 'a', 'c', 'f', 'h' }, 'h'));
    }
}
