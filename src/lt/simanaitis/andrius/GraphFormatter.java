package lt.simanaitis.andrius;

import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

public class GraphFormatter extends Formatter<Integer> {
    public GraphFormatter(Map<Integer, Integer> frequencyMap){
        super(frequencyMap
                .keySet()
                .stream()
                .sorted()
                .map(frequencyMap::get)
                .collect(Collectors.toList()));
    }

    @Override
    protected int getLongestValue() {
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
