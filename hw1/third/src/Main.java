public class Main {
    public static void main(String[] args) {
        int size = 100;
        boolean[] is_prime = new boolean[size + 1];
        for (int i = 0; i <= size; ++i) {
            is_prime[i] = true;
        }
        is_prime[0] = false;
        is_prime[1] = false;
        for (int i = 2; i <= size; ++i) {
            if (is_prime[i]) {
                for (int j = i * i; j <= size; j += i) {
                    is_prime[j] = false;
                }
            }
        }
        for (int i = 0; i <= size; ++i) {
            if (is_prime[i]) {
                System.out.println(i);
            }
        }
    }
}