package com.example.quan_ly_booking.repository;

import com.example.quan_ly_booking.model.Booking;
import com.example.quan_ly_booking.model.BookingDTO;

import java.sql.SQLException;
import java.util.List;

public interface IBookingRepository {
void insertBooking(Booking booking) throws SQLException;
Booking selectBooking(int id) throws SQLException;
List<BookingDTO> selectAllBooking() throws SQLException;
boolean deleteBooking(int id) throws SQLException;
boolean updateBooking(Booking booking) throws SQLException;
}
