package lt.simanaitis.andrius;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public abstract class Formatter<T> {
    protected final List<T> items;

    public Formatter(List<T> items){
        this.items = items;
    }

    public String format(){
        if(items.isEmpty())
            return "";

        return getRange()
                .map(this::formatRow)
                .collect(Collectors.joining("\r\n"));
    }

    abstract protected int getLongestValue();

    protected abstract String formatCell(int level, T item);

    private Stream<Integer> getRange(){
        int maxKey = getLongestValue();

        return IntStream
                .range(0, maxKey)
                .map(i -> maxKey - i)
                .boxed();
    }

    private String formatRow(int row){
        return items.stream()
                .map(item -> formatCell(row, item))
                .collect(Collectors.joining(""));
    }
}
