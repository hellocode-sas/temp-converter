package co.com.hellocode.services.tempconversor.dto;

import co.com.hellocode.services.tempconversor.constants.TemperatureUnitEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@ApiModel(value = "Contiene los datos necesarios para la conversión.")
public class ConverterRequest {

    @ApiModelProperty(value = "Valor a convertir.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double value;

    @ApiModelProperty(value = "Unidad de termperatura base del vaor a convertir.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TemperatureUnitEnum sourceUnit;

    @ApiModelProperty(value = "Unidad de medida de destino.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private TemperatureUnitEnum targetUnit;

}
