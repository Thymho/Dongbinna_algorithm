package dongbina;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class greedy1 {
    public static void main(String[] args) throws IOException {
         BufferedReader 클래스와 StringTokenizer 클래스 선언
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
				
				 N, M, K 선언 및 입력받기.
				 BufferedReader 객체로 입력을 받아야 입력받는 시간을 단축시킬 수 있다.
				 하지만 BufferedReader는 한 줄 단위로 읽어오기 때문에 파싱 작업이 필요함.
				 따라서 StringTokenizer 객체를 이용해준다.
        final int N = Integer.parseInt(st.nextToken());
        final int M = Integer.parseInt(st.nextToken());
        final int K = Integer.parseInt(st.nextToken());
        int [] nums = new int[N];

				 자바에서 정수형의 최대 자료형은 long이다..
				 double로 하면 오차가 생길 가능성이 있음
				 longlong도 있긴 하지만.. 그건 Long클래스의 객체라서 자료형에선 제외함
        long sum = 0;

				 br을 다시 선언해준 이유는 br은 버퍼에 데이터를 저장하는 방식이기 때문에
				 초기화를 해주고 다시 입력을 받아줘야 한다.
        br = new BufferedReader(new InputStreamReader(System.in));
				st = new StringTokenizer(br.readLine());

				 배열에 입력받은 값 저장하기
				 생각해보니 st가 for문 안이 아니라 br 바로 밑에 있어도 괜찮았을거란 생각이...
				 여기는 st를 for문 밖으로 뺐네... 이런..
        for(int i=0; iN; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

				그리디의 핵심 부분이다.
				 정렬을 해줘야 그리디 방식으로 접근이 가능하다.
        Arrays.sort(nums);

				 배열에서 가장 큰 값과 2번째로 큰 값을 저장해준다.
				 여기에선 이 두개의 숫자만 사용하게 될거임.
				 가장 큰 숫자를 K번 더하고 두번째로 큰 숫자로 쿨타임 돌린 다음에
				 다시 가장 큰 숫자를 더해줘야 함
        int biggest = nums[N-1];
        int second_big = nums[N-2];

				 이건 동빈나님의 해설에 적혀있던 공식인데,
				 반복되는 수열의 성질을 이용한 공식이다.
				 count는 큰 수가 몇 번 더해지는 지 체크하는 변수다.
				 M은 총 더해야 하는 숫자의 개수이고, 
				 지금 예제에선 반복되는 수열의 길이가 4인데 (= 6,6,6,5),
				 이것을 나눠준 것이다. (= K+1) 즉, 2세트가 필요하다는 것이다.
				 K를 곱해준건 가장 큰 수가 하나의 수열에 K번 등장하기 때문이다.
				 M % (K+1)은 M이 (K+1)로 나눠떨어지지 않았을 때를 대비한 식이다.
				 나머지만큼 더 많이 등장한다는 뜻이므로 count에 더해준다.
        long count = (M(K+1))K;
        count += M % (K+1);

				 그럼 이제 남은건 가장 큰 숫자를 등장했던 개수만큼 곱해주는 것과
				 타이밍에 맞게 두번째로 큰 숫자를 곱하는 것이다.
				 두번째로 큰 숫자는 가장 큰 숫자들이 등장한 개수를 M에서 뺀 것만큼 곱하면 되니까
				 그렇게 곱해준 것을 더해준다.
        sum = count  biggest;
        sum += (M-count)  second_big;

				 그렇게 나온 결과값을 출력한다.
        System.out.println(sum);
    }
}