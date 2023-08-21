package other;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/find-duplicate-file-in-system
public class FindDuplicateFileInSystem {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> map = new HashMap<>();
        for (String path : paths) {
            String[] values = path.split(" ");
            String dir = values[0];

            for(int i = 1; i < values.length; i++) {
                String[] fileAndContent = values[i].split("\\(");
                String file = fileAndContent[0];
                String content = fileAndContent[1].replace(")", "");

                if (!map.containsKey(content)) {
                    map.put(content, new ArrayList<>());
                }
                map.get(content).add(dir + "/" + file);
            }
        }

        List<List<String>> results = new ArrayList<>();
        for (List<String> files : map.values()) {
            if (files.size() > 1) {
                results.add(files);
            }
        }

        return results;
    }

    @Test
    public void test() {
        Assert.assertEquals(List.of(List.of("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"), List.of("root/a/1.txt", "root/c/3.txt")), findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));
    }

}
