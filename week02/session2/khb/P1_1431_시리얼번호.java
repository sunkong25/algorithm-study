package week02.session2.khb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class P1_1431_시리얼번호 {
	public String[] solution(int n, String[] input) {
		String[] answer = new String[n];

		Arrays.sort(input, (a, b) -> {
			int sumA = 0, sumB = 0;
			if (a.length() != b.length()) {
				return a.length() - b.length();
			}

			for (int i = 0; i < a.length(); i++) {
				if (Character.isDigit(a.charAt(i))) {
					sumA += a.charAt(i) - '0';
				}
				if (Character.isDigit(b.charAt(i))) {
					sumB += b.charAt(i) - '0';
				}
			}

			if (sumA != sumB) {
				return sumA - sumB;
			}

			return a.compareTo(b);
		});

		return input;
	}

	public static void main(String[] args) throws Exception {
		P1_1431_시리얼번호 T = new P1_1431_시리얼번호();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] input = new String[n];
		for (int i = 0; i < n; i++) {
			input[i] = br.readLine();
		}

		for (String x : T.solution(n, input)) {
			bw.write(x + "\n");
		}

		br.close();
		bw.flush();
		bw.close();
	}
}
