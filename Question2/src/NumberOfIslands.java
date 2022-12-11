//Time Complexity - O (M X N ) where M is number o rows and N is number of columns
// Space Complexity - O ( M X N ) where M is number o rows and N is number of columns

public class NumberOfIslands {
	
	public static int findNumOfIslands(String[][] matrix) {
		int islands = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		boolean[][] visited = new boolean[rows][cols];
		
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j].equals("1") && visited[i][j] == false) {
					islands++;
					search(matrix, visited, i, j);
				}
			}
		}
		
		return islands;
	}
	
	private static void search(String[][] matrix, boolean[][] visited, int row, int col) {
		int maxRow = matrix.length;
		int maxCol = matrix[0].length;
		
		if (row < 0 || col < 0 || row >= maxRow || col >= maxCol || matrix[row][col].equals("0") || visited[row][col] == true) {
			return;
		}
		visited[row][col] = true;
		search(matrix, visited, row - 1, col);
		search(matrix, visited, row, col - 1);
		search(matrix, visited, row, col + 1);
		search(matrix, visited, row + 1, col);
	}
	
	
}
