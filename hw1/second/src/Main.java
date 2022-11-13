public class Main {
    public static void main(String[] args) {
        int size = 10;
        double[] A = new double[size];
        double max = 0, min = 1;
        for (int i = 0; i < size; ++i) {
            A[i] = Math.random();
            if (A[i] > max) {
                max = A[i];
            }
            if (A[i] < min) {
                min = A[i];
            }
        }
        System.out.println(String.format("Max: %f", max));
        System.out.println(String.format("Min: %f", min));
    }
}