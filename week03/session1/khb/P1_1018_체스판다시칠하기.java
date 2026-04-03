package week03.session1.khb;

import java.util.*;
import java.io.*;

public class P1_1018_체스판다시칠하기 {
	public int solution(int n, int m, char[][] input) {
		int answer = Integer.MAX_VALUE;
		int min = Integer.MAX_VALUE;

		for (int i = 0; i < n - 7; i++) {
			for (int j = 0; j < m - 7; j++) {
				int countX = 0, countY = 0;

				for (int k = 0; k < 8; k++) {
					for (int v = 0; v < 8; v++) {
						int cur = input[i + k][j + v];

						if ((k + v) % 2 == 0) {
							if (cur != 'B')
								countX++;
							if (cur != 'W')
								countY++;
						} else {
							if (cur != 'W')
								countX++;
							if (cur != 'B')
								countY++;
						}
					}
				}
				min = Math.min(countX, countY);
				answer = Math.min(answer, min);
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		P1_1018_체스판다시칠하기 T = new P1_1018_체스판다시칠하기();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		char[][] input = new char[n][m];
		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			for (int j = 0; j < m; j++) {
				input[i][j] = a.charAt(j);
			}
		}

		bw.write(String.valueOf(T.solution(n, m, input)));
		bw.flush();
		bw.close();
		br.close();
	}
}
