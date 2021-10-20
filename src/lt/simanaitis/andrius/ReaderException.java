package lt.simanaitis.andrius;

public class ReaderException extends Exception {
    public ReaderException(){
        super("Failed to parse input");
    }
}
