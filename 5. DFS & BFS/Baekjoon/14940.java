/*
 * num: 14940
 * title: 쉬운 최단거리
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;
import java.lang.StringBuilder;

class Node{
    private int x;
    private int y;
    private int m;

    public Node(int x, int y, int m){
        this.x = x;
        this.y = y;
        this.m = m;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getM(){
        return this.m;
    }
}

public class Main {
    static int N, M;
    static int[][] graph;
    static int[][] answer;
    static boolean[][] visited;
    static int[] dx = {0,0,-1,1};
    static int[] dy = {-1,1,0,0};

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int firstX = 0;
        int firstY = 0;

        graph = new int[N][M];
        answer = new int[N][M];
        visited = new boolean[N][M];

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                graph[i][j] = Integer.parseInt(st.nextToken());
                
                if(graph[i][j] == 0){
                    answer[i][j] = 0;
                }
                else if(graph[i][j] == 2){
                    visited[i][j] = true;
                    firstX = i;
                    firstY = j;
                } else {
                    answer[i][j] = -1;
                }
            }
        }

        dfs(firstX, firstY, 0);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                sb.append(answer[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static void dfs(int firstX, int firstY, int m){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(firstX, firstY, m));

        while(!q.isEmpty()){
            Node node = q.poll();

            int x = node.getX();
            int y = node.getY();
            int move = node.getM();
            answer[x][y] = move;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if(visited[nx][ny] || graph[nx][ny] == 0)
                    continue;

                visited[nx][ny] = true;
                q.offer(new Node(nx, ny, move+1));
            }
        }
    }
}