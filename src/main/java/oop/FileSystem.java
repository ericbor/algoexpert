package oop;

import org.junit.Assert;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/design-file-system/
public class FileSystem {
    private final Map<String, Integer> map;
    private final static String SEPARATOR = "/";

    public FileSystem() {
        this.map = new HashMap<>();
    }

    public boolean createPath(String path, int value) {
        String[] paths = path.split(SEPARATOR);
        if(2 == paths.length) {
            map.put(path, value);

            return true;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 1; i < paths.length - 1; i++) {
            sb.append(SEPARATOR).append(paths[i]);
            if(!map.containsKey(sb.toString())) {
                return false;
            }
        }

        map.put(path, value);
        return true;
    }

    //[[],["/leet",1],["/leet/code",2],["/leet/code"],["/leet/code",3],["/leet/code"]]

    public int get(String path) {
        return map.getOrDefault(path, -1);
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        fs.createPath("/a", 1);
        Assert.assertEquals(1, fs.get("/a"));
    }
}
