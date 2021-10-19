package lt.simanaitis.andrius;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class Formatter<T> {
    public Formatter(){}

    public String format(List<T> items){
        if(items.isEmpty())
            return "";

        return getRange(items)
                .map(row -> this.formatRow(row, items))
                .collect(Collectors.joining("\r\n"));
    }

    abstract protected int getLongestValue(List<T> items);

    protected abstract String formatCell(int level, T item);

    private Stream<Integer> getRange(List<T> items){
        int maxKey = getLongestValue(items);

        return IntStream
                .range(0, maxKey)
                .map(i -> maxKey - i)
                .boxed();
    }

    private String formatRow(int row, List<T> items){
        return items.stream()
                .map(item -> formatCell(row, item))
                .collect(Collectors.joining(""));
    }
}
