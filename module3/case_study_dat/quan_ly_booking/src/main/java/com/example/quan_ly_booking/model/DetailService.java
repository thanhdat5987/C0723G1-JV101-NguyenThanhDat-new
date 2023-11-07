package com.example.quan_ly_booking.model;

public class DetailService {

//    create table if not exists detail_service(
//            id_detail_service int auto_increment primary key,
//            id_booking int not null,
//            id_service int not null,
//            quantity int default 0,
//            foreign key (id_booking) references booking(id_booking),
//    foreign key (id_service) references service(id_service)
//            );

    private int detailServiceId;
    private int bookingId;
    private int serviceId;
    private int quantity;

    public DetailService(int detailServiceId, int bookingId, int serviceId, int quantity) {
        this.detailServiceId = detailServiceId;
        this.bookingId = bookingId;
        this.serviceId = serviceId;
        this.quantity = quantity;
    }

    public DetailService(int bookingId, int serviceId, int quantity) {
        this.bookingId = bookingId;
        this.serviceId = serviceId;
        this.quantity = quantity;
    }

    public int getDetailServiceId() {
        return detailServiceId;
    }

    public void setDetailServiceId(int detailServiceId) {
        this.detailServiceId = detailServiceId;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
