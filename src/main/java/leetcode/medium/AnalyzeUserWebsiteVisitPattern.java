package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

//https://leetcode.com/problems/analyze-user-website-visit-pattern/
public class AnalyzeUserWebsiteVisitPattern {
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        Map<String, List<Visit>> map = new HashMap<>();

        for (int i = 0; i < username.length; ++i) {
            if (!map.containsKey(username[i])) {
                map.put(username[i], new ArrayList<>());
            }
            map.get(username[i]).add(new Visit(website[i], timestamp[i]));
        }

        sortVisitsByTimestamp(map);

        Map<String, Set<String>> sequencesByUser = generateSequences(map);
        Map<String, Integer> sequencesByFrequency = generateFrequencies(sequencesByUser);

        return pickMaxSequenceAndReformat(sequencesByFrequency);
    }

    private Map<String, Integer> generateFrequencies(Map<String, Set<String>> sequencesByUser) {
        Map<String, Integer> map = new HashMap<>();
        for (Set<String> sequenceSet : sequencesByUser.values()) {
            for (String sequence : sequenceSet) {
                map.put(sequence, map.getOrDefault(sequence, 0) + 1);
            }
        }

        return map;
    }

    private List<String> pickMaxSequenceAndReformat(Map<String, Integer> map) {
        List<String> sites = new ArrayList<>(map.size());
        int maxFrequency = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            int currFrequency = entry.getValue();
            String pattern = entry.getKey();
            if (currFrequency > maxFrequency) {
                maxFrequency = currFrequency;
                sites.clear();
                sites.add(pattern);
            } else if (currFrequency == maxFrequency) {
                sites.add(pattern);
            }
        }

        if (sites.size() == 1) {
            return prepareResult(sites.iterator().next());
        }

        Collections.sort(sites);

        return prepareResult(sites.iterator().next());
    }

    private List<String> prepareResult(String pattern) {
        String[] parts = pattern.split(" ");

        return Arrays.asList(parts);
    }

    private List<String> getSmallestPattern(List<String> first, List<String> second) {
        for (int i = 0; i < first.size(); i++) {
            String a = first.get(i);
            String b = second.get(i);
            if (a.compareTo(b) == -1) {
                return first;
            } else if (a.compareTo(b) == 1) {
                return second;
            }
        }

        return null;
    }

    private Map<String, Set<String>> generateSequences(Map<String, List<Visit>> visitsByUser) {
        Map<String, Set<String>> sequences = new HashMap<>();
        for (Map.Entry<String, List<Visit>> entry : visitsByUser.entrySet()) {
            List<Visit> visits = entry.getValue();
            String user = entry.getKey();
            if (visits.size() < 3) {
                continue;
            }
            sequences.put(user, new HashSet<>());

            for (int i = 0; i < visits.size() - 2; i++) {
                for (int j = i + 1; j < visits.size() - 1; j++) {
                    for (int k = j + 1; k < visits.size(); k++) {
                        String sites = new StringBuilder(visits.get(i).site)
                            .append(" ").append(visits.get(j).site)
                            .append(" ").append(visits.get(k).site).toString();

                        sequences.get(user).add(sites);
                    }
                }
            }
        }

        return sequences;
    }

    private void sortVisitsByTimestamp(Map<String, List<Visit>> map) {
        for (List<Visit> visits : map.values()) {
            Collections.sort(visits);
        }
    }

    class Visit implements Comparable<Visit> {
        String site;
        int time;

        public Visit(String site, int time) {
            this.site = site;
            this.time = time;
        }

        public int compareTo(Visit v) {
            if (v.time == this.time) {
                return 0;
            } else {
                return this.time > v.time ? 1 : -1;
            }
        }

    }

    @Test
    public void test() {
        Assert.assertEquals(List.of("hibympufi", "hibympufi", "yljmntrclw"), mostVisitedPattern(new String[] { "h", "eiy", "cq", "h",
                "cq",
                "txldsscx",
                "cq",
                "txldsscx",
                "h",
                "cq",
                "cq" },
            new int[] { 527896567, 334462937, 517687281, 134127993, 859112386, 159548699, 51100299, 444082139, 926837079, 317455832, 411747930 }, new String[] { "hibympufi", "hibympufi", "hibympufi", "hibympufi",
                "hibympufi",
                "hibympufi",
                "hibympufi",
                "hibympufi",
                "yljmntrclw",
                "hibympufi",
                "yljmntrclw" }));
    }

    @Test
    public void test2() {
        Assert.assertEquals(List.of("a", "b", "a"), mostVisitedPattern(new String[] { "ua", "ua", "ua", "ub", "ub", "ub" },
            new int[] { 1, 2, 3, 4, 5, 6 }, new String[] { "a", "b", "a", "a", "b", "c" }));
    }

    @Test
    public void test3() {
        Assert.assertEquals(List.of("home", "about", "career"), mostVisitedPattern(new String[] { "joe", "joe", "joe", "james", "james", "james", "james", "mary", "mary", "mary" },
            new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 }, new String[] { "home", "about", "career", "home", "cart", "maps", "home", "home", "about", "career" }));
    }

    @Test
    public void test4() {
        Assert.assertEquals(List.of("y", "y", "loedo"), mostVisitedPattern(new String[] { "dowg", "dowg", "dowg" },
            new int[] { 158931262, 562600350, 148438945 }, new String[] { "y", "loedo", "y" }));
    }

    @Test
    public void test5() {
        Assert.assertEquals(List.of("oz", "mryxsjc", "wlarkzzqht"), mostVisitedPattern(new String[] { "zkiikgv", "zkiikgv", "zkiikgv", "zkiikgv" },
            new int[] { 436363475, 710406388, 386655081, 797150921 }, new String[] { "wnaaxbfhxp", "mryxsjc", "oz", "wlarkzzqht" }));
    }
}
