package com.cleancode.knuth;



public class PrimePrinter {
    static final int M = 1000;
    static final int RR = 50;
    static final int CC = 4;
    static final int ORDMAX = 30;

    public static void main(String[] args) {

        int P[] = new int[M+1];
        int J;
        int K;
        boolean JPRIME;
        int ORD;
        int SQUARE;
        int N=0;
        int MULT[] = new int[ORDMAX+1];

        J=1;
        K=1;
        P[1] = 2;
        ORD = 2;
        SQUARE = 9;

        while (K < M) {
            do {
                J += 2;
                if( J == SQUARE) {
                    ORD++;
                    SQUARE=P[ORD]*P[ORD];
                    MULT[ORD-1]=J;
                }
                N=2;
                JPRIME=true;
                while (N < ORD && JPRIME) {
                    while (MULT[N]<J)
                        MULT[N] += P[N] + P[N];
                    if (MULT[N] == J)
                        JPRIME=false;
                    N++;
                }
            } while (!JPRIME);
            K++;
            P[K]=J;
        }
        print(P);
    }

    private static void print(int[] p) {
        int PAGENUMBER;
        int PAGEOFFSET;
        int ROWOFFSET;
        int C;
        PAGENUMBER = 1;
        PAGEOFFSET = 1;
        while (PAGEOFFSET <= M) {
            System.out.print("The First ");
            System.out.print(Integer.toString(M));
            System.out.print(" Prime Numbers === Page ");
            System.out.print(Integer.toString(PAGENUMBER));
            System.out.println("\n");
            for (ROWOFFSET=PAGEOFFSET; ROWOFFSET <= PAGEOFFSET+RR-1; ROWOFFSET++) {
                for (C = 0; C <= CC - 1; C++)
                    if (ROWOFFSET + C * RR <= M)
                        System.out.printf("%10d", p[ROWOFFSET + C * RR]);
                System.out.println();
            }
            System.out.println("\f");
            PAGENUMBER++;
            PAGEOFFSET += RR*CC;

        }
    }
}
