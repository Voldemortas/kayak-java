package lt.simanaitis.andrius;

import org.junit.jupiter.api.Test;

import java.util.List;

class FormatterTest {
    @Test
    void shouldFormatLevelWithValue(){
        List<String> input = List.of("a", "b", "c");
        String expectedOutput = "2a2b2c\r\n1a1b1c";

        String output = new LevelItemFormatter(input).format();

        assert(output).equals(expectedOutput);
    }


    private static class LevelItemFormatter extends Formatter<String>{
        public LevelItemFormatter(List<String> items){
            super(items);
        }

        @Override
        protected int getLongestValue() {
            return 2;
        }

        @Override
        protected String formatCell(int level, String item) {
            return String.format("%d%s", level, item);
        }
    }
}