package lt.simanaitis.andrius;

import java.util.Comparator;
import java.util.List;

public class GraphFormatter extends Formatter<Integer> {
    public GraphFormatter(){
        super();
    }

    @Override
    protected int getLongestValue(List<Integer> items) {
        return items.stream()
                .max(Comparator.comparingInt(a -> a))
                .orElseThrow();
    }

    @Override
    protected String formatCell(int level, Integer asteriskLevel) {
        if(level <= asteriskLevel) return "*";
        return " ";
    }
}
