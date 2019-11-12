package week162;

import java.awt.Point;
import java.util.LinkedList;
import java.util.Queue;

public class ClosedIsland {
	private int[][] dir = {{0,1},{0,-1},{1,0},{-1,0}};
	private boolean isLeagel(int x,int y,int n,int m) {
		if(x>=0&&x<n&&y>=0&&y<m) return true;
		return false;
	}
	private int bfs(int x,int y,int[][] grid, int[][] vis) {
		boolean flag = true;
		int n = grid.length;
		int m = grid[0].length;
		Queue<Point> que = new LinkedList<>();
		que.add(new Point(x,y));
		vis[x][y] = 1;
		while(!que.isEmpty()) {
			Point tmp = que.poll();
			vis[tmp.x][tmp.y] = 1;
			for(int i = 0; i < 4; i++) {
				int nx = dir[i][0] + tmp.x;
				int ny = dir[i][1] + tmp.y;
				if(isLeagel(nx,ny,n,m)) {
					if(grid[nx][ny]==0 && vis[nx][ny]==0) que.add(new Point(nx,ny));
				} else {
					flag = false;
				}
			}
		}
		if(flag) return 1;
		else return 0;
	}
	public int closedIsland(int[][] grid) {
		int n = grid.length;
		int m = grid[0].length;
		int[][] vis = new int[n][m];
		int ans = 0;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				if(grid[i][j] == 0 && vis[i][j] == 0) {
					ans += bfs(i,j,grid,vis);
				}
			}
		}
        return ans; 
    }
	public static void main(String[] args) {
		int[][] grid = {
				 {0,0,1,0,0}
				,{0,1,0,1,0}
				,{0,1,1,1,0}
				};
		ClosedIsland ci = new ClosedIsland();
		System.out.println(ci.closedIsland(grid));
	}
}
