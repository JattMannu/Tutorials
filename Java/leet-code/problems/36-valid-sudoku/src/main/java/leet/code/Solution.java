package leet.code;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null) return false;
        if (board.length != 9) return false;

        for (char[] col : board) {
            if (col.length != 9) return false;
        }

        Set<Integer> chars = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                char cell = board[i][j];
                if(cell != '.'){
                    if(!chars.add(cell+10*i) || !chars.add(cell+(10*j)+200) || !chars.add(cell+(10*(10*(j/3)+(i/3)))+400) )
                        return false;
                }
            }
        }
        return true;
    }

    public boolean isValidSudoku1(char[][] board) {
        if (board == null) return false;
        if (board.length != 9) return false;

        for (char[] col : board) {
            if (col.length != 9) return false;
        }

        Set<Character> chars = new HashSet<>();


        for (int i = 0; i < board.length; i++) {
            chars.clear();
            for (int j = 0; j < board[i].length; j++) {

                if (board[i][j] == '.')
                    continue;
                else if (chars.contains(board[i][j]))
                    return false;

                chars.add(board[i][j]);
            }

            chars.clear();
            for (int j = 0; j < board[i].length; j++) {

                if (board[j][i] == '.')
                    continue;
                else if (chars.contains(board[j][i]))
                    return false;

                chars.add(board[j][i]);
            }
        }


        for (int i = 0; i < board.length; i = i +3) {
            for (int j = 0; j < board.length; j = j+3) {
                chars.clear();
                for (int k = 0; k < 3; k++) {
                    for (int l = 0; l < 3; l++) {
                        char cell = board[i + k][j + l];
                        if(cell == '.')
                            continue;
                        else if(chars.contains(cell))
                            return false;
                        chars.add(cell);
                    }
                }

            }
        }
        return true;
    }
}
