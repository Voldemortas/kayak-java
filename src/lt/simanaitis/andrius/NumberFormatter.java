package lt.simanaitis.andrius;

import java.util.List;

public class NumberFormatter extends Formatter<Integer> {
    public NumberFormatter(){
        super();
    }

    private static int compareString(String a, String b){
        return a.length() - b.length();
    }

    @Override
    protected int getLongestValue(List<Integer> items) {
        return items.stream()
                .map(String::valueOf)
                .max(NumberFormatter::compareString)
                .orElse("").length();
    }

    @Override
    protected String formatCell(int level, Integer item) {
        String stringItem = String.valueOf(item);
        int index = stringItem.length() - level;

        if(index < 0) return " ";
        return String.valueOf(stringItem.charAt(index));
    }
}
