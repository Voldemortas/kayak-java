package lt.simanaitis.andrius;

import org.junit.jupiter.api.Test;

import java.util.List;

class NumberFormatterTest {
    @Test
    void shouldFormatAllNonNegativeIntegersUpTo10(){
        List<Integer> input = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);

        formatAndAssert(input, "0123456789");
    }

    @Test
    void shouldFormatNineAndTen(){
        List<Integer> input = List.of(9, 10);
        String expectOutput = "91\r\n 0";

        formatAndAssert(input, expectOutput);
    }

    @Test
    void shouldFormatNegative5_0_Positive9(){
        List<Integer> input = List.of(-5, 0, 9);
        String expectOutput = "-09\r\n5  ";

        formatAndAssert(input, expectOutput);
    }

    private void formatAndAssert(List<Integer> input, String expectOutput){
        String output = new NumberFormatter(input).format();

        assert(output).equals(expectOutput);
    }
}