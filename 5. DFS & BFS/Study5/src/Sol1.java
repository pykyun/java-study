/*
 * title: 음료수 얼려 먹기
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol1 {
    public static int N, M;
    public static int[][] graph;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        graph = new int[N][M];
        int result = 0;

        for(int i=0; i<N; i++){
            String str = br.readLine();

            for(int j=0; j<M; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(dfs(i,j))
                    result++;
            }
        }

        System.out.println(result);
    }

    public static boolean dfs(int n1, int n2){
        // N * M 배열 범위 벗어날 경우
        if(n1 < 0 || n1 >= N || n2 < 0 || n2 >= M)
            return false;

        if(graph[n1][n2] == 0){
            graph[n1][n2] = 1; // 방문 확인

            // 상하좌우 위치 고려
            dfs(n1-1, n2);
            dfs(n1, n2-1);
            dfs(n1+1, n2);
            dfs(n1, n2+1);

            return true;
        } else {
            return false;
        }
    }
}