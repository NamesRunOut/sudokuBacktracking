public class sudokuSolver {
    static void print(int[][] a){
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                System.out.print(a[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }
    static boolean ifSafe(int[][] a, int h, int w, int num){
        for (int i=0;i<9;i++){
            if (a[h][i]==num) return false;
        }
        for (int i=0;i<9;i++){
            if (a[i][w]==num) return false;
        }
        int squareRowStart=h-h%3;
        int squareColStart=w-w%3;
        for (int i=squareRowStart;i<squareRowStart+3;i++){
            for (int j=squareColStart;j<squareColStart+3;j++){
                if (a[i][j]==num) return false;
            }
        }
        return true;
    }
    static boolean solve(int[][] a){
        int row=-1;
        int col=-1;
        boolean empty=true;
        for (int i=0;i<9;i++){
            for (int j=0;j<9;j++){
                if (a[i][j]==0){
                    row=i;
                    col=j;
                    empty=false;
                    break;
                }
            }
            if (!empty) break;
        }

        if (empty) return true;

        for (int i=1;i<=9;i++){
            if (ifSafe(a, row, col, i)) {
                a[row][col]=i;
                if (solve(a)) return true;
                else a[row][col]=0;
            }
        }
        return false;
    }
}
