package lt.simanaitis.andrius;

import org.junit.jupiter.api.Test;

import java.util.List;

class FormatterTest {
    private final Formatter<String> formatter = new LevelItemFormatter();

    @Test
    void shouldFormatEmptyListToNothing(){
        List<String> input = List.of();

        formatAndAssert(input, "");
    }

    @Test
    void shouldFormatLevelWithValue(){
        List<String> input = List.of("a", "b", "c");
        String expectedOutput = "2a2b2c\r\n1a1b1c";

        formatAndAssert(input, expectedOutput);
    }

    private void formatAndAssert(List<String> input, String expectOutput){
        String output = formatter.format(input);

        assert(output).equals(expectOutput);
    }

    private static class LevelItemFormatter extends Formatter<String>{
        public LevelItemFormatter(){
            super();
        }

        @Override
        protected int getLongestValue(List<String> items) {
            return 2;
        }

        @Override
        protected String formatCell(int level, String item) {
            return String.format("%d%s", level, item);
        }
    }
}