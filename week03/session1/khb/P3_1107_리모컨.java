package week03.session1.khb;

import java.util.*;
import java.io.*;

public class P3_1107_리모컨 {
	public int solution(int n, int m, int[] button) {
		int answer = Math.abs(n - 100);
		if (n == 100) return 0;

		for (int i = 0; i < 999999; i++) {
			String value = String.valueOf(i);
			 boolean flag = true;

			for (int j = 0; j < value.length(); j++) {
				if (button[value.charAt(j) - '0'] == 1) {
					flag = false;
					break;
				}
			}
			if (flag) {
				answer = Math.min(answer, Math.abs(n - i) + value.length());
			}
		}

		return answer;
	}

	public static void main(String[] args) throws Exception {
		P3_1107_리모컨 T = new P3_1107_리모컨();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		int[] button = new int[10];
		if(m > 0) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < m; i++) {
				button[Integer.parseInt(st.nextToken())] = 1;
			}
		}

		bw.write(String.valueOf(T.solution(n, m, button)));
		bw.flush();
		bw.close();
		br.close();
	}
}
