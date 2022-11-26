/*
 * num: 7562
 * title: 나이트의 이동
 */

import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Queue;
import java.util.LinkedList;
import java.util.StringTokenizer;

class Node{
    private int x;
    private int y;
    private int cnt;

    public Node(int x, int y, int cnt){
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public int getC(){
        return this.cnt;
    }
}

public class Main {
    static int[][] graph;
    static int[][] move = {{-2,-1},{-1,-2},{-2,1},{-1,2},{1,-2},{2,-1},{2,1},{1,2}};
    static boolean[][] visited;
    static int arriveX, arriveY, I;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());
        int startX = 0;
        int startY = 0;

        for(int i=0; i<TC; i++){
            I = Integer.parseInt(br.readLine());
            graph = new int[I][I];
            visited = new boolean[I][I];
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            startX = Integer.parseInt(st.nextToken());
            startY = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            arriveX = Integer.parseInt(st.nextToken());
            arriveY = Integer.parseInt(st.nextToken());

            bfs(startX, startY, 0);
        }


    }

    public static void bfs(int startX, int startY, int startC){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(startX, startY, startC));
        
        visited[startX][startY] = true;

        while(!q.isEmpty()){
            Node node = q.poll();

            int tempX = node.getX();
            int tempY = node.getY();
            int cnt = node.getC();

            if(tempX == arriveX && tempY == arriveY){
                System.out.println(cnt);
                return;
            }

            for(int i=0; i<move.length; i++){
                int nx = tempX + move[i][0];
                int ny = tempY + move[i][1];

                if(nx >= 0 && nx < I && ny >= 0 && ny < I && !visited[nx][ny]){
                    q.offer(new Node(nx, ny, cnt+1));
                    visited[nx][ny] = true;
                }
            }
        }
    }
}
