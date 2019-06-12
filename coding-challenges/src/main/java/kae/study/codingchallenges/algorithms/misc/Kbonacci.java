package kae.study.codingchallenges.algorithms.misc;

import java.math.BigInteger;
import java.util.LinkedList;

/**
 *
 */
public class Kbonacci {

    String kbonacci(int k, int n) {
        if (n < k) {
            return "1";
        }

        if (n == k) {
            return String.valueOf(k);
        }

        LinkedList<BigInteger> previousK = new LinkedList<>();

        for (int i = 0; i < k; ++i) {
            previousK.add(BigInteger.ONE);
        }
        previousK.add(BigInteger.valueOf(k));

        BigInteger result = BigInteger.ZERO;
        for (int i = k + 1; i <= n; i++) {
            final BigInteger previous = previousK.getLast();
            result = previous.add(previous).subtract(previousK.getFirst());

            previousK.removeFirst();
            previousK.add(result);
        }

        return String.valueOf(result);
    }

    public static void main(String[] args) {
        final Kbonacci alg = new Kbonacci();
        System.out.println(alg.kbonacci(3, 4));
        System.out.println(alg.kbonacci(1000, 25000));
        System.out.println(alg.kbonacci(5, 30));
    }

}

