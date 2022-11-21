/*
 * num: 003
 * title: 최대공약수 구하기 : 유클리드 호제법
 */

public class Euclidean {
    public static void main(String[] args) throws Exception{
        int result = gcd(192, 162);
        System.out.println(result);
    }

    public static int gcd(int a, int b){
        if(a % b == 0)
            return b;
        
        return gcd(b, a%b);
    }
}