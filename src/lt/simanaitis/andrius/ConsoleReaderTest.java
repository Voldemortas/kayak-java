package lt.simanaitis.andrius;

import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class ConsoleReaderTest {
    private ConsoleReader consoleReader;

    private final Map<Integer, Integer> RESPONSE_MAP = Map.of(2021, 12, 500, 400, 5, 0);

    @Test
    void shouldMapEmptyStringToEmptyList() throws Exception {
        setup("", List.of());

        readConsoleAndAssert();
    }

    @Test
    void shouldMapSingleNumberToSingleNumber() throws Exception {
        setup("10", List.of(10));

        readConsoleAndAssert();
    }

    @Test
    void shouldMapSeveralNumbers() throws Exception {
        setup("1, 50, -3", List.of(1, 50, -3));

        readConsoleAndAssert();
    }

    @Test
    void shouldThrowOnMalformedInput() throws Exception {
        BufferedReader bufferedReader = mockReader("text");
        FrequencyCalculator frequencyCalculator = mock(FrequencyCalculator.class);

        this.consoleReader = new ConsoleReader(bufferedReader, frequencyCalculator);

        assertThrows(ReaderException.class, () -> consoleReader.readConsole());
    }

    private void setup(String inputString, List<Integer> expectIntegers) throws IOException {
        BufferedReader bufferedReader = mockReader(inputString);
        FrequencyCalculator frequencyCalculator = mockCalculator(expectIntegers);

        this.consoleReader = new ConsoleReader(bufferedReader, frequencyCalculator);
    }

    private BufferedReader mockReader(String inputString) throws IOException {
        BufferedReader bufferedReader = mock(BufferedReader.class);
        when(bufferedReader.readLine()).thenReturn(inputString);

        return bufferedReader;
    }

    private FrequencyCalculator mockCalculator(List<Integer> expectIntegers) {
        FrequencyCalculator frequencyCalculator = mock(FrequencyCalculator.class);
        when(frequencyCalculator.getFrequencyMap(expectIntegers)).thenReturn(RESPONSE_MAP);

        return frequencyCalculator;
    }

    private void readConsoleAndAssert() throws Exception {
        assert(consoleReader.readConsole()).equals(RESPONSE_MAP);
    }
}