package com.cleancode.knuth;

public class PrimePrinter {
    public static void main(String[] args) {
        final int maxSizeOfPrimes = 1000;
        final int RR = 50;
        final int CC = 4;
        final int totalBoundPosition = 30;
        int primeNumbers[] = new int[maxSizeOfPrimes + 1];
        int pageNumber;
        int pageOffset;
        int rowOffset;
        int C;
        int primeNumber;
        int primeIndex;
        boolean isPrime;
        int multIndex;
        int square;
        int nextPrimeNumberBound[] = new int[totalBoundPosition + 1];

        primeNumber = 1;
        primeIndex = 1;
        primeNumbers[1] = 2;
        multIndex = 2;
        square = 9;
        while (primeIndex < maxSizeOfPrimes) {
            do {
                primeNumber += 2;
                if (primeNumber == square) {
                    multIndex++;
                    square = primeNumbers[multIndex] * primeNumbers[multIndex];
                    nextPrimeNumberBound[multIndex - 1] = primeNumber;
                }
                isPrime = true;
                for (int i = 2; i < multIndex && isPrime; i++) {
                    while (nextPrimeNumberBound[i] < primeNumber)
                        nextPrimeNumberBound[i] += primeNumbers[i] + primeNumbers[i];
                    if (nextPrimeNumberBound[i] == primeNumber)
                        isPrime = false;
                }

            } while (!isPrime);
            primeIndex++;
            primeNumbers[primeIndex] = primeNumber;
        }
        pageNumber = 1;
        pageOffset = 1;
        while (pageOffset <= maxSizeOfPrimes) {
            System.out.print("The First ");
            System.out.print(Integer.toString(maxSizeOfPrimes));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pageNumber));
            System.out.println("\n");
            for (rowOffset = pageOffset; rowOffset <= pageOffset + RR - 1; rowOffset++) {
                for (C = 0; C <= CC - 1; C++)
                    if (rowOffset + C * RR <= maxSizeOfPrimes)
                        System.out.printf("%10d", primeNumbers[rowOffset + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            pageOffset += RR * CC;

        }
    }
}
