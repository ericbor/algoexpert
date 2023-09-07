package atlassian;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

//https://leetcode.com/problems/rank-teams-by-votes
public class RankTeamsByVotes {
    public String rankTeams(String[] votes) {
        int len = votes[0].length();
        int[][] map = new int[26][len + 1];
        for (int i = 0; i < 26; i++) {
            map[i][len] = i;
        }

        for (String s : votes) {
            for (int j = 0; j < s.length(); j++) {
                map[(int) s.charAt(j) - (int) 'A'][j]++;
            }
        }

        Arrays.sort(map, (a, b) -> {
            for (int i = 0; i < len; i++) {
                if (a[i] != b[i]) {
                    return b[i] - a[i];
                }
            }
            return a[len] - b[len];
        });

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < len; i++) {
            sb.append((char) ('A' + map[i][len]));
        }
        return sb.toString();
    }

    @Test
    public void test() {
        Assert.assertEquals("ACB", rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
    }
}
