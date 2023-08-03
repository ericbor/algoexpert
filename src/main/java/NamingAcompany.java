import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/naming-a-company
public class NamingAcompany {
    public long distinctNames(String[] ideas) {
        // Group idea by their initials.
        Set<String>[] initialGroup = new HashSet[26];
        for (int i = 0; i < 26; ++i) {
            initialGroup[i] = new HashSet<>();
        }
        for (String idea : ideas) {
            int index = (int) idea.charAt(0) - (int) 'a';
            String word = idea.substring(1);
            initialGroup[index].add(word);
        }

        // Calculate number of valid names from every pair of groups.
        long answer = 0;
        for (int i = 0; i < 25; ++i) {
            for (int j = i + 1; j < 26; ++j) {
                // Get the number of mutual suffixes.
                long numOfMutual = 0;
                for (String ideaA : initialGroup[i]) {
                    if (initialGroup[j].contains(ideaA)) {
                        numOfMutual++;
                    }
                }

                // Valid names are only from distinct suffixes in both groups.
                // Since we can swap a with b and swap b with a to create two valid names, multiple answer by 2.
                answer += 2 * (initialGroup[i].size() - numOfMutual) * (initialGroup[j].size() - numOfMutual);
            }
        }

        return answer;
    }

    @Test
    public void test() {
        Assert.assertEquals(6, distinctNames(new String[]{"coffee", "donuts", "time", "toffee"}));
    }

}
