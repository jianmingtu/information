package ca.bc.gov.open.einfo.controllers;

import ca.bc.gov.open.einfo.common.CodeTableValueRequest;
import ca.bc.gov.open.einfo.common.GetCodeTableValuesResponse;
import ca.bc.gov.open.einfo.configuration.SoapConfig;
import ca.bc.gov.open.einfo.exceptions.ORDSException;
import ca.bc.gov.open.einfo.models.OrdsErrorLog;
import ca.bc.gov.open.einfo.models.RequestSuccessLog;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
@Slf4j
public class CodeValuesController {

    @Value("${einfo.host}")
    private String host = "https://127.0.0.1/";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    @Autowired
    public CodeValuesController(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    @PayloadRoot(namespace = SoapConfig.SOAP_NAMESPACE, localPart = "CodeTableValueRequest")
    @ResponsePayload
    public GetCodeTableValuesResponse getCodeTableValues(
            @RequestPayload CodeTableValueRequest request) throws JsonProcessingException {

        UriComponentsBuilder builder =
                UriComponentsBuilder.fromHttpUrl(host + "code-table-values")
                        .queryParam("formId", request.getFormId())
                        .queryParam("queryParamList", request.getQueryParamList())
                        .queryParam("ticket", request.getTicket());

        try {
            HttpEntity<GetCodeTableValuesResponse> resp =
                    restTemplate.exchange(
                            builder.build().toUri(),
                            HttpMethod.GET,
                            new HttpEntity<>(new HttpHeaders()),
                            GetCodeTableValuesResponse.class);

            log.info(
                    objectMapper.writeValueAsString(
                            new RequestSuccessLog("Request Success", "getCodeTableValues")));
            return resp.getBody();
        } catch (Exception ex) {
            log.error(
                    objectMapper.writeValueAsString(
                            new OrdsErrorLog(
                                    "Error received from ORDS",
                                    "getCodeTableValues",
                                    ex.getMessage(),
                                    request)));
            throw new ORDSException();
        }
    }
}
