import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Main {
    public static void addStudents(ArrayList<Student> students) {
        try {
            java.sql.Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\Anton\\AppData\\Roaming\\DBeaverData\\workspace6\\.metadata\\sample-database-sqlite-1\\Chinook.db", "username", "password");
            String req = "CREATE TABLE students (id SERIAL PRIMARY KEY, name VARCHAR(255), mark int, is_here BOOLEAN, is_answered BOOLEAN)";
            conn.createStatement().execute(req);

            PreparedStatement stmt = conn.prepareStatement("INSERT INTO students (name) VALUES (?)");

            for (int i = 0; i < students.size(); ++i) {
                stmt.setString(1, students.get(i).name);
                stmt.executeUpdate();
            }
            conn.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<Student> list = new ArrayList<>();
        list.add(new Student("Samwise Gamgee"));
        list.add(new Student("Rubeus Hagrid"));
        list.add(new Student("Dart Maul"));
        list.add(new Student("Robb Stark"));
        list.add(new Student("Alfred Tarski"));
        list.add(new Student("Barash"));
        addStudents(list);

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
                list.get(ind).question(in);
            } else if (com.equals("l")) {
                PrettyTable table = new PrettyTable("Имя", "Оценка");
                for (int ind = 0; ind < n; ++ind) {
                    String mark;
                    if (!list.get(ind).is_here){
                        mark = "н";
                    } else if (list.get(ind).mark == -1) {
                        mark = ".";
                    } else {
                        mark = Integer.toString(list.get(ind).mark);
                    }
                    table.addRow(list.get(ind).name, mark);
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
