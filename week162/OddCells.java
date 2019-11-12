package week162;

public class OddCells {
	public static int oddCells(int n, int m, int[][] indices) {
		int[][] martix = new int[n][m];
		for(int i = 0; i < indices.length; i++) {
			int x = indices[i][0];
			int y = indices[i][1];
			for(int j = 0; j < n; j++) {
				martix[j][y] ++;
			}
			for(int j = 0; j < m; j++) {
				martix[x][j] ++;
			}
		}
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(martix[i][j] % 2 == 1) ans ++;
			}
		}
        return ans;
    }
	public static void main(String[] args) {
		int n = 2;
		int m = 3;
		int[][] indices = {{0,1},{1,1}};
		System.out.println(oddCells(n,m,indices));
	}
}
