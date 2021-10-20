package lt.simanaitis.andrius;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Map;

public class Task1 {
    public static void main(String[] args) {
        GraphFormatter graphFormatter = new GraphFormatter();
        NumberFormatter numberFormatter = new NumberFormatter();
        FrequencyPrinter frequencyPrinter = new FrequencyPrinter(graphFormatter, numberFormatter);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FrequencyCalculator frequencyCalculator = new FrequencyCalculator();
        ConsoleReader consoleReader = new ConsoleReader(reader, frequencyCalculator);

        try {
            Map<Integer, Integer> frequencyMap = consoleReader.readConsole();
            frequencyPrinter.print(frequencyMap);
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
    }
}
