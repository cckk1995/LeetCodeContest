package week161;

public class MinimumSwap {
	public static int minimumSwap(String s1, String s2) {
		if(s1.length() != s2.length()) return -1;
		int cnt1 = 0;
		int cnt2 = 0;
		for(int i = 0; i < s1.length(); i++) {
			if(s1.charAt(i) != s2.charAt(i)) {
				if(s1.charAt(i)=='x')  cnt1 ++;
				else  cnt2 ++;
			}
		}
		if((cnt1+cnt2)%2==1) return -1;
		if(cnt1%2==0) {
			return cnt1/2 + cnt2/2;
		} else {
			return cnt1/2 + cnt2/2 + 2;
		}	
    }
	public static void main(String[] args) {
		String s1 = "xx";
		String s2 = "xy";
		System.out.println(minimumSwap(s1,s2));
	}
}