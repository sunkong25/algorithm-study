package week02.session2.khb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class P4_2170_선긋기 {
	public int solution(int n, int[][] input) {
		int answer = 0;

		Arrays.sort(input, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			}
			return a[0] - b[0];
		});

		int start = input[0][0];
		int end = input[0][1];

		for (int i = 0; i < n; i++) {
			if (end > input[i][0]) {
				end = Math.max(end, input[i][1]);
			} else {
				answer += (end - start);
				start = input[i][0];
				end = input[i][1];
			}
		}
		answer += (end - start);


		return answer;
	}

	public static void main(String[] args) throws Exception {
		P4_2170_선긋기 T = new P4_2170_선긋기();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int n = Integer.parseInt(br.readLine());
		int[][] input = new int[n][2];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			input[i][0] = Integer.parseInt(st.nextToken());
			input[i][1] = Integer.parseInt(st.nextToken());
		}

		bw.write(String.valueOf(T.solution(n, input)));

		bw.flush();
		bw.close();
		br.close();
	}
}
