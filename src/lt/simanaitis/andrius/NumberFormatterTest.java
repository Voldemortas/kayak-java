package lt.simanaitis.andrius;

import org.junit.jupiter.api.Test;

import java.util.List;

class NumberFormatterTest {
    private final Formatter<Integer> formatter = new NumberFormatter();

    @Test
    void shouldFormatEmptyListToNothing(){
        List<Integer> input = List.of();

        formatAndAssert(input, "");
    }

    @Test
    void shouldFormatAllNonNegativeIntegersUpTo10(){
        List<Integer> input = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        formatAndAssert(input, "0123456789");
    }

    @Test
    void shouldFormatNineAndTen(){
        List<Integer> input = List.of(9, 10);
        String expectOutput = " 1\r\n90";

        formatAndAssert(input, expectOutput);
    }

    @Test
    void shouldFormatNegative15_0_Positive9(){
        List<Integer> input = List.of(-15, 9, 10);
        String expectOutput = "-  \r\n1 1\r\n590";

        formatAndAssert(input, expectOutput);
    }

    private void formatAndAssert(List<Integer> input, String expectOutput){
        String output = formatter.format(input);

        assert(output).equals(expectOutput);
    }
}