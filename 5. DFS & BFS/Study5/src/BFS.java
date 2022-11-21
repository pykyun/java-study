/*
 * num: 005
 * title: BFS 예제
 */

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    static boolean[] visited = new boolean[9];
    static int[][] graph = {{}, {2,3,8}, {1,7}, {1,4,5}, {3,5}, {3,4}, {7}, {2,6,8}, {1,7}};
    public static void main(String[] args) throws Exception{
        bfs(1);
    }

    public static void bfs(int index){
        StringBuilder sb = new StringBuilder();
        Queue<Integer> bq = new LinkedList<>();

        visited[index] = true; // 방문 처리
        bq.offer(index);
        
        while(!bq.isEmpty()){
            int node = bq.poll();
            sb.append(node + " -> ");

            for(int i=0; i<graph[node].length; i++){
                int tmp = graph[node][i];

                if(!visited[tmp]){
                    visited[tmp] = true;
                    bq.offer(tmp);
                }
            }
        }

        System.out.println(sb.toString());
    }
}
