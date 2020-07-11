package com.cleancode.knuth;

public class PrimeGenerator {

    int ORDMAX;
    int[] multiplesOfANumber;
    int numberCurrentlyBeingEvaluated;
    int ORD;
    int SQUARE;

    public PrimeGenerator()
    {

         ORDMAX = 30;
         multiplesOfANumber = new int[ORDMAX + 1];
         numberCurrentlyBeingEvaluated=1;
         ORD = 2;
         SQUARE = 9;
    }



    public int[] generatePrimes(int primeCountLimit) {

        int[] primes = new int[primeCountLimit + 1];
        primes[1] = 2;
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
