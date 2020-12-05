package baekjoon.p1915;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;   // 배열의 가로 길이
    static int M;   // 배열의 세로 길이

    static int[][] DP;

    static int Answer;

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("D:\\Development\\algorithm-study\\src\\baekjoon\\p1915\\sample_input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        DP = new int[N][M];

        for (int n = 0; n < N; n++) {
            char[] values = br.readLine().toCharArray();
            for (int m = 0; m < M; m++) {
                int value = Integer.parseInt(values[m] + "");

                if (value == 1) {
                    if (n == 0 || m == 0) DP[n][m] = 1;
                    else {
                        int minSurrounding = Math.min(Math.min(DP[n - 1][m - 1], DP[n - 1][m]), DP[n][m - 1]);
                        DP[n][m] = minSurrounding + 1;
                    }

                    Answer = Math.max(Answer, DP[n][m] * DP[n][m]);
                }
            }
        }

        System.out.println(Answer);

    }

}
