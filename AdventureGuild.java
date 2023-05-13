package dongbina.greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class adventurer_Guild {

    public static ArrayList<Integer> fear = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        final int N = Integer.parseInt(st.nextToken());
        int count = 0;
        int group = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            fear.add(Integer.parseInt(st.nextToken()));
        }

        Collections.sort(fear);

        for (int i = 0; i < N; i++) { // 공포도를 낮은 것부터 하나씩 확인하며
            count += 1; // 현재 그룹에 해당 모험가를 포함시키기
            if (count >= fear.get(i)) { // 현재 그룹에 포함된 모험가의 수가 현재의 공포도 이상이라면, 그룹 결성
                group += 1; // 총 그룹의 수 증가시키기
                count = 0; // 현재 그룹에 포함된 모험가의 수 초기화
            }
        }

        sb.append(group).append('\n');
        System.out.println(group);
    }
}