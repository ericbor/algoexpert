package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/employee-free-time
public class EmployeeFreeTime {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {

        Queue<Interval> queue = new PriorityQueue<>((a, b) -> a.start - b.start);
        schedule.forEach(queue::addAll);

        Interval temp = queue.poll();
        List<Interval> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            if (temp.end < queue.peek().start) { // no intersect
                result.add(new Interval(temp.end, queue.peek().start));
                temp = queue.poll(); // becomes the next temp interval
            } else { // intersect or sub merged
                temp = temp.end < queue.peek().end ? queue.peek() : temp;
                queue.poll();
            }
        }
        return result;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(new Interval(5, 6), new Interval(7, 9)), employeeFreeTime(List.of(
            List.of(new Interval(1, 3), new Interval(6, 7)),
            List.of(new Interval(2, 4)),
            List.of(new Interval(2, 5)),
            List.of(new Interval(9, 12))
        )));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of(new Interval(3, 4)), employeeFreeTime(List.of(
            List.of(new Interval(1, 2), new Interval(5, 6)),
            List.of(new Interval(1, 3)),
            List.of(new Interval(4, 10))
        )));
    }

    class Interval {
        public int start;
        public int end;

        public Interval() {
        }

        public Interval(int _start, int _end) {
            start = _start;
            end = _end;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o)
                return true;
            if (o == null || getClass() != o.getClass())
                return false;
            Interval interval = (Interval) o;
            return start == interval.start && end == interval.end;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start, end);
        }
    }

    ;
}


