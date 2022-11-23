/*
 * num: 2667
 * title: 단지번호 붙이기
 */

import java.util.ArrayList;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main{
    static int N;
    static int[][] graph;
    static boolean[][] visited;
    static ArrayList<Integer> apart = new ArrayList<>();
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};
    static int totalCnt = 0;
    static int apartCnt = 0;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new int[N][N];
        visited = new boolean[N][N];

        for(int i=0; i<N; i++){
            String str = br.readLine();

            for(int j=0; j<N; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                apartCnt = 0;
                if(graph[i][j] == 1 && !visited[i][j]){
                    totalCnt++;
                    apartCnt++;
                    dfs(i,j);
                    apart.add(apartCnt);
                }
            }
        }
        Collections.sort(apart);
        System.out.println(totalCnt);
        for(int a : apart){
            System.out.println(a);
        }
    }

    public static void dfs(int x, int y){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            
            if(graph[nx][ny] == 1 && !visited[nx][ny]){
                apartCnt++;
                dfs(nx,ny);
            }
        }
    }
}