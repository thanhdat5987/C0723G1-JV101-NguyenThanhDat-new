package com.example.casestudy.repository;


import com.example.casestudy.dto.BookingDTO;
import com.example.casestudy.dto.BookingNamDTO;
import com.example.casestudy.dto.DetailServiceBookingDTO;
import com.example.casestudy.dto.DetailServiceDTO;
import com.example.casestudy.model.*;

import java.sql.SQLException;
import java.util.List;

public interface IBookingRepository {
void insertBooking(Booking booking) throws SQLException;
Booking selectBooking(int id) throws SQLException;
List<BookingDTO> selectAllBooking() throws SQLException;
List<BookingStatus> selectBookingStatus() throws SQLException;
List<EmployeeBooking> selectEmployeelist() throws SQLException;
List<PetBooking> selectPetList() throws SQLException;
List<PetBooking> selectPetOfCustomerList(int idAcc) throws SQLException;
boolean deleteBooking(int id) throws SQLException;
boolean updateBooking(Booking booking) throws SQLException;
void insertCustomerBooking(Booking booking) throws SQLException;
void insertDetailService(DetailService detailService) throws SQLException;
List<ServiceBooking> selectServiceList() throws SQLException;
List<DetailServiceBookingDTO> selectDetailServiceList(int id) throws SQLException;
DetailServiceDTO selectDetailService(int id) throws SQLException;
boolean updateDetailService(DetailService detailService) throws SQLException;
    List<BookingNamDTO> bookingDetail(int bookingId);
}
