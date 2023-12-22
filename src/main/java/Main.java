import task1.Task1Solution;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String flag = args[0];

        validateFlag(flag);

        var userInput = readUserInput();

        switch (flag) {
            case "task1":
                handleTask1(userInput);
                break;
            case "task2":
                handleTask2(userInput);
                break;
            case "task3":
                handleTask3(userInput);
                break;
        }
    }

    private static List<Integer> readUserInput() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter input in a string-like array delimited by space");
        System.out.println("Example: 1 2 3 4 5 6");
        var line = scanner.nextLine();

        return Arrays.stream(line.trim().split(" ")).map(Integer::valueOf).collect(Collectors.toList());
    }

    private static void validateFlag(String flag) {
        if (!List.of("task1", "task2", "task3").contains(flag)) {
            throw new IllegalArgumentException("Unknown flag " + flag + ". Expected value is one of (task1, task2, task3)");
        }
    }


    private static void handleTask1(List<Integer> input) {
        System.out.println("task1");
    }

    private static void handleTask2(List<Integer> input) {
        System.out.println("task2");
    }

    private static void handleTask3(List<Integer> input) {
        System.out.println("task3");
    }

}
