import org.junit.Assert;
import org.junit.Test;

public class TextEditor {
    private static final String APPEND = "APPEND";
    private static final String MOVE = "MOVE";
    private static final String FORWARD_DELETE = "FORWARD_DELETE";
    private static final String SELECT = "SELECT";

    public String[] solution(String[][] queries) {
        String[] results = new String[queries.length];

        Integer cursorStart = null;
        String selected = "";
        for (int i = 0; i < queries.length; i++) {
            String operation = queries[i][0];

            if (APPEND.equals(operation)) {
                String value = queries[i][1];
                cursorStart = append(results, value, i, cursorStart, selected);
            } else if (MOVE.equals(operation)) {
                String value = queries[i][1];
                cursorStart = move(results, value, i);
            } else if (FORWARD_DELETE.equals(operation)) {
                forwardDelete(results, i, cursorStart);
            } else if(SELECT.equals(operation)) {
                selected = select(results, i, queries[i][1], queries[i][2]);
            }
        }

        return results;
    }

    private String select(String[] results, int i, String start, String end) {
        if(i > 0) {
            results[i] = results[i - 1];

            int from = Integer.parseInt(start);
            int to = Integer.parseInt(end);
            return results[i - 1].substring(from, to);
        }

        return null;
    }

    private void forwardDelete(String[] results, int i, Integer cursorStart) {
        if (cursorStart != null && i > 0) {
            if (results[i - 1].length() > cursorStart) {
                StringBuilder sb = new StringBuilder(results[i - 1]);
                sb.deleteCharAt(cursorStart);

                results[i] = sb.toString();
            } else {
                results[i] = results[i - 1];
            }
        }
    }

    private int move(String[] results, String position, int i) {
        if (i > 0) {
            results[i] = results[i - 1];
        }

        return Math.max(0, Integer.parseInt(position)) ;
    }

    private Integer append(String[] results, String text, int i, Integer cursorStart, String selected) {
        if (cursorStart == null) {
            if (i > 0) {
                results[i] = results[i - 1].replaceFirst(selected, "") + text;
            } else {
                results[i] = text;
            }

            return null;
        } else {
            if (i > 0) {
                cursorStart = Math.min(cursorStart, results[i - 1].length());
                StringBuilder sb = new StringBuilder(results[i - 1]);
                sb.insert(cursorStart, text);
                results[i] = sb.toString();
            } else {
                results[i] = text;
            }

            return cursorStart + text.length();
        }
    }

    @Test
    public void test() {
        Assert.assertArrayEquals(new String[] {
            "You'll never find a rainbow if you're looking down",
            "You'll never find a rainbow if you're looking down",
            "You'll never find a rif you're looking down",
            "You'll never find a rmeaning of lifeif you're looking down"}, solution(new String[][] {
            {"APPEND","You'll never find a rainbow if you're looking down"},
            {"SELECT","21","28"},
            {"FORWARD_DELETE"},
            {"APPEND","meaning of life"}
        }));
    }

    @Test
    public void test7() {
        Assert.assertArrayEquals(new String[] {
            "Never give up",
            "Never give up",
            "ever give up",
            "ver give up",
            "er give up",
            "r give up",
            " give up",
            "give up",
            "Don'tgive up",
            "Don't even think to give up"}, solution(new String[][] {
            {"APPEND","Never give up"},
            {"MOVE","0"},
            {"FORWARD_DELETE"},
            {"FORWARD_DELETE"},
            {"FORWARD_DELETE"},
            {"FORWARD_DELETE"},
            {"FORWARD_DELETE"},
            {"FORWARD_DELETE"},
            {"APPEND","Don't"},
            {"APPEND"," even think to "}
        }));
    }

    @Test
    public void test6() {
        Assert.assertArrayEquals(new String[] {
            "Never give up",
            "Never give up",
            "START.Never give up",
            "START.Never give up",
            "START.Never give upEND.",
            "START.Never give upEND." }, solution(new String[][] {
            { "APPEND", "Never give up" },
            { "MOVE", "-10" },
            { "APPEND", "START." },
            { "MOVE", "20" },
            { "APPEND", "END." },
            { "FORWARD_DELETE" }
        }));
    }

    @Test
    public void test5() {
        Assert.assertArrayEquals(new String[] {
            "Hey, you!",
            "Hey, you!",
            "Hey, ou!",
            "Hey, u!",
            "Hey, !",
            "Hey, ",
            "Hey, ",
            "Hey, little world!" }, solution(new String[][] {
            { "APPEND", "Hey, you!" },
            { "MOVE", "5" },
            { "FORWARD_DELETE" },
            { "FORWARD_DELETE" },
            { "FORWARD_DELETE" },
            { "FORWARD_DELETE" },
            { "FORWARD_DELETE" },
            { "APPEND", "little world!" }
        }));
    }

    @Test
    public void test4() {
        Assert.assertArrayEquals(new String[] { "Hello! world!",
            "Hello! world!",
            "Hello world!",
            "Hello, world!" }, solution(new String[][] {
            { "APPEND", "Hello! world!" },
            { "MOVE", "5" },
            { "FORWARD_DELETE" },
            { "APPEND", "," }
        }));
    }

    @Test
    public void test3() {
        Assert.assertArrayEquals(new String[] { "Hey you",
            "Hey you",
            "Hey, you" }, solution(new String[][] {
            { "APPEND", "Hey you" },
            { "MOVE", "3" },
            { "APPEND", "," }
        }));
    }

    @Test
    public void test2() {
        Assert.assertArrayEquals(new String[] { "Hey",
            "Hey you",
            "Hey you, don't",
            "Hey you, don't ",
            "Hey you, don't let me down" }, solution(new String[][] {
            { "APPEND", "Hey" },
            { "APPEND", " you" },
            { "APPEND", ", don't" },
            { "APPEND", " " },
            { "APPEND", "let me down" }
        }));
    }

}
