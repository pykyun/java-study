/*
 * num: 004
 * title: DFS 예제1
 */

public class DFS1 {
    static boolean[] visited = new boolean[9];
    static int[][] graph = {{}, {2,3,8}, {1,7}, {1,4,5}, {3,5}, {3,4}, {7}, {2,6,8}, {1,7}};
    //static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    
    public static void main(String[] args) throws Exception{
        dfs(1);
    }
    
    public static void dfs(int index){
        visited[index] = true; // 방문 처리
        System.out.print(index + " -> ");

        for(int node : graph[index]){
            if(!visited[node])
                dfs(node);
        }
    }
}

/*
 * boolean[] visited : 방문한 노드 확인
 * int[][] graph : 각 노드가 연결된 정보 표현
 * ex) 1번 노드와 연결된 것은 2, 3, 8
 * 일반적으로, 그래프 문제에서 노드의 번호가 1번부터 시작하는 경우가 많기 때문에,
 * index = 0의 경우 비워둘 수 있도록 함
 */