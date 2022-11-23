/*
 * title: 상하좌우
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol5 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] move = {"R", "L", "U", "D"};
        int[] dx = {0,0,-1,1};
        int[] dy = {1,-1,0,0};
        
        int x = 1; 
        int y = 1; // 시작 위치 (1,1)
        int nx = x;
        int ny = y;

        StringTokenizer st = new StringTokenizer(br.readLine());
        while(st.hasMoreTokens()){
            String plan = st.nextToken();
            
            // 상하좌우 확인
            for(int i=0; i<4; i++){
                if(plan.equals(move[i])){
                    nx = x+dx[i];
                    ny = y+dy[i];
                }
            }

            if(nx < 1 || nx > N || ny < 1 || ny > N){
                continue;
            } else {
                x = nx;
                y = ny;
            }
        }

        System.out.println(x + " " + y);
    }
}
