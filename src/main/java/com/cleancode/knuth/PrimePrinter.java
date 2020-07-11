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
        int squareCounter = 2;
        int squares[] = new int[ORDMAX+1];


        int counter = 1;
        while (counter < TOTAL_PRIME_NUMBERS) {
            boolean isCandidateAPrime;
            do {
                candidatePrimeNumber += 2;
                if( candidatePrimeNumber == SQUARE) {
                    squareCounter++;
                    SQUARE=primeNumbers[squareCounter]*primeNumbers[squareCounter];
                    squares[squareCounter-1]=candidatePrimeNumber;
                }

                isCandidateAPrime=true;
                int N=2;
                while (N < squareCounter && isCandidateAPrime) {
                    while (squares[N]<candidatePrimeNumber)
                        squares[N] += primeNumbers[N] + primeNumbers[N];
                    if (squares[N] == candidatePrimeNumber)
                        isCandidateAPrime=false;
                    N++;
                }
            } while (!isCandidateAPrime);
            counter++;
            primeNumbers[counter]=candidatePrimeNumber;
        }
        print(primeNumbers);
    }

    private static void print(int[] primeNumbers) {
        int pageNumber = 1;
        int pageOffset = 1;
        while (pageOffset <= TOTAL_PRIME_NUMBERS) {
            System.out.print("The First ");
            System.out.print(TOTAL_PRIME_NUMBERS);
            System.out.print(" Prime Numbers === Page ");
            System.out.print(pageNumber);
            System.out.println("\n");
            for (int row=pageOffset; row <= pageOffset+ OUTPUT_ROWS -1; row++) {
                for (int column = 0; column <= OUTPUT_COLUMNS - 1; column++)
                    if (row + column * OUTPUT_ROWS <= TOTAL_PRIME_NUMBERS)
                        System.out.printf("%10d", primeNumbers[row + column * OUTPUT_ROWS]);
                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            pageOffset += OUTPUT_ROWS * OUTPUT_COLUMNS;

        }
    }
}
