package week03.session1.khb;

import java.util.*;
import java.io.*;

public class P2_1051_숫자정사각형 {
	public int solution(int n, int m, int[][] input) {
		int answer = 0;

		int size = Math.min(n, m);
		boolean flag = false;
		while (size != 1) {
			for (int i = 0; i <= n - size; i++) {
				for (int j = 0; j <= m - size; j++) {
					if (input[i][j] == input[i + size - 1][j] && input[i][j] == input[i][j + size - 1]
							&& input[i][j] == input[i + size - 1][j + size - 1]) {
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			if(flag) break;
			size--;
		}

		answer = size * size;
		return answer;
	}

	public static void main(String[] args) throws Exception {
		P2_1051_숫자정사각형 T = new P2_1051_숫자정사각형();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] input = new int[n][m];
		for (int i = 0; i < n; i++) {
			String a = br.readLine();
			for (int j = 0; j < m; j++) {
				input[i][j] = a.charAt(j) - '0';
			}
		}
		bw.write(String.valueOf(T.solution(n, m, input)));

		bw.flush();
		bw.close();
		br.close();
	}
}
