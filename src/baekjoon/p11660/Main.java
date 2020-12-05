package baekjoon.p11660;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int N;   // 수의 개수
    static int M;   // 합을 구해야 하는 횟수

    static int[][] NArr;  // 구간합 배열

    static BufferedReader br;
    static StringTokenizer st;

    public static void main(String[] args) throws Exception {

        System.setIn(new FileInputStream("D:\\Development\\algorithm-study\\src\\baekjoon\\p11660\\sample_input.txt"));

        br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        NArr = new int[N + 1][N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                NArr[i][j] = NArr[i - 1][j] + NArr[i][j - 1] - NArr[i - 1][j - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int x1, y1, x2, y2;
        for (int m = 0; m < M; m++) {
            st = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(st.nextToken());
            y1 = Integer.parseInt(st.nextToken());
            x2 = Integer.parseInt(st.nextToken());
            y2 = Integer.parseInt(st.nextToken());
            System.out.println(NArr[x2][y2] - NArr[x1 - 1][y2] - NArr[x2][y1 - 1] + NArr[x1 - 1][y1 - 1]);
        }

    }

}
