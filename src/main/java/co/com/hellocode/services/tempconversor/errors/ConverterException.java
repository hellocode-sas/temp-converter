package co.com.hellocode.services.tempconversor.errors;

public class ConverterException extends RuntimeException {

    private final ErrorEnum error;

    public ConverterException(String message, Throwable cause, ErrorEnum error) {
        super(message, cause);
        this.error = error;
    }

    public ConverterException( ErrorEnum error) {
        super(error.getMessage());
        this.error = error;
    }

    public ErrorEnum getError() {
        return error;
    }
}
