/*
 * title: 곱하기 혹은 더하기
 */

 import java.io.BufferedReader;
 import java.io.InputStreamReader;

public class Sol3 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        
        int[] arr = new int[str.length()];
        int result = 1;

        for(int i=0; i<str.length(); i++){
            arr[i] = str.charAt(i) - '0';
        }

        for(int j=0; j<str.length(); j++){
            if(arr[j] == 0 || arr[j] == 1){
                result += arr[j];
                continue;
            }

            result *= arr[j];
        }

        System.out.println(result);
    }
}
