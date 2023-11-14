package com.example.bai_thi.model;

public class InformationDTO {
    private String informationCode;
    private String accountName;
    private String petCode;
    private String detail;
    private String date;
    private int payment;

    public InformationDTO(String informationCode, String accountName, String petCode, String detail, String date, int payment) {
        this.informationCode = informationCode;
        this.accountName = accountName;
        this.petCode = petCode;
        this.detail = detail;
        this.date = date;
        this.payment = payment;
    }

    public String getInformationCode() {
        return informationCode;
    }

    public void setInformationCode(String informationCode) {
        this.informationCode = informationCode;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getPetCode() {
        return petCode;
    }

    public void setPetCode(String petCode) {
        this.petCode = petCode;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getPayment() {
        return payment;
    }

    public void setPayment(int payment) {
        this.payment = payment;
    }
}
