/**
 * https://leetcode.com/problems/sudoku-solver/
 * 
 * @author yunpeng
 * 
 */
public class SudokuSolver {
	public void solveSudoku(char[][] board) {
		sudokuHelper(board);
	}

	public boolean sudokuHelper(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					for (char k = '1'; k <= '9'; k++) {
						if (isValidSudoku(board, i, j, k)) {
							board[i][j] = k;
							if (sudokuHelper(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					return false;
				}
			}
		}

		return true;
	}

	public boolean isValidSudoku(char[][] board, int i, int j, char val) {
		for (int k = 0; k < 9; k++) {
			char rowVal = board[i][k];
			if (rowVal == val) {
				return false;
			}
			char colVal = board[k][j];
			if (colVal == val) {
				return false;
			}
			int ii = i / 3, jj = j / 3;
			char squareVal = board[3 * ii + k % 3][3 * jj + k / 3];
			if (squareVal == val) {
				return false;
			}
		}
		return true;
	}
}
