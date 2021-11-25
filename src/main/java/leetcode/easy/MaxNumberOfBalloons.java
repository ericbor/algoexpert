package leetcode.easy;

import org.junit.Assert;
import org.junit.Test;

//https://leetcode.com/problems/maximum-number-of-balloons/
public class MaxNumberOfBalloons {
    public int maxNumberOfBalloons(String text) {
        int[] freq = new int[26];
        for(char c: text.toCharArray()) {
            freq[(int)c - (int)'a']++;
        }

        int min = Integer.MAX_VALUE;
        int b = freq[(int)'b' - (int)'a'];
        if(b == 0) {
            return 0;
        }
        min = Math.min(min, b);

        int a = freq[(int)'a' - (int)'a'];
        if(a == 0) {
            return 0;
        }
        min = Math.min(min, a);

        int l = freq[(int)'l' - (int)'a'];
        if(l < 2) {
            return 0;
        }
        min = Math.min(min, l / 2);

        int n = freq[(int)'n' - (int)'a'];
        if(n == 0) {
            return 0;
        }
        min = Math.min(min, n);

        int o = freq[(int)'o' - (int)'a'];
        if(o < 2) {
            return 0;
        }
        min = Math.min(min, o / 2);

        return min;

    }

    @Test
    public void test() {
        Assert.assertEquals(14, maxNumberOfBalloons("mbetypbpefxvviadqaodrbjeoacfomepmzymiudltgnvnpbowwmjgpzzhtiismearuwocsgbiimiqqzaozgeizikrlxmupfzjzmlfttqqbpfblqfkecsdfbsceqjhubfxksivrfwvukapxmuciybfhzlmpeamdxziptxregymqtmgcsujmugissgnlbhxbcxxeoumcqyulvahuianbaaxgzrtmshjguqdaxvxndzoqvwmcjfhpevavnrciqbymnlylbrfkkiceienoarfrzzxtuaqapaeqeqolozadmtgjyhfqzpuaskjuawxqkdqyjqcmbxtvshzrquvegcuyuckznspmrxvqdassidcmrajedsnuuumfwqzvasljlyvfefktiqgvzvdzojtjegsyhbepdkuwvgrfscezvswywmdavpxlekbrlkfnbyvlobazmvgulxrfdranuhomkrlpbfeagfxxxuhjuqhbkhznixquxrxngwimdxdhqbdaouitsvcdmbwxbbaomkgxsqwnexbjjyhtxvkjfqkrrxjghvzqsattubphryqxxdyjkihfnzvjhohnhdlfwoqiwtmwzfgcyhyqtcketvgnbchcxvnhcsoosirfqgdgcsitegzlxdfijzmxnvhrulmgvoqfpzesootscnxenokmmozmoxpaverydbsnimwacjqhrtxkqtvghjyushoctxphxzztukgmnoeycqaeukymvwxcsyvvctflqjhtcvjtxncuvhkptkjnzaetwbzkwnseovewuhpkaxiphdicgacszzdturzgjkzwgkmzzavykancvvzaafgzjhcyicorrblmhsnnkhfkujttbkuuedhwguuaapojmnjdfytdhrepjwcddzsoeutlbbljlikghxefgbqenwamanikmynjcupqpdjnhldaixwygcvsgdkzszmsptqqnroflgozblygtiyaxudwmooiviqcosjfksnevultrf"));
    }
}
