package week02.session2.khb;

import java.util.*;
import java.io.*;

public class P2_2108_통계학 {
	public int[] solution(int n, int[] input) {
		int[] answer = new int[4];
		int sum = 0;
		TreeMap<Integer, Integer> tm = new TreeMap<>();

		Arrays.sort(input);
		for (int x : input) {
			sum += x;
			tm.put(x, tm.getOrDefault(x, 0) + 1);
		}

		answer[0] = (int) Math.round(sum / (double) n);
		answer[1] = input[n / 2];

		int max = Integer.MIN_VALUE;
		for (int x : tm.keySet()) {
			if (tm.get(x) > max) {
				answer[2] = x;
				max = tm.get(x);
			}
		}

		int count = 0;
		for (int x : tm.keySet()) {
			if (tm.get(x) == max) {
				count++;
			}
			if (count == 2) {
				answer[2] = x;
				break;
			}
		}

		answer[3] = input[n - 1] - input[0];

		return answer;
	}

	public static void main(String[] args) throws Exception {
		P2_2108_통계학 T = new P2_2108_통계학();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int[] input = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = Integer.parseInt(br.readLine());
		}

		for (int x : T.solution(n, input)) {
			bw.write(String.valueOf(x) + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
