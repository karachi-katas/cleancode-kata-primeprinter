package com.cleancode.knuth;


public class PrimePrinter {
    public static void main(String[] args) {
		final int primeCountLimit = 1000;
        final int RR = 50;
        final int CC = 4;
        final int ORDMAX = 40;
        int P[] = new int[primeCountLimit+1];

        int MULT[] = new int[ORDMAX+1];

        loop1(primeCountLimit, P, MULT);

        loop2(primeCountLimit, RR, CC, P);
    }

    private static void loop2(int m, int RR, int CC, int[] p) {
        int ROWOFFSET;
        int C;
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= m) {
            System.out.print("The First ");
            System.out.print(Integer.toString(m));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+RR-1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= m)
                        System.out.printf("%10d", p[ROWOFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR*CC;

        }
    }

    private static void loop1(int primeCountLimit, int[] primes, int[] MultiplesOfANumber) {
        int N;
        boolean JPRIME;
        int numberCurrentlyBeingEvaluated=1;
        primes[1] = 2;
        int ORD = 2;
        int SQUARE = 9;

        for (int primeIndex = 1; primeIndex < primeCountLimit; primeIndex++, primes[primeIndex] = numberCurrentlyBeingEvaluated) {

            do {
                numberCurrentlyBeingEvaluated += 2;
                if( numberCurrentlyBeingEvaluated == SQUARE) {
                    ORD++;
                    SQUARE= primes[ORD]* primes[ORD];
                    MultiplesOfANumber[ORD-1]= numberCurrentlyBeingEvaluated;

                }

                N=2;
                JPRIME=true;
                while (N < ORD && JPRIME) {
                    while (MultiplesOfANumber[N] < numberCurrentlyBeingEvaluated) {
                        MultiplesOfANumber[N] += primes[N] + primes[N];
                    }
                    if (MultiplesOfANumber[N] == numberCurrentlyBeingEvaluated)
                        JPRIME=false;
                    N++;
                }
            } while (!JPRIME);

        }

    }
}
