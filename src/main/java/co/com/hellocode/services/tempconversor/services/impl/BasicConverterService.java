package co.com.hellocode.services.tempconversor.services.impl;

import co.com.hellocode.services.tempconversor.dto.ConverterRequest;
import co.com.hellocode.services.tempconversor.dto.ConverterResponse;
import co.com.hellocode.services.tempconversor.errors.ConverterException;
import co.com.hellocode.services.tempconversor.errors.ErrorEnum;
import co.com.hellocode.services.tempconversor.services.ConverterService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;

@Service
public class BasicConverterService implements ConverterService {

    private final Map<String, Function<Double,Double>> functionStore
            = new HashMap();

    public BasicConverterService() {

        functionStore.put("C-C", e-> e);
        functionStore.put("C-F", e-> e*1.8+32);
        functionStore.put("C-K", e-> e+273.15);
        functionStore.put("K-K", e-> e);
        functionStore.put("K-F", e-> e*1.8 -459.67);
        functionStore.put("K-C", e-> e-273.15);
        functionStore.put("F-F",e->e);
        functionStore.put("F-C",e->(e-32)/1.8);
        functionStore.put("F-K",e->(e+459.67)/1.8);
    }

    @Override
    public Double convert(ConverterRequest request) {

      return  Optional.ofNullable( functionStore.get(request.getSourceUnit().name() + "-"
                + request.getTargetUnit().name()))
                .orElseThrow(()-> new ConverterException(ErrorEnum.NOT_SUPPORTED))
                .apply(request.getValue());

    }
}
