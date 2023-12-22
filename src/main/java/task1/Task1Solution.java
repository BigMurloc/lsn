package task1;

import java.util.List;
import java.util.stream.Collectors;

public class Task1Solution {

    private final int max;
    private final int min;
    private final int initialCount;
    private final List<Integer> sortedDistinctElements;
    public Task1Solution(List<Integer> input) {
        initialCount = input.size();

        sortedDistinctElements = input
                .stream()
                .sorted()
                .distinct()
                .collect(Collectors.toUnmodifiableList());

        min = sortedDistinctElements.get(0);
        max = sortedDistinctElements.get(sortedDistinctElements.size() - 1);
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }

    public int getDistinctCount() {
        return sortedDistinctElements.size();
    }

    public int getInitialCount() {
        return initialCount;
    }

    public List<Integer> sortedDistinctElements() {
        return sortedDistinctElements;
    }
}
