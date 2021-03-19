package co.com.hellocode.services.tempconversor.adapters;

import co.com.hellocode.services.tempconversor.constants.TemperatureUnitEnum;
import co.com.hellocode.services.tempconversor.dto.ConverterRequest;
import co.com.hellocode.services.tempconversor.errors.ConverterException;
import co.com.hellocode.services.tempconversor.errors.ErrorEnum;

import java.util.Map;
import java.util.Optional;

public class RemoteAdapter {

    /**
     * Convert query params into request object
     * Convert query params into request object
     * @param queryParams
     * @return
     */
    public static ConverterRequest toRequest(Map<String, String> queryParams) {

        try {
            return transform(queryParams);
        }catch (IllegalArgumentException  exc){
            throw  new ConverterException(ErrorEnum.INVALID_REQUEST);
        }

    }

    /**
     * Transforms objects
     * @param queryParams
     * @return
     */
    private static ConverterRequest transform(Map<String, String> queryParams) {
        String strValue = Optional.ofNullable(queryParams.get("value")).orElseThrow(() ->
                new ConverterException(ErrorEnum.VALUE_NOT_FOUND));

        Double value = Double.parseDouble(strValue);


        TemperatureUnitEnum from = TemperatureUnitEnum.valueOf(Optional.ofNullable(queryParams.get("from"))
                .orElseThrow(() ->
                        new ConverterException(ErrorEnum.FROM_UNIT_NOT_FOUND))
                .toUpperCase());

        TemperatureUnitEnum target = TemperatureUnitEnum.valueOf(Optional.ofNullable(queryParams.get("to"))
                .orElseThrow(() ->
                        new ConverterException(ErrorEnum.TARGET_UNIT_NOT_FOUND))
                .toUpperCase());

        return ConverterRequest.builder()
                .sourceUnit(from)
                .targetUnit(target)
                .value(value)
                .build();
    }

    public static ConverterRequest toRequest(String _from, String _to, String _value) {


        String  strvalue = Optional.ofNullable(_value).orElseThrow(() ->
                new ConverterException(ErrorEnum.VALUE_NOT_FOUND));

        Double value = Double.parseDouble(strvalue);

        TemperatureUnitEnum from = TemperatureUnitEnum.valueOf(Optional.ofNullable(_from)
                .orElseThrow(() ->
                        new ConverterException(ErrorEnum.FROM_UNIT_NOT_FOUND))
                .toUpperCase());

        TemperatureUnitEnum target = TemperatureUnitEnum.valueOf(Optional.ofNullable(_to)
                .orElseThrow(() ->
                        new ConverterException(ErrorEnum.TARGET_UNIT_NOT_FOUND))
                .toUpperCase());

        return ConverterRequest.builder()
                .sourceUnit(from)
                .targetUnit(target)
                .value(value)
                .build();
    }
}
