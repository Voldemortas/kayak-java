package lt.simanaitis.andrius;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GraphFormatter {
    private final Map<Integer, Integer> frequencyMap;

    public GraphFormatter(Map<Integer, Integer> frequencyMap){
        this.frequencyMap = frequencyMap;
    }

    public String formatGraph(){
        if(frequencyMap.isEmpty())
            return "";

        String frequencyGraph = getRange()
                .map(this::formatRow)
                .collect(Collectors.joining("\r\n"));
        String bottomLine = formatBottomLine();

        return frequencyGraph + bottomLine;
    }

    private Stream<Integer> getKeys(){
        return frequencyMap.keySet().stream().sorted();
    }

    private Stream<Integer> getValues(){
        return getKeys().map(frequencyMap::get);
    }

    private int getMaxKeyValue(){
        return getKeys()
                .mapToInt(frequencyMap::get)
                .max()
                .orElseThrow();
    }

    private Stream<Integer> getRange(){
        int maxKey = getMaxKeyValue();

        return IntStream
                .range(0, maxKey)
                .map(i -> maxKey - i)
                .boxed();
    }

    private String formatRow(int row){
        return getValues()
                .map(current -> drawAsteriskOrHole(row, current))
                .collect(Collectors.joining(""));
    }

    private String formatBottomLine(){
        return "\r\n" +
                getKeys()
                .map(String::valueOf)
                .collect(Collectors.joining(""));
    }

    private String drawAsteriskOrHole(int level, int asteriskLevel){
        if(level <= asteriskLevel) return "*";
        return " ";
    }
}
