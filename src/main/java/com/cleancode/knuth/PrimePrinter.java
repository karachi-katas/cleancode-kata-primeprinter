package com.cleancode.knuth;

public class PrimePrinter {
    public static void main(String[] args) {
		final int primeCountLimit = 1000;

      //  int[] primes = generatePrimes(primeCountLimit);

        PrimeGenerator primeGenerator=new PrimeGenerator();
       int[] primes=primeGenerator.generatePrimes(primeCountLimit);
       printPrimes(primes);
    }

    private static void printPrimes(int[] primes) {
        int PAGENUMBER = 1;
        int primeCount = primes.length - 1;
        final int rowsPerPage = 50;
        final int columnsPerPage = 4;

        for (int PAGEOFFSET=1; PAGEOFFSET <= primeCount;PAGEOFFSET+=rowsPerPage*columnsPerPage)
        {
            System.out.printf("The First %d Prime Numbers === Page %d\n\n",primeCount,PAGENUMBER);
            for (int ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+rowsPerPage-1; ROWOFFSET++) {
                for (int column = 0; column <= columnsPerPage - 1; column++)
                    if (ROWOFFSET + column * rowsPerPage <= primeCount)
                        System.out.printf("%10d", primes[ROWOFFSET + column * rowsPerPage]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;

        }
    }

}
