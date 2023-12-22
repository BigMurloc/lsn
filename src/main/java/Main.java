import task1.Task1Solution;
import task2.Pair;
import task2.Task2Solution;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        String flag = args[0];

        validateFlag(flag);

        Scanner scanner = new Scanner(System.in);

        var arrayInput = readUserInput(scanner);

        switch (flag) {
            case "task1":
                handleTask1(arrayInput);
                break;
            case "task2":
                System.out.println("Enter target sum: ");
                var targetSumInput = scanner.nextInt();
                handleTask2(targetSumInput, arrayInput);
                break;
            case "task3":
                handleTask3(arrayInput);
                break;
        }
    }

    private static List<Integer> readUserInput(Scanner scanner) {

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
        var solution = new Task1Solution(input);

        for (Integer number : solution.sortedDistinctElements()) {
            System.out.print(number + " ");
        }
        System.out.println();
        System.out.println("count: " + solution.getInitialCount());
        System.out.println("distinct: " + solution.getDistinctCount());
        System.out.println("min: " + solution.getMin());
        System.out.println("max: " + solution.getMax());
    }

    private static void handleTask2(int targetSum, List<Integer> integers) {
        Task2Solution
                .getSortedPairs(targetSum, integers)
                .forEach(System.out::println);
    }

    private static void handleTask3(List<Integer> input) {
        System.out.println("task3");
    }

}
