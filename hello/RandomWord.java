import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class RandomWord {

    public static void main(String[] args) {
        int counts = 1;
        String champion = "Test";

        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (StdRandom.bernoulli((double) 1 / counts)) {
                champion = s;
            }
            counts++;
        }

        StdOut.println(champion);
    }
}
