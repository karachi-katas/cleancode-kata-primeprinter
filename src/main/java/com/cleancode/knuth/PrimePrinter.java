package com.cleancode.knuth;

public class PrimePrinter {
    public static void main(String[] args) {
		final int maxSizeOfPrimes = 1000;
        final int RR = 50;
        final int CC = 4;
        final int ORDMAX = 30;
        int primeNumbers[] = new int[maxSizeOfPrimes+1];
        int PAGENUMBER;
        int PAGEOFFSET;
        int ROWOFFSET;
        int C;
        int currentNumber;
        int primeIndex;
        boolean isPrime;
        int ORD;
        int SQUARE;
        int N=0;
        int MULT[] = new int[ORDMAX+1];

        currentNumber=1;
        primeIndex=1;
        primeNumbers[1] = 2;
        ORD = 2;
        SQUARE = 9;

        while (primeIndex < maxSizeOfPrimes) {
            do {
                currentNumber += 2;
                if( currentNumber == SQUARE) {
                    ORD++;
                    SQUARE=primeNumbers[ORD]*primeNumbers[ORD];
                    MULT[ORD-1]=currentNumber;
                }
                N=2;
                isPrime=true;
                while (N < ORD && isPrime) {
                    while (MULT[N] < currentNumber)
                        MULT[N] += primeNumbers[N] + primeNumbers[N];
                    if (MULT[N] == currentNumber)
                        isPrime = false;
                    N++;
                }
            } while (!isPrime);
            primeIndex++;
            primeNumbers[primeIndex]=currentNumber;
        }
        PAGENUMBER = 1;
        PAGEOFFSET = 1;
        while (PAGEOFFSET <= maxSizeOfPrimes) {
            System.out.print("The First ");
            System.out.print(Integer.toString(maxSizeOfPrimes));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+RR-1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= maxSizeOfPrimes)
                        System.out.printf("%10d", primeNumbers[ROWOFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR*CC;

        }
	}
}
