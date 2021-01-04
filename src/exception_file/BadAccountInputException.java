package exception_file;

public class BadAccountInputException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    public BadAccountInputException(String single) {
        super(single);
    }

    public BadAccountInputException() {
        this ("Bad input");
    }

}