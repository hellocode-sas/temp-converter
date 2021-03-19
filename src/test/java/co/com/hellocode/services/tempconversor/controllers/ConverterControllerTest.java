package co.com.hellocode.services.tempconversor.controllers;

import co.com.hellocode.services.tempconversor.TempConversorApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;



@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.MOCK,
        classes = TempConversorApplication.class
)
@AutoConfigureMockMvc
class ConverterControllerTest {

    @Autowired
    protected MockMvc mvc;

    @Test
    public void case01$executingOperation() throws Exception {

        MvcResult mvcResult = mvc.perform(get("/convert?from=K&to=C&value=324"))
                .andDo(print())
                .andExpect(jsonPath("$.displayResult").value("50.85"))
                .andExpect(jsonPath("$.request.targetUnit").value("C"))
                .andExpect(jsonPath("$.request.sourceUnit").value("K"))
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        System.out.println("JSON" + json);

    }


    @Test
    public void case02$executingWrongValue() throws Exception {

        MvcResult mvcResult = mvc.perform(get("/convert?from=K&to=C&value=32-D4"))
                .andDo(print())
                .andExpect(jsonPath("$.errorCode").value("INVALID_REQUEST"))
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        System.out.println("JSON" + json);

    }


    @Test
    public void case03$executingMissingData() throws Exception {

        MvcResult mvcResult = mvc.perform(get("/convert?from=L&to=M&value=324"))
                .andDo(print())
                .andExpect(jsonPath("$.errorCode").value("INVALID_REQUEST"))
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        System.out.println("JSON" + json);

    }



    @Test
    public void case04$executingInvalidOperation() throws Exception {

        MvcResult mvcResult = mvc.perform(get("/convert"))
                .andDo(print())
                .andExpect(jsonPath("$.errorCode").value("VALUE_NOT_FOUND"))
                .andReturn();

        String json = mvcResult.getResponse().getContentAsString();
        System.out.println("JSON" + json);

    }


}