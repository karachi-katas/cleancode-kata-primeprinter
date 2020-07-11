package com.cleancode.knuth;



public class PrimePrinter {
    static final int TOTAL_PRIME_NUMBERS = 1000;
    static final int OUTPUT_ROWS = 50;
    static final int OUTPUT_COLUMNS = 4;
    static final int ORDMAX = 30;

    public static void main(String[] args) {

        int primeNumbers[] = new int[TOTAL_PRIME_NUMBERS +1];
        primeNumbers[1] = 2;

        int candidatePrimeNumber = 1;
        int SQUARE = 9;
        int counter = 1;
        int ORD = 2;
        int MULT[] = new int[ORDMAX+1];


        while (counter < TOTAL_PRIME_NUMBERS) {
            boolean JPRIME;
            do {
                candidatePrimeNumber += 2;
                if( candidatePrimeNumber == SQUARE) {
                    ORD++;
                    SQUARE=primeNumbers[ORD]*primeNumbers[ORD];
                    MULT[ORD-1]=candidatePrimeNumber;
                }

                int N=2;
                JPRIME=true;
                while (N < ORD && JPRIME) {
                    while (MULT[N]<candidatePrimeNumber)
                        MULT[N] += primeNumbers[N] + primeNumbers[N];
                    if (MULT[N] == candidatePrimeNumber)
                        JPRIME=false;
                    N++;
                }
            } while (!JPRIME);
            counter++;
            primeNumbers[counter]=candidatePrimeNumber;
        }
        print(primeNumbers);
    }

    private static void print(int[] p) {
        int ROWOFFSET;

        int PAGENUMBER = 1;
        int PAGEOFFSET = 1;
        while (PAGEOFFSET <= TOTAL_PRIME_NUMBERS) {
            System.out.print("The First ");
            System.out.print(TOTAL_PRIME_NUMBERS);
            System.out.print(" Prime Numbers === Page ");
            System.out.print(PAGENUMBER);
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+ OUTPUT_ROWS -1; ROWOFFSET++) {
                for (int C = 0; C <= OUTPUT_COLUMNS - 1; C++)
                    if (ROWOFFSET + C * OUTPUT_ROWS <= TOTAL_PRIME_NUMBERS)
                        System.out.printf("%10d", p[ROWOFFSET + C * OUTPUT_ROWS]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += OUTPUT_ROWS * OUTPUT_COLUMNS;

        }
    }
}
