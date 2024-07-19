public class index6 {
    @SuppressWarnings("unused")
    public static boolean isSafe(int suduko[][],int row,int col,int digit){
        // column
        for(int i=0;i<9;i++){
            if(suduko[i][col]==digit){
                return false;
            }
        }
        // row
        for(int j=0;j<9;j++){
            if(suduko[row][j]==digit){
                return false;
            }
        }
        // gridways
        int Srow= (row/3)*3;
        int Scol=(col/3)*3;
        for(int i=Srow;i<Srow+3;i++){
            for(int j=Scol;j<Scol+3;j++){
                if(suduko[i][j]==digit){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean sudukosolving(int suduko[][],int row,int col){
        // base
        if(row==9){
            return true;
        }
        // recursion
        int nxtrow=row;
        int nxtcol=col+1;
        if(col+1==9){
            nxtrow=row+1;
            nxtcol=0;
        }
        if(suduko[row][col]!=0){
            return sudukosolving(suduko, nxtrow, nxtcol);
        }

        for(int digit=1;digit<=9;digit++){
            if(isSafe(suduko,row,col,digit)){
                suduko[row][col]=digit;
                if(sudukosolving(suduko, nxtrow, nxtcol)){
                    return true;
                }
                suduko[row][col]=0;
            }

        }
        return false;
    }
    public static void printsuduko(int suduko[][]){
        for(int i=0;i<suduko.length;i++){
            for(int j=0;j<suduko.length;j++){
                System.out.print(suduko[i][j]+" ");
            }
            System.out.println();
        }

    }
    public static void main(String[] args) {
        int suduko[][]={{0,0,8,0,0,0,0,0,0},
                        {4,9,0,1,5,7,0,0,2},
                        {0,0,3,0,0,4,1,9,0},
                        {1,8,5,0,6,0,0,2,0},
                        {0,0,0,0,2,0,0,6,0},
                        {9,6,0,4,0,5,3,0,0},
                        {0,3,0,0,7,2,0,0,4},
                        {0,4,9,0,3,0,0,5,7},
                        {8,2,7,0,0,9,0,1,3}};
        if(sudukosolving(suduko, 0, 0)){
            System.out.println("solution is possible");
            printsuduko(suduko);
        }
        else{
            System.out.println("solution is not possible");
        }
    }
}
