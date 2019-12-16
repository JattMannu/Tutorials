package leet.code;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Test
    void contextLoads() {
    }


    @Test
    void null_check() {
        boolean validSudoku = new Solution().isValidSudoku(null);
        Assertions.assertFalse(validSudoku);
    }

    @Test
    void too_small_grid() {
        char[][] input = new char[][]{
                {'8', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean validSudoku = new Solution().isValidSudoku(input);
        Assertions.assertFalse(validSudoku);
    }

    @Test
    void too_big_side_grid() {
        char[][] input = new char[][]{
                {'.', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
        };

        boolean validSudoku = new Solution().isValidSudoku(input);
        Assertions.assertFalse(validSudoku);
    }


    @Test
    void too_small_row_grid() {
        char[][] input = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
        };

        boolean validSudoku = new Solution().isValidSudoku(input);
        Assertions.assertFalse(validSudoku);
    }


    @Test
    void simple_test() {
        char[][] input = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean validSudoku = new Solution().isValidSudoku(input);
        Assertions.assertTrue(validSudoku);
    }

    @Test
    void dublicate_on_row() {
        char[][] input = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '5'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean validSudoku = new Solution().isValidSudoku(input);
        Assertions.assertFalse(validSudoku);
    }

    @Test
    void dublicate_on_col() {
        char[][] input = new char[][]{
                {'8', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        boolean validSudoku = new Solution().isValidSudoku(input);
        Assertions.assertFalse(validSudoku);
    }
}
