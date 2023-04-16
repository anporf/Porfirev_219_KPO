import java.util.Scanner;

public class Student {
    boolean is_here = true;
    int mark = -1;
    String name;
    boolean is_answered = false;

    Student(String name) {
        this.name = name;
    }

    void question(Scanner in) {
        if (is_answered) {
            System.out.println(String.format("Вы уже спрашивали %s", name));
        }
        else {
            is_answered = true;
            System.out.println(String.format("%s присутствует на паре? (y/n)", name));
            String req = in.nextLine();
            if (!req.equals("y")) {
                is_here = false;
            } else {
                System.out.println("Оценка");
                var try_mark = in.nextInt();
                while (try_mark < 0 || try_mark > 10) {
                    System.out.println("Оценка должна быть от 0 до 10");
                    try_mark = in.nextInt();
                }
                mark = try_mark;
                in.nextLine();
            }
        }
    }
}
