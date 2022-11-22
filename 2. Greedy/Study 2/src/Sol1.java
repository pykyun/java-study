/*
 * title: 거스름 돈
 */

public class Sol1 {
    public static void main(String[] args) throws Exception{
        System.out.println(minChange(1260));
    }

    static int minChange (int num){
        int result = 0;
        int[] arr = {500, 100, 50, 10};

        for(int coin : arr){
            // 해당 화폐로 거슬러 줄 수 있는 동전의 개수
            result += num/coin;
            num %= coin;
        }
    
        return result;
    }
}
