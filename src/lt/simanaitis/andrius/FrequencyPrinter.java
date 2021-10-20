package lt.simanaitis.andrius;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FrequencyPrinter {
    private final Formatter<Integer> graphFormatter;
    private final Formatter<Integer> numberFormatter;

    public FrequencyPrinter(Formatter<Integer> graphFormatter, Formatter<Integer> numberFormatter){
        this.graphFormatter = graphFormatter;
        this.numberFormatter = numberFormatter;
    }

    public void print(Map<Integer, Integer> frequencyMap){
        List<Integer> numerals = frequencyMap.keySet()
                .stream()
                .sorted()
                .collect(Collectors.toList());

        List<Integer> numeralFrequencies = numerals
                .stream()
                .map(frequencyMap::get)
                .collect(Collectors.toList());

        System.out.println(graphFormatter.format(numeralFrequencies));
        System.out.println(numberFormatter.format(numerals));
    }
}
