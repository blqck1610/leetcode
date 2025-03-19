package MaximizeHappiness;

import java.util.Arrays;

public class Solution {
	public static void main(String[] args) {
		int[] happiness = {12,1,42, 52 ,3};
		int k = 3;
		System.out.println(maximumHappinessSum(happiness, k));

	}

	public static long maximumHappinessSum(int[] happiness, int k) {
		
		long rs = 0;
		Arrays.sort(happiness);

		for(int index = 0; index < k; index++) {
			if(happiness[happiness.length - index - 1] - index <= 0) break;
			rs += happiness[happiness.length - index - 1] - index;
		}
		
		return rs;

	}
	

}

//------------------
// memory limit exceeded
//int max = 0;
//long rs = 0;
//for (int i = 0; i < happiness.length; i++) {
//	if (happiness[i] > max) {
//		max = happiness[i];
//	}
//}
//
//int[] happinessToIndex = new int[max + 1];
//for (int i = 0; i < happiness.length; i++) {
//	happinessToIndex[happiness[i]]++;
//}
//int count = 0;
//for (int i = happinessToIndex.length - 1; i >= 0; i--) {
//	if (i - count == 0) {
//		break;
//	}
//	if (happinessToIndex[i] > 0) {
//		rs += i - count;
//		count++;
//		happinessToIndex[i]--;
//		i++;
//	}
//	if (count == k) {
//		break;
//	}
//}
//
//return rs;
//
//}
//---------------------------------------------------------------
// time limit exceeded
//int index = 0;
//long rs = 0;
//
//
//while(index < k) {
//	int max = 0;
//	int selectedi = 0;
//	for (int i = 0; i < happiness.length; i++) {
//		if (happiness[i] > max) {
//			max = happiness[i];
//			selectedi = i;
//		}
//	}
//	happiness[selectedi] = 0;
//	if(max - index <= 0 ) break;
//	rs += max - index;
//	index ++;
//
//}
//
//return rs;
