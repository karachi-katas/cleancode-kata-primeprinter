package com.cleancode.knuth;

public class PrimePrinter {
    
    public static void main(String[] args) {
		final int FIRST_PRIME_NUMBERS_TO_PRINT = 1000;
        final int ROWS_PER_PAGE = 50;
        final int COLUMNS_PER_PAGE = 4;
        final int ORDMAX = 30;
        int primeNumbers [] = new int[FIRST_PRIME_NUMBERS_TO_PRINT+1];
        int pageNumber;
        int pageOffset;
        int rowoffset;
        int c;
        int oddNumber;
        int nthPrimeNumber;
//        boolean jprime;
        int ord;
        int nextOddNumberSquare;
        int n = 0;
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
        pageNumber = 1;
        pageOffset = 1;
        while (pageOffset <= FIRST_PRIME_NUMBERS_TO_PRINT) {
            System.out.print("The First ");
            System.out.print(Integer.toString(FIRST_PRIME_NUMBERS_TO_PRINT));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pageNumber));
            System.out.println("\n");
            for (rowoffset= pageOffset; rowoffset <= pageOffset +ROWS_PER_PAGE-1; rowoffset++) {
                for (c = 0; c <= COLUMNS_PER_PAGE - 1; c++)
                    if (rowoffset + c * ROWS_PER_PAGE <= FIRST_PRIME_NUMBERS_TO_PRINT)
                        System.out.printf("%10d", primeNumbers[rowoffset + c * ROWS_PER_PAGE]);
                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            pageOffset += ROWS_PER_PAGE*COLUMNS_PER_PAGE;

        }
	}

    private static int getNextOddNumber(int oddNumberToBeChecked) {
        return  oddNumberToBeChecked + 2;
    }
}
