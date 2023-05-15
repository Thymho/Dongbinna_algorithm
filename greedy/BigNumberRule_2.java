package dongbina.greedy.repeat;

import java.io.*;
import java.util.*;

public class bigNumberRule_2 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        long[] nums = new long[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            nums[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(nums);

        long biggest = nums[N-1];
        long second = nums[N-2];
//        long count = M/(K+1); // 몇 세트 반복하는지
//        count += M%(K+1);
//        long answer = (biggest*K+second)*count;

        // M/(K+1)을 하는 이유: 총 몇 세트 반복하는지 알기 위해서
        // (M/(K+1))*K를 하는 이유: 큰 수가 몇 번 반복하는지 알기 위해서
        long count = (long) (M/(K+1))*K; // 큰 수가 몇 번 반복하는지

        // 나머지를 더하는 이유
        // 만약 M이 5이고 K+1이 3이면 나누어떨어지지 않고 그대로 남아있게 됨
        // 하지만 이 나머지는 곧 하나의 세트가 될 수 있기 때문에 더해준다.
        count += M%(K+1);
        long answer = biggest*count;

        // M-count를 하는 이유
        // 가장 큰 숫자를 제외하기 위해서
        answer += (M-count)*second;


        System.out.println(answer);
    }
}