import org.junit.Assert;
import org.junit.Test;

public class TechChallenge2 {
    public String solution(int AA, int AB, int BB) {
        StringBuilder sb = new StringBuilder();
        String abResult = "";

        if(AB > 0) {
            for(int i = 0; i < AB; i++) {
                sb.append("AB");
            }
            abResult = sb.toString();
            sb.setLength(0);
        }

        if(AA >= BB) {
            build(sb, AA, BB, "AA", "BB");
        } else {
            build(sb, BB, AA, "BB", "AA");
        }

        if(abResult.isEmpty()) {
            return sb.toString();
        }

        return null;
    }

    private void build(StringBuilder sb, int aCount, int bCount, String a, String b) {
        while(bCount > 0) {
            sb.append(a).append(b);
            aCount--;
            bCount--;
        }
        if(aCount > 0) {
            sb.append(a);
        }
    }

    @Test
    public void test() {
        Assert.assertEquals("AABBAABBAA", solution(5,0,2));
    }

    @Test
    public void test2() {
        Assert.assertEquals("BBABABAA", solution(1,2,1));
    }

    @Test
    public void test3() {
        Assert.assertEquals("ABAB", solution(0,2,0));
    }

    @Test
    public void test4() {
        Assert.assertEquals("BB", solution(0,0,10));
    }
}
