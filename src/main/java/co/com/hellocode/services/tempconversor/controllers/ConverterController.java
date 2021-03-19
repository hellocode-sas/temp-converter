package co.com.hellocode.services.tempconversor.controllers;

import co.com.hellocode.services.tempconversor.adapters.RemoteAdapter;
import co.com.hellocode.services.tempconversor.dto.ConverterRequest;
import co.com.hellocode.services.tempconversor.dto.ConverterResponse;
import co.com.hellocode.services.tempconversor.errors.ConverterException;
import co.com.hellocode.services.tempconversor.services.ConverterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.Map;

@Slf4j
@RestController
public class ConverterController {

    private final ConverterService converterService;
    DecimalFormat decimalFormat=new DecimalFormat("##.##");

    public ConverterController(ConverterService converterService) {
        this.converterService = converterService;
    }

    @GetMapping(path = "/convert")
    public ResponseEntity<ConverterResponse> convert(@RequestParam Map <String, String> queryParams){

        try {
            ConverterRequest request=RemoteAdapter.toRequest(queryParams);
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
