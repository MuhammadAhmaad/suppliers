package com.example.suppliers.model;


import java.io.Serializable;


public class APIResponseDTO extends BaseResponseDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -6986746375915710855L;

    private String responseMessage;
    private Object data;
    public APIResponseDTO(){

    }
    public APIResponseDTO(String responseCode, String responseDate, String responseMessage, Object data) {
        super(responseCode, responseDate);
        this.responseMessage = responseMessage;
        this.data = data;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
