package co.com.hellocode.services.tempconversor.services;

import co.com.hellocode.services.tempconversor.dto.ConverterRequest;
import co.com.hellocode.services.tempconversor.dto.ConverterResponse;

public interface ConverterService {

    /**
     * Transforms temperature into specific unit
     * @param request
     * @return
     */
    public Double convert(ConverterRequest request);

}
