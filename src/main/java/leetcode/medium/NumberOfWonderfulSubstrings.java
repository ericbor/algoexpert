package leetcode.medium;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/number-of-wonderful-substrings/
public class NumberOfWonderfulSubstrings {
    public long wonderfulSubstrings(String word) {


        long count = 0;
        Set<String> set = new HashSet<>();
        for(int i = 0; i < word.length(); i++) {
            for(int j = i; j < word.length(); j++) {
                String subsgtring = word.substring(i, j + 1);
                if(set.contains(subsgtring)) {
                    count++;
                } else if(isWonderful(subsgtring)) {
                    set.add(subsgtring);
                    count++;
                }
            }
        }

        return count;
    }

    private boolean isWonderful(String word) {
        if(word.length() == 1) {
            return true;
        }
        int[] arr = new int[10];
        for(char c: word.toCharArray()) {
            arr[(int)c - (int)'a']++;
        }

        int oddCount = 0;
        for(int n: arr) {
            if(n % 2 != 0) {
                oddCount++;
            }
        }

        return oddCount < 2;
    }

    @Test
    public void test() {
        Assert.assertEquals(5936, wonderfulSubstrings("aaccehccfbiidcbhbbieiefaefjdjbbeiidjigdjeggccaefieechgfaijicihdghaghcehiifcaiaaajebebbebdefhhcgijegfbbdbhhcgbgbafafageededdhhaieiadfdihfahibdefgcdhggahffbehjcebhfjbhiadifchecccfjigjgccgbhjjhghegjfhbehagadhbicifahhiigdcccffhjjjciijbafedaihaiighhjccdbaidebfbgihcjdccdjhbhjdiajghcigaedcgfiabjacihhedbbjfagabchdcdhaehbjdcdedjaeggeadgfehcfcgdgecfhiafecjhhcjhafgjgjhdcgcigdeiifcfahagibgiiabaicbejabaiihiafhdigjhajdfgaiheaicfihjcfcdhcjdfbccccjidhejbachaeafaaagbacichbaeadeehdgbdagdffdfdibcchjjgaeiadhgbheejegebdfdbhjhjadcgecjbgifageiieihaihgcjdfabgdjhgceahddeedbehdihfahdjhjbhhiebdijaighhjefbgjacjdcfeghgffcaedbbgccadeiihhfacfffhgegagcjbhbegjdjefidjhcggacghbdjgbaejcbcfgchifhbgibagbacfhdeibcghbcgifghbadcechbacagijdjccbdigdjaidegedddefacagjjedhbghadeiacgecagccgjfdccacgaebbgajjehchejfdiahbbjcjhhdcdceccafijjjfdhgdifcedhhiceaabdcfdiegficdfgfaejggaehajgjhicghdeeefjjaedbjfhdfbhcfgiiiafejacajdiej"));
    }

    @Test
    public void test3() {
        Assert.assertEquals(9, wonderfulSubstrings("aabb"));
    }

    @Test
    public void test2() {
        Assert.assertEquals(4, wonderfulSubstrings("aba"));
    }
}
