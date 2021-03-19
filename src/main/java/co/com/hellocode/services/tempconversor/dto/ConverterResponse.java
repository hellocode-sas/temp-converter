package co.com.hellocode.services.tempconversor.dto;

import co.com.hellocode.services.tempconversor.constants.TemperatureUnitEnum;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Builder
@Data
public class ConverterResponse {
   @JsonInclude(JsonInclude.Include.NON_NULL)
    private ConverterRequest request;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Double result;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String displayResult;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LocalDateTime time;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String errorCode;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String error;

    private final String createdBy="hellocode SAS";

    private final String email="https://hellocode.com.co";

}
