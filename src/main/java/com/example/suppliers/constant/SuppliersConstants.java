package com.example.suppliers.constant;

public class SuppliersConstants {
    public static final String SUCCESS_RESPONSE_CODE = "000";
    public static final String SUCCESS_RESPONSE_MESSAGE = "The transaction has been ended successfully ";

    public static final String GENERAL_ERROR_RESPONSE_CODE = "001";
    public static final String GENERAL_ERROR_RESPONSE_MESSAGE = "The transaction has been failed for reason General Error";

    public static final String BUSINESS_ERROR_RESPONSE_CODE = "002";
    public static final String BUSINESS_ERROR_RESPONSE_MESSAGE = "The transaction has been failed for reason BUSINESS Error";

    public static final String BAD_ERROR_RESPONSE_CODE = "003";
    public static final String BAD_ERROR_RESPONSE_MESSAGE = "The transaction has been failed for reason BAD Request Error";

    public static final String APPOINTMENT_NOT_FOUND_CODE = "004";
    public static final String APPOINTMENT_NOT_FOUND_MESSAGE = "Appointment not found";

    public static final String APPOINTMENT_CREATION_FAILED_CODE = "005";
    public static final String APPOINTMENT_CREATION_FAILED_MESSAGE = "Appointment creation failed";

    public static final String APPOINTMENT_EXIST_WITH_SAME_DATE_CODE = "006";
    public static final String APPOINTMENT_EXIST_WITH_SAME_DATE_MESSAGE = "Appointment exist with same date";
    public static final String PATIENT_APPOINTMENT_EXIST_WITH_SAME_DATE_CODE = "007";
    public static final String PATIENT_APPOINTMENT_EXIST_WITH_SAME_DATE_MESSAGE = "Patient Appointment exist with same date";
    public static final String PATIENT_CREATION_FAILED_CODE = "008";
    public static final String PATIENT_CREATION_FAILED_MESSAGE = "Patient creation failed";
    public static final String CLINIC_CREATION_FAILED_CODE = "009";
    public static final String CLINIC_CREATION_FAILED_MESSAGE = "clinic creation failed";
}
