package RelativeRanks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//https://leetcode.com/problems/relative-ranks/description
//Accepted
public class Solution {
	public static void main(String[] args) {
		int[] sc = {1};
		for(String s : findRelativeRanks(sc)) {
			System.out.println(s);
		}

	}

	public static String[] findRelativeRanks(int[] score) {
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < score.length; i ++) {
			map.put(score[i], i);
		}
		List<Integer> key = new ArrayList<>(map.keySet());
		key.sort((Integer a, Integer b) -> b.compareTo(a));
		
		String[] ranks = new String[score.length >= 3 ? score.length : 3];
		ranks[0] = "Gold Medal";
		ranks[1] = "Silver Medal";
		ranks[2] = "Bronze Medal";
		
		for(int i = 3; i < ranks.length; i++) {
			ranks[i] = "" + (i + 1); 
		}
		String[] rs = new String[score.length];
		for(int i = 0; i < rs.length; i++) {
			rs[map.get(key.get(i))] = ranks[i];  
		}
		return rs;
	}

}

// best solution
//private int findMax(int[] score) {
//    int maxScore = 0;
//    for (int s : score) {
//        if (s > maxScore) {
//            maxScore = s;
//        }
//    }
//    return maxScore;
//}

//public String[] findRelativeRanks(int[] score) {
//    int N = score.length;
//
//    // Add the original index of each score to the array
//    // Where the score is the key
//    int M = findMax(score);
//    int[] scoreToIndex = new int[M + 1];
//    for (int i = 0; i < N; i++) {
//        scoreToIndex[score[i]] = i + 1;
//    }
//
//    final String[] MEDALS = {"Gold Medal", "Silver Medal", "Bronze Medal"};
//
//    // Assign ranks to athletes
//    String[] rank = new String[N];
//    int place = 1;
//    for (int i = M; i >= 0; i--) {
//        if (scoreToIndex[i] != 0) {
//            int originalIndex = scoreToIndex[i] - 1;
//            if (place < 4) {
//                rank[originalIndex] = MEDALS[place - 1];
//            } else {
//                rank[originalIndex] = String.valueOf(place);
//            }
//            place++;
//        }
//    }
//    return rank;
//}
