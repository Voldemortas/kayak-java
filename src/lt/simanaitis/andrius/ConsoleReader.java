package lt.simanaitis.andrius;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ConsoleReader {
    private final BufferedReader reader;
    private final FrequencyCalculator frequencyCalculator;

    public ConsoleReader(BufferedReader reader, FrequencyCalculator frequencyCalculator){
        this.reader = reader;
        this.frequencyCalculator = frequencyCalculator;
    }

    public Map<Integer, Integer> readConsole() throws Exception {
        try {
            System.out.println("Give me the list, list example: 9, 7, 7, 11, 11");
            String input = reader.readLine();
            List<Integer> integers = convertStringToIntegerList(input);
            return frequencyCalculator.getFrequencyMap(integers);
        }catch (Exception e){
            throw new ReaderException();
        }
    }

    private List<Integer> convertStringToIntegerList(String inputString) {
        if(inputString.isBlank()) return List.of();

        return Arrays.stream(inputString.split(", "))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }
}
