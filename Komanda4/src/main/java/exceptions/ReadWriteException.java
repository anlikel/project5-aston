package exceptions;

public class ReadWriteException extends Exception {
    String message;
    public ReadWriteException(String message){
        super(message);
    }
}
