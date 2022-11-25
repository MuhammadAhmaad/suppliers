package com.example.suppliers.model;

public class ErrorDetailsResponse extends BaseResponseDTO {

    /**
     *
     */
    private static final long serialVersionUID = 1L;
    private String error;

    public ErrorDetailsResponse(String responseCode, String responseDate, String error) {
        super(responseCode, responseDate);
        this.error = error;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}