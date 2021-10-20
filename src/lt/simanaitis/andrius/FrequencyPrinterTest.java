package lt.simanaitis.andrius;

import org.junit.jupiter.api.Test;

import java.io.PrintStream;
import java.util.List;
import java.util.Map;

import static java.util.Map.entry;
import static org.mockito.Mockito.*;

class FrequencyPrinterTest {
    private final String FORMATTED_GRAPH = "one";
    private final String FORMATTED_NUMERALS = "two";

    @Test
    void shouldPrintWithBothFormatters(){
        Map<Integer, Integer> map = Map.ofEntries(entry(5, 2), entry(6, 0), entry(7, 1));
        List<Integer> numerals = List.of(5, 6, 7);
        List<Integer> numeralFrequencies = List.of(2, 0, 1);

        Formatter<Integer> graphFormatter = mockFormatter(numeralFrequencies, FORMATTED_GRAPH);
        Formatter<Integer> numeralFormatter = mockFormatter(numerals, FORMATTED_NUMERALS);
        PrintStream printStream = mockPrintStream();

        new FrequencyPrinter(graphFormatter, numeralFormatter).print(map);

        verifyCalls(printStream);
    }

    @SuppressWarnings("unchecked")
    private Formatter<Integer> mockFormatter(List<Integer> integers, String output){
        Formatter<Integer> formatter = mock(Formatter.class);
        when(formatter.format(integers)).thenReturn(output);

        return formatter;
    }

    private PrintStream mockPrintStream(){
        PrintStream printStream = mock(PrintStream.class);
        System.setOut(printStream);

        return printStream;
    }

    private void verifyCalls(PrintStream printStream){
        verify(printStream).println(FORMATTED_GRAPH);
        verify(printStream).println(FORMATTED_NUMERALS);
    }
}