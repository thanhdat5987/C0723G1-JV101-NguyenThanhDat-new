package com.example.casestudy.model;

public class ServiceBooking {
//    create table if not exists service(
//            id_service int auto_increment primary key,
//            service_name varchar(50) not null,
//    service_price int not null,
//    unit varchar(10 )not null
//            );
    private int serviceId;
    private String serviceName;
    private int servicePrice;
    private String unit;

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public int getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(int servicePrice) {
        this.servicePrice = servicePrice;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public ServiceBooking(int serviceId, String serviceName) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
    }

    public ServiceBooking(int serviceId, String serviceName, int servicePrice, String unit) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.unit = unit;
    }
}
