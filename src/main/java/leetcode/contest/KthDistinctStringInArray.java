package leetcode.contest;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class KthDistinctStringInArray {
    public String kthDistinct2(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            if (map.containsKey(arr[i])) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], i);
            }
        }

        String result = "";
        if (map.size() < k) {
            return result;
        }

        Queue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<>((e1, e2) -> e1.getValue() - e2.getValue());
        minHeap.addAll(map.entrySet());

        while (k > 0) {
            Map.Entry<String, Integer> entry = minHeap.poll();
            result = entry.getKey();
            k--;
        }

        return result;
    }

    public String kthDistinct(String[] arr, int k) {
        Map<String, Integer> map = new HashMap<>();

        for (String str : arr) {
            map.put(str, map.getOrDefault(str,0) + 1);
        }

        // If size of hash is
        // less than k.
        if (map.size() < k) {
            return "";
        }

        // Traverse array again and find k-th element with count as 1.
        int distCount = 0;
        for (String s : arr) {
            if (map.get(s) == 1) {
                distCount++;
            }
            if (distCount == k) {
                return s;
            }
        }
        return "";
    }

    @Test
    public void test() {
        Assert.assertEquals("a", kthDistinct(new String[] { "d", "b", "c", "b", "c", "a" }, 2));
    }

    @Test
    public void test2() {
        Assert.assertEquals("aaa", kthDistinct(new String[] { "aaa", "aa", "a" }, 1));
    }

    @Test
    public void test3() {
        Assert.assertEquals("", kthDistinct(new String[] { "a", "b", "a" }, 3));
    }

    @Test
    public void test4() {
        Assert.assertEquals("dq", kthDistinct(new String[] { "c", "exjk", "nbmg", "kgnas", "s", "oydx", "ghpao", "c", "r", "ohdm", "fq", "ashgg", "mm", "cc", "mymy", "w", "t", "neb", "grjdb", "cukk", "ujyhn", "dq", "hhuo", "qu", "seslw", "ybulz", "iug", "rs", "kyfu", "krz", "nw", "txnn", "r", "zpuao", "sh", "rfc", "c", "hgr", "jfia", "egm", "gmuuv", "gh", "x", "nfvgv", "ibo", "al", "wn", "o", "dyu", "zgkk", "gdzrf", "m", "ui", "xwsj", "zeld", "muowr", "d", "xgiu", "yfu" }, 19));
    }

    @Test
    public void test5() {
        Assert.assertEquals("jtrcp", kthDistinct(
            new String[] { "meio", "l", "xhb", "p", "psuzr", "hrp", "bhqxm", "ccqrl", "d", "nix", "ce", "bkm", "jvqh", "c", "mpah", "uh", "z", "hin", "ekaxo", "cpcy", "cmvj", "glnrk", "uqem", "vq", "tw", "p", "tqlrv", "uxf", "kzxf", "tjd", "arm", "iqfc", "fmze", "txq", "ij", "rlqv", "j", "up", "om", "hdvku", "tkp", "hm", "vdbdd", "lbmc", "bpx", "mqy", "ddecp", "zmdg", "ik", "msy", "pzohq", "fuj", "s", "bbb", "qhy", "nbz", "xbhvi", "dh", "w", "nznd", "lvl", "nru", "y", "q", "jciw", "lmnmm", "e", "lvnrk", "eoi", "fp", "neq", "wuw", "qsjga", "fy", "qvg", "dqjd", "rb", "ck", "uhall", "qcly", "q", "igv", "uq", "ijjqt", "er", "yxx", "wyx", "jlasw", "aln", "ohy", "vf", "gpzy", "mywlj", "xf", "cgwl", "wyjli", "pyow", "i", "upic", "mpze", "ol", "z", "mxwb", "iouzk", "zfx", "f", "y", "gsvv", "hi", "x", "qgj", "zvnz", "vb", "yyl", "m", "uwyhh", "qgd", "qcbky", "h", "wqiyo", "ey", "uqjn", "ma", "h", "phnc", "ozptm", "rwk", "w", "yfw", "lkfbb", "hvaq", "hh", "arhm", "rz", "gtvi", "tgpyt", "np",
                "e", "z", "cmodm", "jhhga", "yal", "unhsp", "acg", "yn", "d", "vndjs", "ntrj", "rmixt", "fh", "xjs", "oib", "mk", "p", "rrhep", "zdk", "dyy", "eox", "hrtr", "n", "ty", "nj", "o", "s", "ewt", "dyvn", "hrejt", "vkzj", "y", "swzzb", "dnelj", "ow", "pv", "c", "muc", "unvy", "vnbk", "nkwte", "ef", "bminn", "zjgcy", "u", "g", "fwks", "cjtv", "ximu", "oiwp", "h", "h", "zpbm", "w", "h", "h", "vqbq", "mg", "xopv", "m", "zceki", "rn", "abiwc", "bid", "gjvsu", "pv", "i", "cemf", "x", "jrxa", "ye", "vovg", "uhlp", "enpj", "oyr", "mgrvo", "jk", "kuqe", "q", "k", "v", "gzo", "zcx", "ylj", "kmt", "x", "byudz", "eh", "lonmh", "iqnx", "apzod", "vif", "f", "bq", "ik", "utjnj", "bx", "c", "oyf", "kqp", "zc", "oxpi", "t", "pagk", "yrup", "xly", "o", "ipndf", "qy", "rqfnp", "c", "abnh", "gm", "yvzh", "jro", "gjxq", "ir", "oicxq", "yplnw", "rxji", "cdwr", "nmnv", "qeiht", "bu", "gg", "jlg", "ajvqg", "bumzg", "lpuf", "lzypp", "fpxj", "uwyqf", "c", "e", "flubx", "cb", "se", "mfw", "wmerw",
                "xun", "xq", "hkuiw", "z", "ffop", "qvc", "xl", "yp", "v", "lv", "ij", "au", "m", "yjlxq", "oqfne", "ave", "oqc", "qlly", "zf", "pa", "h", "pfr", "vhee", "gh", "lswh", "si", "p", "nwzeb", "cy", "fbddc", "xkvqd", "smhl", "t", "gdlvc", "umj", "xujwi", "sqjvz", "m", "bkvv", "tdkg", "nbk", "m", "wvvc", "d", "mlpn", "zi", "wemrh", "qv", "xww", "gzq", "qa", "nqcp", "hat", "jqdg", "bjz", "pozj", "ehv", "bqct", "pihs", "yodi", "yaxhs", "if", "xlw", "ums", "v", "pa", "accg", "wcfdf", "t", "j", "tlijm", "twibw", "q", "gq", "w", "cyrop", "von", "crdtn", "tjt", "sldvo", "ykyg", "wi", "uej", "zmqda", "b", "rbim", "r", "r", "cknvt", "drmac", "mnxm", "bsgw", "c", "vwyil", "hblbj", "ddzr", "ixe", "s", "yd", "dx", "bj", "fxtmw", "mbxvz", "kwut", "cpnt", "ctr", "r", "a", "bmxg", "ecr", "guofg", "c", "eczhh", "sunz", "ic", "d", "nu", "xtle", "w", "ckb", "fnelp", "z", "kpdw", "pe", "lz", "me", "vbc", "sk", "n", "gp", "fud", "qphr", "bbius", "jyqa", "anhge", "tuqse", "d", "fi", "wmrn",
                "heds", "djyrj", "vv", "e", "cf", "gylm", "mdswr", "jxyc", "stn", "uo", "hyjt", "nl", "wcay", "oee", "ng", "dwaii", "d", "kkxpi", "jxir", "wsv", "lkz", "tyf", "fenfb", "xfzi", "o", "yf", "xq", "etvcv", "c", "ajv", "qm", "hbfy", "krzac", "nd", "oymuu", "fsok", "sblyv", "fgubg", "bxy", "clex", "cbny", "y", "kfgi", "e", "lpjd", "wuq", "um", "trv", "mkgb", "dtdcj", "xuetk", "cj", "hhzl", "jcni", "wk", "jtrcp", "jbkju", "hwrr", "tlbw", "xypv", "qmsbe", "gkzm", "lmwz", "gwyw", "yuq", "uz", "cq", "jatsr", "jpd", "xw", "ebfoa", "kbr", "zvtl", "bhqhj", "en", "jvj", "ua", "pth", "joral", "pw", "wlw", "vvddv", "pnx", "v", "u", "fy", "drdf", "m", "xepi", "e", "rtk", "byqvc", "ewu", "k", "d", "nef", "lihc", "puvu", "hdi", "ymcnd", "vwo", "dripr", "jloqq", "jyy", "b", "fbzn", "fth", "ptzw", "u", "rcjjy", "udm", "rb", "nky", "txz", "w", "wkx", "kp", "ay", "ots", "adkr", "u", "tmh", "ayqc", "cs", "ulzbt", "tnz", "rha", "he", "ly", "fhanm", "julf", "vwpap", "m", "fzlx", "tc", "sohc",
                "x", "u", "hwdgu", "tdlcd", "dhlq", "tvs", "ftam", "fyjg", "kq", "qlww", "gbn", "bw", "tqx", "kcfmg", "lahfo", "ipst", "pyddr", "ua", "ilhj", "fdor", "ch", "lp", "gcduz", "trjo", "kuz", "rizf", "xmzg", "pyykm", "idr", "adog", "i", "lrot", "vu", "r", "phbq", "sbvpo", "x", "tb", "hh", "xzco", "xbx", "z", "ccgr", "xdo", "qb", "mf", "lcib", "rsir", "zgyxt", "zpvai", "yi", "clyuu", "nix", "h", "lndqw", "odz", "rkjnh", "bl", "hhuwe", "eqnmj", "yt", "zb", "dhm", "mdxow", "sdhd", "ugybz", "caf", "jfjxw", "ztuoz", "mxoz", "e", "tdo", "zp", "yc", "tg", "rtki", "z", "icppp", "ficph", "oq", "jmxj", "nor", "dlhp", "iaca", "qin", "qghtw", "n", "mrjtx", "bx", "fmyfr", "pp" }, 374));
    }

}
