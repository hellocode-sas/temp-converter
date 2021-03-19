package co.com.hellocode.services.tempconversor.dto;

import co.com.hellocode.services.tempconversor.constants.TemperatureUnitEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ConverterRequest {

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double value;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TemperatureUnitEnum sourceUnit;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TemperatureUnitEnum targetUnit;

}
