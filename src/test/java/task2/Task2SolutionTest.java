package task2;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Task2SolutionTest {

    @Test
    public void givenTargetSumAndListOfIntegersShouldGenerateListOfPairsMatchingUpToSum() {
        var input = List.of(1, 2, 10, 7, 5, 3, 6, 6, 13, 0);

        var sortedPairs = Task2Solution.getSortedPairs(13, input);

        assertThat(sortedPairs).containsExactly(
                new Pair(0, 13),
                new Pair(3, 10),
                new Pair(6, 7),
                new Pair(6, 7)
        );
    }


    @Test
    public void givenTargetSumAndListOfIntegersWithRepeatingNumbersShouldGenerateListOfPairsWithRepeatingPairs() {
        var input = List.of(1, 1, 3, 3, 3);

        var sortedPairs = Task2Solution.getSortedPairs(4, input);

        assertThat(sortedPairs).containsExactly(
                new Pair(1, 3),
                new Pair(1, 3),
                new Pair(1, 3),
                new Pair(1, 3),
                new Pair(1, 3),
                new Pair(1, 3)
        );
    }
}
