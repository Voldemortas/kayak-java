package lt.simanaitis.andrius;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static java.util.Map.entry;

class FrequencyCalculatorTest {
    private final FrequencyCalculator frequencyCalculator = new FrequencyCalculator();

    @Test
    void shouldReturnEmptyMapForEmptyInput(){
        List<Integer> input = List.of();

        Map<Integer, Integer> outputMap = frequencyCalculator.getFrequencyMap(input);

        assert(outputMap).isEmpty();
    }

    @Test
    void shouldCorrectlyMapUnsortedList(){
        List<Integer> input = List.of(4, 3, 4, 5);
        Map<Integer, Integer> expectedOutput = Map.ofEntries(entry(3, 1), entry(4, 2), entry(5, 1));

        getFrequencyMapAndAssert(input, expectedOutput);
    }

    @Test
    void shouldAdd0ForHoles(){
        List<Integer> input = List.of(4, 3, 4, 6);
        Map<Integer, Integer> expectedOutput = Map.ofEntries(entry(3, 1),
                entry(4, 2),
                entry(5, 0),
                entry(6, 1));

        getFrequencyMapAndAssert(input, expectedOutput);
    }

    private void getFrequencyMapAndAssert(List<Integer> input, Map<Integer, Integer> expectedOutput){
        Map<Integer, Integer> outputMap = frequencyCalculator.getFrequencyMap(input);

        assert(outputMap).equals(expectedOutput);
    }
}