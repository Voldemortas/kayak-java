package lt.simanaitis.andrius;

import org.junit.jupiter.api.Test;

import java.util.List;

class GraphFormatterTest {
    private final Formatter<Integer> formatter = new GraphFormatter();

    @Test
    void shouldReturnEmptyStringForEmptyList(){
        List<Integer> input = List.of();
        
        formatAndAssert(input, "");
    }

    @Test
    void shouldFormat1(){
        List<Integer> input = List.of(1);
        String expectOutput = "*";

        formatAndAssert(input, expectOutput);
    }

    @Test
    void shouldFormat2(){
        List<Integer> input = List.of(2);
        String expectOutput = "*\r\n*";

        formatAndAssert(input, expectOutput);
    }

    @Test
    void shouldFormat21012(){
        List<Integer> input = List.of(2, 1, 0, 1, 2);
        String expectOutput = "*   *\r\n** **";

        formatAndAssert(input, expectOutput);
    }

    private void formatAndAssert(List<Integer> input, String expectOutput){
        String output = formatter.format(input);

        assert(output).equals(expectOutput);
    }
}