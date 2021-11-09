package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
public class NumberOfStudentsUnableToEatLunch {
    public int countStudents2(int[] students, int[] sandwiches) {
        Queue<Integer> studentQueue = new LinkedList<>();
        for (int student : students) {
            studentQueue.add(student);
        }

        Queue<Integer> sandwichQueue = new LinkedList<>();
        for (int sandwich : sandwiches) {
            sandwichQueue.add(sandwich);
        }

        while (!studentQueue.isEmpty() && !sandwichQueue.isEmpty()) {
            if (studentQueue.peek() == sandwichQueue.peek()) {
                studentQueue.poll();
                sandwichQueue.poll();
            } else if (studentQueue.contains(0) && studentQueue.contains(1)) {
                int student = studentQueue.poll();
                studentQueue.add(student);
            } else {
                return studentQueue.size();
            }
        }

        return 0;
    }

    public int countStudents(int[] students, int[] sandwiches) {
        int ones = 0; //count of students who prefer type1
        int zeros = 0; //count of students who prefer type0

        for(int stud : students){
            if(stud == 0) {
                zeros++;
            } else {
                ones++;
            }
        }

        // for each sandwich in sandwiches
        for(int sandwich : sandwiches){
            if(sandwich == 0){  // if sandwich is of type0
                if(zeros == 0){ // if no student want a type0 sandwich
                    return ones;
                }
                zeros--;
            }
            else{  // if sandwich is of type1
                if(ones == 0){  // if no student want a type1 sandwich
                    return zeros;
                }
                ones--;
            }
        }
        return 0;
    }

    @Test
    public void test() {
        Assert.assertEquals(0, countStudents2(new int[] { 1, 1, 0, 0 }, new int[] { 0, 1, 0, 1 }));
        Assert.assertEquals(0, countStudents(new int[] { 1, 1, 0, 0 }, new int[] { 0, 1, 0, 1 }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(3, countStudents2(new int[] { 1, 1, 1, 0, 0, 1 }, new int[] { 1, 0, 0, 0, 1, 1 }));
        Assert.assertEquals(3, countStudents(new int[] { 1, 1, 1, 0, 0, 1 }, new int[] { 1, 0, 0, 0, 1, 1 }));
    }
}
