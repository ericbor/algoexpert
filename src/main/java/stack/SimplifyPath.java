package stack;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

//https://leetcode.com/problems/simplify-path/
public class SimplifyPath {
    public String simplifyPath(String path) {

        Deque<String> stack = new ArrayDeque<>();
        String[] components = path.split("/");

        for (String directory : components) {
            // A no-op for a "." or an empty string
            if (".".equals(directory) || directory.isEmpty()) {
                continue;
            }
            if ("..".equals(directory)) {
                // If the current component is a "..", then we pop an entry from the stack if it's non-empty
                if (!stack.isEmpty()) {
                    stack.pollLast();
                }

            } else {
                // Finally, a legitimate directory name, so we add it to our stack
                stack.add(directory);
            }
        }

        // Stich together all the directory names together
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append("/");
            result.append(stack.poll());//take as stack, not stack
        }

        return result.length() > 0 ? result.toString() : "/";
    }

    @Test
    public void test() {
        Assert.assertEquals("/home/wow", simplifyPath("/home/bob/../wow"));
    }
}
