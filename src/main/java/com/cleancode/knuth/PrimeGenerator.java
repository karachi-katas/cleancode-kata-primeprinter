package com.cleancode.knuth;

public class PrimeGenerator {

    public static int[] foo (final int FIRST_PRIME_NUMBERS_TO_PRINT, final int ORDMAX){

        int primeNumbers [] = new int[FIRST_PRIME_NUMBERS_TO_PRINT+1];
        int oddNumber;
        int nthPrimeNumber;
        int ord;
        int nextOddNumberSquare;
        int n;
        int nonPrimeOddNumbers[] = new int[ORDMAX+1];

        oddNumber = 1;
        nthPrimeNumber=1;
        primeNumbers[1] = 2;
        ord = 2;
        nextOddNumberSquare = 9;

        while (nthPrimeNumber < FIRST_PRIME_NUMBERS_TO_PRINT) {
            boolean isNumberPrime;
            do {
                oddNumber = getNextOddNumber(oddNumber);
                if( oddNumber == nextOddNumberSquare) {
                    ord++;
                    nextOddNumberSquare = primeNumbers[ord]*primeNumbers[ord];
                    nonPrimeOddNumbers[ord-1]=oddNumber;
                }
                n=2;
                isNumberPrime=true;
                while (n < ord && isNumberPrime) {
                    while (nonPrimeOddNumbers[n]<oddNumber)
                        nonPrimeOddNumbers[n] += primeNumbers[n] + primeNumbers[n];
                    if (nonPrimeOddNumbers[n] == oddNumber)
                        isNumberPrime=false;
                    n++;
                }
            } while (!isNumberPrime);
            nthPrimeNumber++;
            primeNumbers[nthPrimeNumber]=oddNumber;
        }
        return primeNumbers;
    }


    private static int getNextOddNumber(int oddNumberToBeChecked) {
        return  oddNumberToBeChecked + 2;
    }

}
