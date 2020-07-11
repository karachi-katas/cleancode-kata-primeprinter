package com.cleancode.knuth;

public class PrimePrinter {
    public static void main(String[] args) {
		final int totalNumberOfPrimesToBePrinted = 1000;
        final int RR = 50;
        final int CC = 4;
        final int ORDMAX = 30;
        int primes[] = new int[totalNumberOfPrimesToBePrinted+1];
        int PAGENUMBER;
        int PAGEOFFSET;
        int ROWOFFSET;
        int C;
        int currentNumberToCheck;
        int currentPrimeCount;
        boolean JPRIME;
        int ORD;
        int SQUARE;
        int N=0;
        int MULT[] = new int[ORDMAX+1];

        currentNumberToCheck=1;
        currentPrimeCount=1;
        primes[1] = 2;
        ORD = 2;
        SQUARE = 9;

        while (currentPrimeCount < totalNumberOfPrimesToBePrinted) {
            do {
                currentNumberToCheck += 2;
                if( currentNumberToCheck == SQUARE) {
                    ORD++;
                    SQUARE=primes[ORD]*primes[ORD];
                    MULT[ORD-1]=currentNumberToCheck;
                }
                N=2;
                JPRIME=true;
                while (N < ORD && JPRIME) {
                    while (MULT[N]<currentNumberToCheck)
                        MULT[N] += primes[N] + primes[N];
                    if (MULT[N] == currentNumberToCheck)
                        JPRIME=false;
                    N++;
                }
            }
            while (!JPRIME);
            currentPrimeCount++;
            primes[currentPrimeCount]=currentNumberToCheck;
        }
        PAGENUMBER = 1;
        PAGEOFFSET = 1;
        while (PAGEOFFSET <= totalNumberOfPrimesToBePrinted) {
            System.out.print("The First ");
            System.out.print(Integer.toString(totalNumberOfPrimesToBePrinted));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+RR-1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= totalNumberOfPrimesToBePrinted)
                        System.out.printf("%10d", primes[ROWOFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR*CC;

        }
	}
}
