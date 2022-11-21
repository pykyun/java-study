/*
 * num: 001
 * title: 재귀 함수 예제
 */

public class Recursive {
    public static void main(String[] args) throws Exception{
        recursiveFunction(1);
    }

    public static void recursiveFunction(int i) {
        if(i == 20){
            return;
        } // 종료 조건

        System.out.println(i + "번째 재귀함수에서 " + (i+1) + "번째 재귀함수 호출");
        recursiveFunction(i+1);
        //System.out.println("숫자 확인 : " + i);
        System.out.println(i + "번째 재귀함수 종료");
    }
}

/*
 * Stack에 데이터를 넣었다 꺼내는 것과 마찬가지
 * 각각의 함수에 대한 정보가 Stack frame에 담기면서 차례대로 호출되고,
 * 마지막에 호출된 함수부터 차례로 종료됨 (LIFO, 후입선출)
 */