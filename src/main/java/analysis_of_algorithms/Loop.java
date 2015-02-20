package analysis_of_algorithms;

/**
 * Created by sandro on 1/31/15.
 */
public class Loop {
    public static int loop(int N) {
//        int sum = 0;
//        for (int i = 1; i <= N; i++)
//            for (int j = 1; j <= i; j++)
//                for (int k = 1; k <= i; k++)
//                    sum++;
//        return sum;

        int sum = 0;
        for (int i = 1; i <= 4*N*N; i = i*3)
            sum++;
        return sum;
    }

    public static void main(String[] args) {
        for (int i=0; i<4; i++) {
            System.out.printf("loop(%d) = %d\n", i, loop(i));
        }
    }
}
