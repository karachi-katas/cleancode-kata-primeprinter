package com.cleancode.knuth;

public class ListPrinter {

    final int MAX_NUMBERS;
    final int ROWS_PER_PAGE;
    final int COLUMNS_PER_PAGE;

    public ListPrinter(int MAX_NUMBERS, int ROWS_PER_PAGE, int COLUMNS_PER_PAGE) {
        this.MAX_NUMBERS = MAX_NUMBERS;
        this.ROWS_PER_PAGE = ROWS_PER_PAGE;
        this.COLUMNS_PER_PAGE = COLUMNS_PER_PAGE;
    }

    public void printify(int[] numbers, String numbersDescription) {
        for (int pageNumber = 1, index = 1; index <= MAX_NUMBERS;){
            printHeaderOfAPage(pageNumber, numbersDescription);
            for (int rowoffset= index; rowoffset <= index +ROWS_PER_PAGE-1; rowoffset++)
                printRow(numbers, rowoffset);
            System.out.println("\f");
            pageNumber++;
            index += ROWS_PER_PAGE*COLUMNS_PER_PAGE;
        }
    }

    private void printRow(int[] numbers, int rowoffset) {
        for (int c = 0; c <= COLUMNS_PER_PAGE - 1; c++)
            if (isInRange(rowoffset, c))
                System.out.printf("%10d", numbers[rowoffset + c * ROWS_PER_PAGE]);
        System.out.println();
    }

    private boolean isInRange(int rowoffset, int c) {
        return rowoffset + c * ROWS_PER_PAGE <= MAX_NUMBERS;
    }

    private void printHeaderOfAPage(int pageNumber, String numbersDescription) {
        System.out.print("The First ");
        System.out.print(MAX_NUMBERS);
        System.out.print(" " + numbersDescription + " === Page ");
        System.out.print(pageNumber);
        System.out.println("\n");
    }
}
