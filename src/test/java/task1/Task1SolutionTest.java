package task1;


import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Task1SolutionTest {

    @Test
    public void shouldPerformSortAndDistinctOnAGivenList() {
        var input = List.of(1, 10, 20, 20, 2, 5);
        var task1Solution = new Task1Solution(input);

        assertThat(task1Solution.sortedDistinctElements()).containsExactly(1, 2, 5, 10, 20);
        assertThat(task1Solution.getDistinctCount()).isEqualTo(5);
        assertThat(task1Solution.getInitialCount()).isEqualTo(6);
        assertThat(task1Solution.getMax()).isEqualTo(20);
        assertThat(task1Solution.getMin()).isEqualTo(1);
    }

    @Test
    public void shouldPerformSortAndDistinctOnAGivenListContainingZero() {
        var input = List.of(1, 10, 20, 20, 2, 5, 0);
        var task1Solution = new Task1Solution(input);

        assertThat(task1Solution.sortedDistinctElements()).containsExactly(0, 1, 2, 5, 10, 20);
        assertThat(task1Solution.getDistinctCount()).isEqualTo(6);
        assertThat(task1Solution.getInitialCount()).isEqualTo(7);
        assertThat(task1Solution.getMax()).isEqualTo(20);
        assertThat(task1Solution.getMin()).isEqualTo(0);
    }

    @Test
    public void shouldPerformSortAndDistinctOnAGivenListContainingNegativeInteger() {
        var input = List.of(1, 10, 20, 20, 2, 5, -1);
        var task1Solution = new Task1Solution(input);

        assertThat(task1Solution.sortedDistinctElements()).containsExactly(-1, 1, 2, 5, 10, 20);
        assertThat(task1Solution.getDistinctCount()).isEqualTo(6);
        assertThat(task1Solution.getInitialCount()).isEqualTo(7);
        assertThat(task1Solution.getMax()).isEqualTo(20);
        assertThat(task1Solution.getMin()).isEqualTo(-1);
    }

}
