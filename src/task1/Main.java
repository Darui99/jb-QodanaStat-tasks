package task1;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            int n = in.nextInt();
            in.nextLine();
            String[] names = new String[n];
            for (int i = 0; i < n; i++) {
                names[i] = in.nextLine();
            }
            String res = new Solver().solve(names);
            System.out.println(Objects.requireNonNullElse(res, "Impossible"));
        }
    }
}
