package co.com.hellocode.services.tempconversor.services.impl;

import co.com.hellocode.services.tempconversor.constants.TemperatureUnitEnum;
import co.com.hellocode.services.tempconversor.dto.ConverterRequest;
import co.com.hellocode.services.tempconversor.services.ConverterService;
import org.junit.jupiter.api.Test;

import java.text.DecimalFormat;

import static org.junit.jupiter.api.Assertions.*;

class BasicConverterServiceTest {

    ConverterService converterService = new BasicConverterService();

    @Test
    void case01$convertCtoC() {

      Double result=  converterService.convert(ConverterRequest.builder()
                .sourceUnit(TemperatureUnitEnum.C)
                .targetUnit(TemperatureUnitEnum.C)
                .value(30d)
                .build());

      assertEquals(Double.valueOf(30), result);

    }

    @Test
    void case02$convertCtoF() {

        Double result=  converterService.convert(ConverterRequest.builder()
                .sourceUnit(TemperatureUnitEnum.C)
                .targetUnit(TemperatureUnitEnum.F)
                .value(30d)
                .build());

        assertEquals(Double.valueOf(86), result);

    }

    @Test
    void case03$convertCtoK() {

        Double result=  converterService.convert(ConverterRequest.builder()
                .sourceUnit(TemperatureUnitEnum.C)
                .targetUnit(TemperatureUnitEnum.K)
                .value(30d)
                .build());

        assertEquals(Double.valueOf(303.15), result);

    }


    @Test
    void case04$convertKtoK() {

        Double result=  converterService.convert(ConverterRequest.builder()
                .sourceUnit(TemperatureUnitEnum.K)
                .targetUnit(TemperatureUnitEnum.K)
                .value(0d)
                .build());

        assertEquals(Double.valueOf(0), result);

    }


    @Test
    void case05$convertKtoF() {

        Double result=  converterService.convert(ConverterRequest.builder()
                .sourceUnit(TemperatureUnitEnum.K)
                .targetUnit(TemperatureUnitEnum.F)
                .value(312d)
                .build());

        assertEquals(Double.valueOf(101.93), result);

    }


    @Test
    void case06$convertKtoC() {

        Double result=  converterService.convert(ConverterRequest.builder()
                .sourceUnit(TemperatureUnitEnum.K)
                .targetUnit(TemperatureUnitEnum.C)
                .value(312d)
                .build());

        assertEquals("38.85", new DecimalFormat("##.##").format(result));

    }


    @Test
    void case07$convertFtoF() {

        Double result=  converterService.convert(ConverterRequest.builder()
                .sourceUnit(TemperatureUnitEnum.F)
                .targetUnit(TemperatureUnitEnum.F)
                .value(92d)
                .build());

        assertEquals("92", new DecimalFormat("##.##").format(result));

    }


    @Test
    void case08$convertFtoK() {

        Double result=  converterService.convert(ConverterRequest.builder()
                .sourceUnit(TemperatureUnitEnum.F)
                .targetUnit(TemperatureUnitEnum.K)
                .value(90d)
                .build());

        assertEquals("305.37", new DecimalFormat("##.##").format(result));

    }


    @Test
    void case09$convertFtoC() {

        Double result=  converterService.convert(ConverterRequest.builder()
                .sourceUnit(TemperatureUnitEnum.F)
                .targetUnit(TemperatureUnitEnum.C)
                .value(90d)
                .build());

        assertEquals("32.22", new DecimalFormat("##.##").format(result));

    }





}