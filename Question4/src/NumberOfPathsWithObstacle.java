//Space O( M X N ) Size of Matrix M X N
//Space O(1)

public class NumberOfPathsWithObstacle {
	
	
	public static int pathToReachEndWithObstacles(int[][] matrix) {
		int r = matrix.length;
		int c = matrix[0].length;
		if (matrix[0][0] == Integer.MIN_VALUE) {
			return 0;
		}
		matrix[0][0] = 1;
		
		for (int i = 1; i < r; i++) {
			if (matrix[i][0] == Integer.MIN_VALUE) {
				continue;
			}
			matrix[i][0] = matrix[i - 1][0] == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1;
		}
		for (int i = 1; i < c; i++) {
			if (matrix[0][i] == Integer.MIN_VALUE) {
				continue;
			}
			matrix[0][i] = matrix[0][i - 1] == Integer.MIN_VALUE ? Integer.MIN_VALUE : 1;
		}
		
		for (int i = 1; i < r; i++) {
			for (int j = 1; j < c; j++) {
				if (matrix[i][j] == Integer.MIN_VALUE) {
					continue;
				}
				if (matrix[i - 1][j] == Integer.MIN_VALUE) {
					matrix[i][j] = matrix[i][j - 1];
				} else if (matrix[i][j - 1] == Integer.MIN_VALUE) {
					matrix[i][j] = matrix[i - 1][j];
				} else {
					matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1];
				}
			}
		}
		return matrix[r - 1][c - 1];
	}
}
