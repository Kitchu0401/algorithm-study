package baekjoon.p1932;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;           // 정수 삼각형의 층 수
    static int[][] NArr;    // 정수 삼각형 배열

    static int Answer;

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("D:\\Development\\algorithm-study\\src\\baekjoon\\p1932\\sample_input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));

        Answer = 0;

        N = Integer.parseInt(br.readLine());
        NArr = new int[N][];
        NArr[0] = new int[]{ Integer.parseInt(br.readLine()) };
        for (int n = 2; n <= N; n++) NArr[n - 1] = new int[n];

        for (int n = 2; n <= N; n++) {
            st = new StringTokenizer(br.readLine());
            for (int m = 0; m < n; m++) {
                int left, right;
                int value = Integer.parseInt(st.nextToken());

                // first
                if (m == 0) {
                    left = -1;
                    right = NArr[n - 2][0];
                }
                // last
                else if (m == NArr[n - 1].length - 1) {
                    left = NArr[n - 2][NArr[n - 2].length - 1];
                    right = -1;
                }
                // middle
                else {
                    left = NArr[n - 2][m - 1];
                    right = NArr[n - 2][m];
                }

                NArr[n - 1][m] = Math.max(left, right) + value;
                Answer = Math.max(Answer, NArr[n - 1][m]);
            }
        }

        System.out.println(Answer);

    }

}
