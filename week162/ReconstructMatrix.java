package week162;

import java.util.ArrayList;
import java.util.List;

public class ReconstructMatrix {

	public static List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
		List<List<Integer>> ans = new ArrayList<>();
		List<Integer> up = new ArrayList<>();
		List<Integer> down = new ArrayList<>();
		int countTwo = 0;
		int temp = 0;
		for(int i = 0; i < colsum.length; i++) {
			if(colsum[i] == 2) countTwo ++;
			temp += colsum[i];
		}
		if(temp != (upper + lower)) return ans;
		int left = upper - countTwo;
		int resLower = 0;
		for(int i = 0; i < colsum.length; i++) {
			if(colsum[i]==2) {
				up.add(1);
				down.add(1);
				resLower += 1;
			} else if(colsum[i]==0) {
				up.add(0);
				down.add(0);
			} else {
				if(left>0) {
					up.add(1);
					down.add(0);
					left --;
				} else {
					up.add(0);
					down.add(1);
					resLower += 1;
				}
			}
		}
		if(resLower != lower) {
			List<List<Integer>> res = new ArrayList<>();
			return res;
		}
		ans.add(up);
		ans.add(down);
		return ans;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int upper = 9;
		int lower = 2;
		int[] colsum = {0,1,2,0,0,0,0,2,1,2,1,2};
		List<List<Integer>> list = reconstructMatrix(upper,lower,colsum);
		if(list == null) {
			System.out.println("null");
			return ;
		}
		for(List<Integer> temp : list) {
			for(int value : temp) {
				System.out.print(value + " ");
			}
			System.out.println();
		}
	}

}
