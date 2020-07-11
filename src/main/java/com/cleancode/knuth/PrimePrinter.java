package com.cleancode.knuth;


public class PrimePrinter {
    public static void main(String[] args) {
		final int primeCountLimit = 1000;

        int[] primes = generatePrimes(primeCountLimit);
        printPrimes(primes);
    }

    private static void printPrimes(int[] primes) {
        int ROWOFFSET;
        int C;
        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        int primeCount = primes.length - 1;
        final int RR = 50;
        final int CC = 4;

        while (PAGEOFFSET <= primeCount) {
            System.out.print("The First ");
            System.out.print(Integer.toString(primeCount));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+RR-1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= primeCount)
                        System.out.printf("%10d", primes[ROWOFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR*CC;

        }
    }

    private static int[] generatePrimes(int primeCountLimit) {
        int[] primes = new int[primeCountLimit + 1];
        int ORDMAX = 30;
        int[] multiplesOfANumber = new int[ORDMAX + 1];
        int numberCurrentlyBeingEvaluated=1;
        primes[1] = 2;
        int ORD = 2;
        int SQUARE = 9;

        for (int primeIndex = 1; primeIndex < primeCountLimit; primeIndex++, primes[primeIndex] = numberCurrentlyBeingEvaluated) {

            boolean isPrime;

            // Increase numberCurrentlyBeingEvaluated until it is a prime number
            do {
                numberCurrentlyBeingEvaluated += 2;
                if( numberCurrentlyBeingEvaluated == SQUARE) {
                    ORD++;
                    SQUARE = primes[ORD]* primes[ORD];
                    multiplesOfANumber[ORD-1]= numberCurrentlyBeingEvaluated;
                }

                isPrime = evaluatePrimality(primes, multiplesOfANumber, numberCurrentlyBeingEvaluated, ORD);
            } while (!isPrime);
        }

        return primes;
    }

    private static boolean evaluatePrimality(int[] primes, int[] multiplesOfANumber, int numberCurrentlyBeingEvaluated, int ORD) {
        int N = 2;
        boolean isPrime = true;
        while (N < ORD && isPrime) {
            while (multiplesOfANumber[N] < numberCurrentlyBeingEvaluated) {
                multiplesOfANumber[N] += primes[N] + primes[N];
            }
            if (multiplesOfANumber[N] == numberCurrentlyBeingEvaluated)
                isPrime=false;
            N++;
        }
        return isPrime;
    }
}
