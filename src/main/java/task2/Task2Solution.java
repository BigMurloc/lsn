package task2;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Task2Solution {

    static List<Pair> getSortedPairs(int sum, List<Integer> input) {
        Map<Integer, Integer> numberToTotalOccurrenceCount = precomputeNumbersTotalOccurrencesCounts(input);

        return input
                .stream()
                .filter(number -> {
                    int complement = sum - number;
                    return numberToTotalOccurrenceCount.containsKey(complement);
                })
                .map(number -> new Pair(number, sum - number))
                .sorted()
                .distinct()
                .flatMap(pair -> {
                    int smallerOccurrenceCount = numberToTotalOccurrenceCount.get(pair.getSmallerNumber());
                    int greaterNumberOccurrenceCount = numberToTotalOccurrenceCount.get(pair.getGreaterNumber());
                    return Stream.iterate(pair, it -> it).limit((long) smallerOccurrenceCount * greaterNumberOccurrenceCount);
                })
                .collect(Collectors.toUnmodifiableList());
    }

    private static Map<Integer, Integer> precomputeNumbersTotalOccurrencesCounts(List<Integer> input) {
        Map<Integer, Integer> numberToTotalOccurrenceCount = new HashMap<>();
        for (Integer number : input) {
            numberToTotalOccurrenceCount.merge(number, 1, Integer::sum);
        }
        return numberToTotalOccurrenceCount;
    }

}
