package exception_file;

public class BadFileException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public BadFileException(String single) {
        super(single);
    }

    public BadFileException() {
        this ("Bad File: error accessing file");
    }
}
