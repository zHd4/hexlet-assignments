package exercise;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

class AppTest {

    @Test
    void testTake() {
        // BEGIN
        List<Integer> data1 = new ArrayList<>(Arrays.asList(1, 2, 3, 4));

        List<Integer> actual1 = App.take(data1, 2);
        List<Integer> expected1 = new ArrayList<>(Arrays.asList(1, 2));

        assertThat(actual1).isEqualTo(expected1);

        List<Integer> data2 = new ArrayList<>(Arrays.asList(7, 3, 10));
        List<Integer> actual2 = App.take(data2, 8);

        assertThat(actual2).isEqualTo(data2);

        List<Integer> data3 = new ArrayList<>();
        List<Integer> actual3 = App.take(data3, 6);

        assertThat(actual3).isEqualTo(data3);
        // END
    }
}
