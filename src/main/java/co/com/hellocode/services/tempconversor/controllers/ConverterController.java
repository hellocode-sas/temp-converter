package co.com.hellocode.services.tempconversor.controllers;

import co.com.hellocode.services.tempconversor.adapters.RemoteAdapter;
import co.com.hellocode.services.tempconversor.dto.ConverterRequest;
import co.com.hellocode.services.tempconversor.dto.ConverterResponse;
import co.com.hellocode.services.tempconversor.errors.ConverterException;
import co.com.hellocode.services.tempconversor.services.ConverterService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@RestController
@Api(value = "Conversor Temperatura")
public class ConverterController {

    private final ConverterService converterService;
    DecimalFormat decimalFormat=new DecimalFormat("##.##");


    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @ApiOperation(value = "convert", notes = "<p>Realiza conversiones entre diferentes sistemas de medida" +
            " de temperatura como: Kelvin, Fahrenheit y Celsius. "+
            "<br/>El conjunto de parámetros del query string. <br/><b>from</b>: unidad inicial de la" +
            " temperatura base para realizar la consulta, <br/> <b>to</b>: unidad a la que se desea realizar " +
            "la conversión. <br/><b>value</b>: valor en formato doble que se desea convertir. <br/> ejemplo:" +
            " <b>?from=C&to=F&value=32 </b> <br/> intenta convertir 32 Celsius to Fahrenheit. <br/>" +
            " Valores permitidos: K, F o C. </p> ")
    @GetMapping(path = "/convert")
    public ResponseEntity<ConverterResponse> convert(
            @ApiParam(value = "Unidad base de la conversión (C|F|K)")
            @RequestParam String from,
            @ApiParam(value = "Unidad destino de la conversión (C|F|K)")
            @RequestParam String to,
            @ApiParam(value = "Valor a convertir")
            @RequestParam String value
            ){

        try {
            ConverterRequest request=RemoteAdapter.toRequest(from,to,value);
            Double result = converterService.convert(request);
            return ResponseEntity.ok(
                    ConverterResponse.builder().request(request)
                            .result(result)
                            .displayResult(decimalFormat.format(result))
                            .time(LocalDateTime.now())
                            .build());
        }catch (ConverterException exc){
            return ResponseEntity.badRequest().body(
                    ConverterResponse.builder()
                            .errorCode(exc.getError().name()).error(exc.getMessage())
                            .build());
        }catch (Exception exc){
            log.error(exc.getMessage(), exc);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    ConverterResponse.builder()
                            .errorCode("ERROR")
                            .error(exc.getMessage())
                            .build());
        }
    }

}
