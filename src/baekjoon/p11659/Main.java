package baekjoon.p11659;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;   // 수의 개수
    static int M;   // 합을 구해야 하는 횟수

    static int[] NArr;  // 구간합 배열

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("D:\\Development\\algorithm-study\\src\\baekjoon\\p11659\\sample_input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        NArr = new int[N + 1];
        for (int n = 1; n <= N; n++) NArr[n] = Integer.parseInt(st.nextToken()) + (n == 0 ? 0 : NArr[n - 1]);

        int from, to;
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            from = Integer.parseInt(st.nextToken());
            to = Integer.parseInt(st.nextToken());

            System.out.println(NArr[to] - (from > 1 ? NArr[from - 1] : 0));
        }

    }

}
