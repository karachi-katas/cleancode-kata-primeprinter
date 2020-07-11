package com.cleancode.knuth;

public class PrimePrinter {

    final int totalNumberOfPrimesToBePrinted = 1000;
    int primes[] = new int[this.totalNumberOfPrimesToBePrinted +1];

    public static void main(String[] args) {

        PrimePrinter primePrinter = new PrimePrinter();

        primePrinter.calculatePrimes();
        primePrinter.printPrimes();

    }

    private void calculatePrimes() {

        int currentNumberToCheck;
        int currentPrimeCount;

        int ORD;
        int SQUARE;
        int N;

        final int ORDMAX = 30;
        int multiples[] = new int[ORDMAX+1];

        currentNumberToCheck=1;
        currentPrimeCount=1;

        ORD = 2;
        SQUARE = 9;

        primes[1] = 2;

        while (currentPrimeCount < this.totalNumberOfPrimesToBePrinted) {
            boolean isCurrentNumberPrime;

            do {
                currentNumberToCheck += 2;
                if( currentNumberToCheck == SQUARE) {
                    ORD++;
                    SQUARE=primes[ORD]*primes[ORD];
                    multiples[ORD-1]=currentNumberToCheck;
                }
                N=2;
                isCurrentNumberPrime=true;
                while (N < ORD && isCurrentNumberPrime) {
                    while (multiples[N]<currentNumberToCheck)
                        multiples[N] += primes[N] + primes[N];
                    if (multiples[N] == currentNumberToCheck)
                        isCurrentNumberPrime=false;
                    N++;
                }
            } while (!isCurrentNumberPrime);
            currentPrimeCount++;
            primes[currentPrimeCount]=currentNumberToCheck;
        }
    }

    private void printPrimes() {
        int PAGENUMBER;
        int PAGEOFFSET;
        int ROWOFFSET;

        final int RR = 50;
        final int CC = 4;

        int C;
        PAGENUMBER = 1;
        PAGEOFFSET = 1;
        while (PAGEOFFSET <= this.totalNumberOfPrimesToBePrinted) {
            System.out.print("The First ");
            System.out.print(Integer.toString(this.totalNumberOfPrimesToBePrinted));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+RR-1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= this.totalNumberOfPrimesToBePrinted)
                        System.out.printf("%10d", primes[ROWOFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR*CC;

        }
    }
}
