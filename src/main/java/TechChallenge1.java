
import org.junit.Test;

public class TechChallenge1 {


    public void solution_final(int N) {
        int enable_print = 0;
        while (N > 0) {
            if (enable_print == 0 && N % 10 != 0) {
                enable_print = 1;
            }
            if (enable_print == 1) {
                System.out.print(N % 10);
            }
            N = N / 10;
        }
    }

    @Test
    public void test() {
        solution_final(12345);
    }

    @Test
    public void test2() {
        //Assert.assertEquals(1101, solution2(1011));
        //Assert.assertEquals(1101, solution5(1011));
        solution_final(1011);
    }

    @Test
    public void test3() {
        //Assert.assertEquals(1, solution2(1));
        //Assert.assertEquals(1, solution5(1));
        solution_final(1);
    }

    @Test
    public void test4() {
        solution_final(2050);
    }
}
