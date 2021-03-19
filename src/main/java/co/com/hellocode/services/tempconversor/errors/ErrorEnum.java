package co.com.hellocode.services.tempconversor.errors;

public enum ErrorEnum {
    UNKNOWN("Error desconocido."),
    VALUE_NOT_FOUND("No ha sido encontrado el valor."),
    FROM_UNIT_NOT_FOUND("No se ha especificado una unidad base."),
    TARGET_UNIT_NOT_FOUND("No se ha especificado la unidad de destino."),
    INVALID_REQUEST("Los datos de la petición no son válidos."),
    NOT_SUPPORTED("Operation not supported.");
    private final String message;

    private ErrorEnum(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
