package br.com.helber.testecliente.application.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ClienteResponse {
    private int status;
    private Object data;

    @Data
    @AllArgsConstructor
    public static class ErrorResponse {
        private String message;
        private String error;
    }

    @Data
    @AllArgsConstructor
    public static class SuccessResponse {
        private String message;
    }
}