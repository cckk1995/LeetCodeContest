package week162;

import java.util.HashMap;
import java.util.Map;

public class MaxScoreWords {
	int[] hash = new int[150];
	private int sco = 0;
	private int max = 0;
	private Map<String,Integer> map = new HashMap<>();
	public int maxScoreWords(String[] words, char[] letters, int[] score) {
        for(char letter : letters) {
        	hash[letter] += 1;
        }
        for(int  i = 0; i < words.length; i++) {
        	int s = 0;
        	for(int j = 0; j < words[i].length(); j++) {
        		s += score[words[i].charAt(j) - 'a'];
        	}
        	map.put(words[i], s);
        }
        backtrack(0,words,letters,score);
		return max;
    }
	private void backtrack(int n,String[] words, char[] letters, int[] score) {
		if(n >= words.length) {
			max = Math.max(sco, max);
			return;
		}
		for (int i = 0; i < 2; i++) {
	         if (i == 0) {
	             boolean ok = true;
	             for (int j = 0; j < words[n].length(); j++) {
	                 hash[words[n].charAt(j)] -= 1;
	                 if (hash[words[n].charAt(j)] < 0) {
	                     ok = false;
	                 }
	             }
	             if (ok) {
	                 sco += map.get(words[n]);
	                 backtrack(n + 1, words, letters, score);
	                 sco -= map.get(words[n]);
	             }
	             for (int j = 0; j < words[n].length(); j++) {
	                 hash[words[n].charAt(j)] += 1;
	             }
	         } else {
	             backtrack(n + 1, words, letters, score);
	         }
	     }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = {"xxxz","ax","bx","cx"};
		char[] letters = {'z','a','b','c','x','x','x'};
		int[] score = {4,4,4,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,5,0,10};
		MaxScoreWords msw = new MaxScoreWords();
		System.out.println(msw.maxScoreWords(words,letters,score));
	}

}
