class Solution {
    public boolean isValidSudoku(char[][] board) {
        // first condition
        for(int i = 0; i < 9; i++){
            Set<Character> num = new HashSet<>();
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.'){
                    if(!num.add(board[i][j])) return false;
            }
        }
        }

        //second condition

        for(int j = 0; j < 9; j++){
            Set<Character> num = new HashSet<>();
            for(int i = 0; i < 9; i++){
                if(board[i][j] != '.'){
                    if(!num.add(board[i][j])) return false;
                }
            }
        }


        // last condition

        int i = 0;

        while(i < 9){
            int j = 0;
            while(j < 9){
            Set<Character> num = new HashSet<>();
            for(int m = i; m < i + 3; m++){
                for(int n = j; n < j + 3; n++ ){
                      if(board[m][n] != '.'){
                    if(!num.add(board[m][n])) return false;
                }
                }
            }
            j += 3;
            }
            i += 3;
        }
        return true;
    }
}
