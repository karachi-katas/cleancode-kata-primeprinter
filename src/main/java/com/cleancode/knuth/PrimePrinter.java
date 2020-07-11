package com.cleancode.knuth;

public class PrimePrinter {
    
    public static void main(String[] args) {
		final int M = 1000;
        final int RR = 50;
        final int CC = 4;
        final int ORDMAX = 30;
        int p [] = new int[M+1];
        int pageNumber;
        int pageOffset;
        int rowoffset;
        int c;
        int j;
        int k;
        boolean jprime;
        int ord;
        int square;
        int n = 0;
        int mult[] = new int[ORDMAX+1];

        j=1;
        k=1;
        p[1] = 2;
        ord = 2;
        square = 9;

        while (k < M) {
            do {
                j += 2;
                if( j == square) {
                    ord++;
                    square=p[ord]*p[ord];
                    mult[ord-1]=j;
                }
                n=2;
                jprime=true;
                while (n < ord && jprime) {
                    while (mult[n]<j)
                        mult[n] += p[n] + p[n];
                    if (mult[n] == j)
                        jprime=false;
                    n++;
                }
            } while (!jprime);
            k++;
            p[k]=j;
        }
        pageNumber = 1;
        pageOffset = 1;
        while (pageOffset <= M) {
            System.out.print("The First ");
            System.out.print(Integer.toString(M));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(pageNumber));
            System.out.println("\n");
            for (rowoffset= pageOffset; rowoffset <= pageOffset +RR-1; rowoffset++) {
                for (c = 0; c <= CC - 1; c++)
                    if (rowoffset + c * RR <= M)
                        System.out.printf("%10d", p[rowoffset + c * RR]);
                System.out.println();
            }
            System.out.println("\f");
            pageNumber++;
            pageOffset += RR*CC;

        }
	}
}
