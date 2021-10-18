package lt.simanaitis.andrius;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Nested;

import java.util.Map;

import static java.util.Map.entry;

class GraphFormatterTest {
    @Test
    void shouldReturnEmptyStringForEmptyMap(){
        Map<Integer, Integer> input = Map.of();

        String output = new GraphFormatter(input).formatGraph();

        assert(output).equals("");
    }

    @Nested
    class SingleKey{
        @Test
        void shouldFormat1(){
            Map<Integer, Integer> input = Map.ofEntries(entry(5, 1));
            String expectOutput = "*\r\n5";

            formatAndAssert(input, expectOutput);
        }

        @Test
        void shouldFormat2(){
            Map<Integer, Integer> input = Map.ofEntries(entry(9, 2));
            String expectOutput = "*\r\n*\r\n9";

            formatAndAssert(input, expectOutput);
        }
    }

    @Nested
    class TwoKeys{
        @Test
        void shouldFormat12(){
            Map<Integer, Integer> input = Map.ofEntries(entry(4, 1), entry(5, 2));
            String expectOutput = " *\r\n**\r\n45";

            formatAndAssert(input, expectOutput);
        }

        @Test
        void shouldFormat21(){
            Map<Integer, Integer> input = Map.ofEntries(entry(4, 2), entry(5, 1));
            String expectOutput = "* \r\n**\r\n45";

            formatAndAssert(input, expectOutput);
        }

        @Test
        void shouldFormat11(){
            Map<Integer, Integer> input = Map.ofEntries(entry(4, 1), entry(5, 1));
            String expectOutput = "**\r\n45";

            formatAndAssert(input, expectOutput);
        }

        @Test
        void shouldFormat33(){
            Map<Integer, Integer> input = Map.ofEntries(entry(4, 3), entry(5, 3));
            String expectOutput = "**\r\n**\r\n**\r\n45";

            formatAndAssert(input, expectOutput);
        }
    }

    @Nested
    class WithHole{
        @Test
        void shouldFormat101(){
            Map<Integer, Integer> input = Map.ofEntries(entry(4, 1), entry(5, 0), entry(6, 1));
            String expectOutput = "* *\r\n456";

            formatAndAssert(input, expectOutput);
        }

        @Test
        void shouldFormat202(){
            Map<Integer, Integer> input = Map.ofEntries(entry(4, 2), entry(5, 0), entry(6, 2));
            String expectOutput = "* *\r\n* *\r\n456";

            formatAndAssert(input, expectOutput);
        }

        @Test
        void shouldFormat10001(){
            Map<Integer, Integer> input = Map.ofEntries(entry(4, 1),
                    entry(5, 0),
                    entry(6, 0),
                    entry(7, 0),
                    entry(8, 1));
            String expectOutput = "*   *\r\n45678";

            formatAndAssert(input, expectOutput);
        }
    }

    private void formatAndAssert(Map<Integer, Integer> input, String expectOutput){
        String output = new GraphFormatter(input).formatGraph();

        assert(output).equals(expectOutput);
    }
}