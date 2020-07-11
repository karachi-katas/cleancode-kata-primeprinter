package com.cleancode.knuth;

public class PrimePrinter {
    
    public static void main(String[] args) {
		final int FIRST_PRIME_NUMBERS_TO_PRINT = 1000;
        final int ROWS_PER_PAGE = 50;
        final int COLUMNS_PER_PAGE = 4;
        final int ORDMAX = 30;

        int primeNumbers [] = new int[FIRST_PRIME_NUMBERS_TO_PRINT+1];
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
        printify(FIRST_PRIME_NUMBERS_TO_PRINT, ROWS_PER_PAGE, COLUMNS_PER_PAGE, primeNumbers, "Prime Numbers");
    }

    private static void printify(int maxNumbers, int rowsPerPage, int columnsPerPage, int[] numbers, String numbersDescription) {


        for (int pageNumber = 1, index = 1; index <= maxNumbers;){

            printHeaderOfAPage(maxNumbers, pageNumber);
            for (int rowoffset= index; rowoffset <= index +rowsPerPage-1; rowoffset++) {

                for (int c = 0; c <= columnsPerPage - 1; c++)
                    if (rowoffset + c * rowsPerPage <= maxNumbers)
                        System.out.printf("%10d", numbers[rowoffset + c * rowsPerPage]);

                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            index += rowsPerPage*columnsPerPage;

        }
    }

    private static void printHeaderOfAPage(int FIRST_PRIME_NUMBERS_TO_PRINT, int pageNumber) {
        System.out.print("The First ");
        System.out.print(FIRST_PRIME_NUMBERS_TO_PRINT);
        System.out.print(" Prime Numbers === Page ");
        System.out.print(pageNumber);
        System.out.println("\n");
    }



    private static int getNextOddNumber(int oddNumberToBeChecked) {
        return  oddNumberToBeChecked + 2;
    }
}
