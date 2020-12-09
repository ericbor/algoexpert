package stack.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMaxStack {
    static class Stack {
        List<Integer> stack = new ArrayList<>();

        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            return stack.remove(stack.size() - 1);
        }

        public void push(Integer number) {
            stack.add(number);
        }

        public int getMin() {
            return Collections.min(stack);
        }

        public int getMax() {
            return Collections.max(stack);
        }
    }

    static class StackV2 {
        List<Map<String, Integer>> minMaxStack = new ArrayList<>();
        List<Integer> stack = new ArrayList<>();

        public int peek() {
            return stack.get(stack.size() - 1);
        }

        public int pop() {
            minMaxStack.remove(minMaxStack.size() - 1);
            return stack.remove(stack.size() - 1);
        }

        public void push(Integer number) {
            Map<String, Integer> newMinMax = new HashMap<>();
            newMinMax.put("min", number);
            newMinMax.put("max", number);

            if (!minMaxStack.isEmpty()) {
                Map<String, Integer> lastMinMax = new HashMap<>(minMaxStack.get(minMaxStack.size() - 1));
                newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
                newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
            }

            minMaxStack.add(newMinMax);
            stack.add(number);
        }

        public int getMin() {
            return minMaxStack.get(minMaxStack.size() - 1).get("min");
        }

        public int getMax() {
            return minMaxStack.get(minMaxStack.size() - 1).get("max");
        }
    }
}
