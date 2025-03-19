package taskScheduler;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/task-scheduler/
public class Solution {
	public static void main(String[] args) {
		char[] tasks = { 'A', 'B', 'C', 'D', 'E', 'A', 'B', 'C', 'D', 'E'};
		int n = 2;
		System.out.println(leastInterval(tasks, n));

	}

	public static int leastInterval(char[] tasks, int n) {
		int[] tasksCount = new int['Z' - 'A' + 1];
		int[] lastIndex = new int['Z' - 'A' + 1];

		List<String> rss = new ArrayList<String>();

		for (int i = 0; i < tasks.length; i++) {
			tasksCount[tasks[i] - 'A']++;
		}

		int rs = 0;
		int tasksLength = tasks.length;

		while (tasksLength > 0) {
			boolean f = false;
			for (int i = 0; i < tasksCount.length; i++) {
				while (tasksCount[i] > 0) {
					f = false;
					if (lastIndex[i] == 0) {
						rs++;
						tasksCount[i]--;
						lastIndex[i] = rs;
						tasksLength--;
						rss.add((char) (i + 'A') + "");
						i = 0;
						f = true;
					} else {
						if (rs - lastIndex[i] >= n) {
							rs++;
							tasksCount[i]--;
							lastIndex[i] = rs;
							tasksLength--;
							rss.add((char) (i + 'A') + "");
							i = 0;
							f = true;
						} 
						else {
							i++;
						}
					}
					
					
				}

			}
			if (f == false) {
				rss.add("idle");
				rs++;
			}
		}
		System.out.println(rss);

		return rs;
	}

}
