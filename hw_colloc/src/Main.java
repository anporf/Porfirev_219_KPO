import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Integer val1 = 0, val2 = 0;
        Command command = new Command();

        Scanner in = new Scanner(System.in);
        int radix = in.nextInt();
        val1 = command.call(new ButtonNumber(), val1, radix);
        radix = in.nextInt();
        val2 = command.call(new ButtonNumber(), val2, radix);
        System.out.println(command.call(new ButtonArithmetic('+'), val1, val2));
    }
}