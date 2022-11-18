import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int n = 6;
        Student[] list = new Student[n];
        list[0] = new Student("Samwise Gamgee");
        list[1] = new Student("Rubeus Hagrid");
        list[2] = new Student("Dart Maul");
        list[3] = new Student("Robb Stark");
        list[4] = new Student("Alfred Tarski");
        list[5] = new Student("Barash");
        var finished = false;
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        while (!finished) {
            System.out.println("Введите команду, чтобы посмотреть список введите h");
            String com = in.nextLine();
            if (com.equals("h")) {
                System.out.println("r - спросить случайного студента");
                System.out.println("l - вывести список студентов");
                System.out.println("h - вывести список команд");
                System.out.println("f - закончить");
            } else if (com.equals("r")) {
                int ind = rnd.nextInt(n);
                list[ind].question(in);
            } else if (com.equals("l")) {
                PrettyTable table = new PrettyTable("Имя", "Оценка");
                for (int ind = 0; ind < n; ++ind) {
                    String mark;
                    if (!list[ind].is_here){
                        mark = "н";
                    } else if (list[ind].mark == -1) {
                        mark = ".";
                    } else {
                        mark = Integer.toString(list[ind].mark);
                    }
                    table.addRow(list[ind].name, mark);
                }
                System.out.println(table);
            } else if (com.equals("f")){
                finished = true;
            } else {
                System.out.println("Вы ввели что-то не то");
            }
        }
    }
}