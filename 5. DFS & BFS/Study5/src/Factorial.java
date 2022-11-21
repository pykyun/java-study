/*
 * num: 002
 * title: 팩토리얼 구현 예제
 */

public class Factorial {
    public static void main(String[] args) throws Exception{
        System.out.println("반복적으로 구현 : " + factorial_iterative(5));
        System.out.println("재귀적으로 구현 : " + factorial_recursive(5));
    }

    static int factorial_iterative(int n){
        int result = 1;

        for(int i=1; i<=n; i++){
            result *= i;
        }
        return result;
    }

    static int factorial_recursive(int n){
        if(n <= 1)
            return 1;
        // 1!이 실행된 시점에서 종료
        
        return n * factorial_recursive(n-1);
        // 5 * 4! -> 5 * 4 * 3! -> ...
    }
}
