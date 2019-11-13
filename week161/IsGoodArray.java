package week161;

public class IsGoodArray {
	private int gcd(int a, int b){
	    return b == 0 ? a : gcd(b, a % b);
	}
	public boolean isGoodArray(int[] nums) {
		int res = nums[0];
		for(int i = 1; i < nums.length; i++) {
			res = gcd(res,nums[i]);
		}
		return res==1;
    }
	public static void main(String[] args) {
		int[] nums = {12,5,7,23};
		IsGoodArray ga = new IsGoodArray();
		System.out.println(ga.isGoodArray(nums));
	}
}
