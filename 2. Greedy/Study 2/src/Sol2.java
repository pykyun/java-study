/*
 * title: 1이 될 때까지
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Sol2 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int result = 0;
        int target = 0;

        while(true){
            target = (N/K) * K; // 한 번에 나누어 떨어지는 수 찾기
            result += (N-target); // 1을 빼는 연산 횟수
            N = target; // N을 K로 나누어 떨어지는 수로 변경

            // N이 K보다 작을 경우 (더 나눌 수 없을 때)
            if(N < K)
                break;
            
            // K로 나누기
            result++;
            N /= K;
        }
        
        result += (N-1); // 남은 수에 1씩 빼기 연산

        System.out.println(result);
    }
}
