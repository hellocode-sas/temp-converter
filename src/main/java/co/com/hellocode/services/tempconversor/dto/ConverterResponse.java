package co.com.hellocode.services.tempconversor.dto;

import co.com.hellocode.services.tempconversor.constants.TemperatureUnitEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@ApiModel("Objeto que contiene la respuesta del servicio.")
@Builder
@Data
public class ConverterResponse {

   @ApiModelProperty(value = "Objeto que contiene los datos enviados para realizar la operación.")
   @JsonInclude(JsonInclude.Include.NON_NULL)
    private ConverterRequest request;

   @ApiModelProperty(value = "Resultado numérico  de la conversión.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double result;

    @ApiModelProperty(value = "Resultado formateado  de la conversión.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String displayResult;

    @ApiModelProperty(value = "Fecha y hora  de la conversión.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime time;

    @ApiModelProperty(value = "Código de error en caso de ocurrit algún problema.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;

    @ApiModelProperty(value = "Mensaje de error.")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    private final String createdBy="hellocode SAS";

    private final String email="https://hellocode.com.co";

}
