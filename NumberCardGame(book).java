package dongbina.greedy;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy2 {
    public static void main(String[] args) throws IOException {
        // 시간 재는 클래스 선언
        long beforeTime = System.currentTimeMillis();

				// BufferedReader, StringTokenizer, StringBuilder 객체 각각 호출
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // N, M, biggest 변수 선언
				// BufferedReader는 입력 받는 속도가 빠르지만,
				// br.readLine()으로 읽어왔기 때문에 한 줄 단위로 읽어옴.
				// 그래서 StringTokenizer를 이용한 파싱이 필요함
				// 배열은 입력 받는 값들만 그 즉시 비교하면 되기 때문에 삭제
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int biggest = 0;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int min = 10001;

            for(int j=0; j<M; j++) {
                int num = Integer.parseInt(st.nextToken());
                min = Math.min(min, num);
            }

            biggest = Math.max(biggest, min);
        }

        sb.append(biggest).append('\n');
        System.out.println(sb);

        long afterTime = System.currentTimeMillis();
        long time_diff = (afterTime - beforeTime)/1000;
        System.out.println("실행 시간(m): "+time_diff);
    }
}