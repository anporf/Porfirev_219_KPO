public class Main {
    public static void main(String[] args) {
        ColorPrint colorPrint = new ColorPrint();
        BlackPrint blackPrint = new BlackPrint();
        for (int i = 0; i < 100; ++i) {
            if (i % 2 == 0) { // контекст
                colorPrint.print();
            } else {
                blackPrint.print();
            }
        }
    }
}