package lt.simanaitis.andrius;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FrequencyCalculator {
    private final List<Integer> numbers;

    public FrequencyCalculator(List<Integer> numbers){
        this.numbers = numbers;
    }

    public Map<Integer, Integer> getFrequencyMap(){
        if(numbers.isEmpty())
            return Map.of();

        return getRange().collect(Collectors.toMap(Function.identity(), this::countOccurrences));
    }

    private int getMinValue(){
        return numbers.stream()
                .mapToInt(v -> v)
                .min()
                .orElse(0);
    }

    private int getMaxValue(){
        return numbers.stream()
                .mapToInt(v -> v)
                .max()
                .orElse(0);
    }

    private Stream<Integer> getRange(){
        return IntStream
                .range(getMinValue(), getMaxValue() + 1)
                .boxed();
    }

    private int countOccurrences(Integer valueToSearch){
        return (int) numbers.stream()
                .filter(number -> Objects.equals(number, valueToSearch))
                .count();
    }
}
