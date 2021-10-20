package lt.simanaitis.andrius;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequencyCalculator {
    public FrequencyCalculator(){
    }

    public Map<Integer, Integer> getFrequencyMap(List<Integer> numbers){
        if(numbers.isEmpty())
            return Map.of();

        return getRange(numbers)
                .collect(Collectors.toMap(Function.identity(), value -> this.countOccurrences(value, numbers)));
    }

    private int getMinValue(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(v -> v)
                .min()
                .orElse(0);
    }

    private int getMaxValue(List<Integer> numbers){
        return numbers.stream()
                .mapToInt(v -> v)
                .max()
                .orElse(0);
    }

    private Stream<Integer> getRange(List<Integer> numbers){
        return IntStream
                .range(getMinValue(numbers), getMaxValue(numbers) + 1)
                .boxed();
    }

    private int countOccurrences(Integer valueToSearch, List<Integer> numbers){
        return (int) numbers.stream()
                .filter(number -> Objects.equals(number, valueToSearch))
                .count();
    }
}
