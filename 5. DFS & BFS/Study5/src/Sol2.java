/*
 * title: 미로 탈출
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

class Node{
    private int x;
    private int y;

    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int get_x() {
        return this.x;
    }

    public int get_y() {
        return this.y;
    }
}

public class Sol2 {
    public static int N, M;
    public static int[][] graph;
    public static int dx[] = {-1,1,0,0};
    public static int dy[] = {0,0,-1,1};
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        graph = new int[N][M];

        for(int i=0; i<N; i++){
            String str = br.readLine();

            for(int j=0; j<M; j++){
                graph[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs(0,0));
    }

    public static int bfs(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x,y));

        while(!q.isEmpty()){
            Node node = q.poll();

            x = node.get_x();
            y = node.get_y();

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];

                if(nx < 0 || nx >= N || ny < 0 || ny >= M)
                    continue;

                if(graph[nx][ny] == 0)
                    continue;

                if(graph[nx][ny] == 1){
                    graph[nx][ny] = graph[x][y] + 1; // 이동하기 전 값(거리) + 1
                    q.offer(new Node(nx, ny));
                }
            }
        }

        return graph[N-1][M-1];
    }
}
