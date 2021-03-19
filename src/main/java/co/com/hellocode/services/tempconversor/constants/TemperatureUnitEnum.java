package co.com.hellocode.services.tempconversor.constants;

public enum TemperatureUnitEnum {

    F("Fahrenheit"),
    K("Kelvin"),
    C("Celsius");

    private String description;

    private TemperatureUnitEnum(String name){
        this.description = name;
    }

    public String getDescription() {
        return description;
    }
}
