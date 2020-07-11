package com.cleancode.knuth;

import java.util.Collection;

public class PrimePrinter {

    public static void main(String[] args) {
        final int ROWS_PER_PAGE = 50;
        final int COLUMNS_PER_PAGE = 4;
        final int FIRST_PRIME_NUMBERS_TO_PRINT = 1000;
        final int ORDMAX = 30;

        int[] primeNumbers = PrimeGenerator.foo(FIRST_PRIME_NUMBERS_TO_PRINT, ORDMAX);

        ListPrinter printer = new ListPrinter(FIRST_PRIME_NUMBERS_TO_PRINT, ROWS_PER_PAGE, COLUMNS_PER_PAGE);

        printer.printify(FIRST_PRIME_NUMBERS_TO_PRINT, ROWS_PER_PAGE, COLUMNS_PER_PAGE, primeNumbers, "Prime Numbers");
    }

}
