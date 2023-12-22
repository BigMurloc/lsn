package task3;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class Task3SolutionTest {

    @Test
    public void whenAllVerticesAreConnectedThenNumberOfComponentsShouldBeOne() {
        /*
            graph:
            [1] - [2] - [3] - [4] - [5]
         */
        var input = List.of(1,
                1, 2,
                2, 3,
                3, 4,
                4, 5
        );

        var numberOfComponents = Task3Solution.getNumberOfComponents(input);

        assertThat(numberOfComponents).isEqualTo(1);
    }

    @Test
    public void whenThereAreTwoComponentsThenNumberOfComponentsShouldBeTwo() {
        /*
            graph:
            [1]-[2]-[3]

            [4]-[5]
         */
        var input = List.of(
                3,
                1, 2,
                2, 3,
                4, 5
        );

        var numberOfComponents = Task3Solution.getNumberOfComponents(input);

        assertThat(numberOfComponents).isEqualTo(2);
    }

    @Test
    public void whenThereIsOnlyOneVertexTheNumberOfComponentsShouldBeOne() {
        /*
            graph:
            [1]
         */
        var input = List.of(
                1
        );

        var numberOfComponents = Task3Solution.getNumberOfComponents(input);

        assertThat(numberOfComponents).isEqualTo(1);
    }

}
