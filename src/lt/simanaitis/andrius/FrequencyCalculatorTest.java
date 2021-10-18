package lt.simanaitis.andrius;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

class FrequencyCalculatorTest {
    @Test
    void shouldReturnEmptyMapForEmptyInput(){
        List<Integer> input = List.of();

        Map<Integer, Integer> outputMap = new FrequencyCalculator(input).getFrequencyMap();

        assert(outputMap).isEmpty();
    }

    @Test
    void shouldCorrectlyMapUnsortedList(){
        List<Integer> input = List.of(4, 3, 4, 5);
        Map<Integer, Integer> expectedMap = Map.ofEntries(entry(3, 1), entry(4, 2), entry(5, 1));

        Map<Integer, Integer> outputMap = new FrequencyCalculator(input).getFrequencyMap();

        assert(outputMap).equals(expectedMap);
    }

    @Test
    void shouldAdd0ForHoles(){
        List<Integer> input = List.of(4, 3, 4, 6);
        Map<Integer, Integer> expectedMap = Map.ofEntries(entry(3, 1),
                entry(4, 2),
                entry(5, 0),
                entry(6, 1));

        Map<Integer, Integer> outputMap = new FrequencyCalculator(input).getFrequencyMap();

        assert(outputMap).equals(expectedMap);
    }
}