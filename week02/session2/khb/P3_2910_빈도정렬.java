package week02.session2.khb;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class P3_2910_빈도정렬 {
	public ArrayList<Integer> solution(int n, int c, ArrayList<Integer> input) {
		ArrayList<Integer> answer = new ArrayList<>();
		HashMap<Integer, Integer> hs = new HashMap<>();
		for (int x : input) {
			hs.put(x, hs.getOrDefault(x, 0) + 1);
			answer.add(x);
		}

		Collections.sort(answer, (a, b) -> {
			if(hs.get(a) == hs.get(b)){
				return input.indexOf(a) - input.indexOf(b);
			}
			return hs.get(b) - hs.get(a);
		});

		return answer;
	}
	public static void main(String[] args) throws Exception{
		P3_2910_빈도정렬 T = new P3_2910_빈도정렬();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken());

		ArrayList<Integer> input = new ArrayList<>();
		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < n; i++) {
			input.add(Integer.parseInt(st.nextToken()));
		}

		for (int x : T.solution(n, c, input)) {
			bw.write(x + " ");
		}
		bw.flush();
		bw.close();
		br.close();
	}
}
