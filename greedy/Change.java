public class greedy_exam {
    public static void main(String[] args) {
        int N = 1260;
        int count = 0;

        // 큰 단위의 화폐부터 차례대로 확인
        int[] coin_types = {500, 100, 50, 10};

        for(int i=0; i< coin_types.length; i++) {
            count += N/coin_types[i];
            N %= coin_types[i];
        }

        System.out.println(count);
    }
}