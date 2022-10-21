package task1.exceptions;

public class StorageException extends Exception {

    public StorageException(final String message) {
        super(message);
        System.out.println(message);
    }
}