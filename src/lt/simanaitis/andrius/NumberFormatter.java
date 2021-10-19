package lt.simanaitis.andrius;

import java.util.List;
import java.util.stream.Collectors;

public class NumberFormatter extends Formatter<String> {
    public NumberFormatter(List<Integer> numbers){
        super(numbers.stream().map(String::valueOf).collect(Collectors.toList()));
    }

    private static int compareString(String a, String b){
        return a.length() - b.length();
    }

    @Override
    protected int getLongestValue() {
        return items.stream()
                .max(NumberFormatter::compareString)
                .orElse("").length();
    }

    @Override
    protected String formatCell(int level, String item) {
        int longestValue = getLongestValue();
        int currentIndex = longestValue - level;

        if(currentIndex >= item.length()) return " ";
        return String.valueOf(item.charAt(currentIndex));
    }
}
