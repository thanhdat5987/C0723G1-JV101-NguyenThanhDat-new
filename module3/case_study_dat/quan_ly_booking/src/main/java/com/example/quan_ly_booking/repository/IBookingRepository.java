package com.example.quan_ly_booking.repository;

import com.example.quan_ly_booking.model.*;

import java.sql.SQLException;
import java.util.List;

public interface IBookingRepository {
void insertBooking(Booking booking) throws SQLException;
Booking selectBooking(int id) throws SQLException;
List<BookingDTO> selectAllBooking() throws SQLException;
List<BookingStatus> selectBookingStatus() throws SQLException;
List<EmployeeBooking> selectEmployeelist() throws SQLException;
List<PetBooking> selectPetList() throws SQLException;
List<PetBooking> selectPetOfCustomerList() throws SQLException;
boolean deleteBooking(int id) throws SQLException;
boolean updateBooking(Booking booking) throws SQLException;
void insertCustomerBooking(Booking booking) throws SQLException;
void insertDetailService(DetailService detailService) throws SQLException;
List<ServiceBooking> selectServiceList() throws SQLException;
List<DetailServiceBookingDTO> selectDetailServiceList(int id) throws SQLException;
DetailServiceDTO selectDetailService(int id) throws SQLException;
boolean updateDetailService(DetailService detailService) throws SQLException;
}
