package com.example.quan_ly_booking.repository.impl;

import com.example.quan_ly_booking.model.Booking;
import com.example.quan_ly_booking.model.BookingDTO;
import com.example.quan_ly_booking.repository.BaseRepository;
import com.example.quan_ly_booking.repository.IBookingRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookingRepository implements IBookingRepository {
    private static final String SELECT_ALL_BOOKING = "select booking.id_booking, booking.booking_time, booking.estimated_time_of_arrival, booking.start_time, booking.end_time, pet.name_pet, customer.name_customer, employees.employee_name, booking_status.booking_name_status\n" +
            "from booking \n" +
            "join pet on booking.id_pet = pet.id_pet\n" +
            "join customer on customer.id_customer = pet.id_customer\n" +
            "join employees on employees.id_employee = booking.id_employee\n" +
            "join booking_status on booking_status.booking_id_status = booking.booking_id_status\n" +
            "where booking.delete_booking =0"

            ;
    private static final String INSERT_BOOKING = "insert into booking (id_pet, id_employee) value(?,?)";
    private static final String UPDATE_BOOKING_FOR_DELETING ="update booking set delete_booking =1 where id_booking =?";
    private static final String UPDATE_BOOKING ="update booking set start_time =? , end_time =? , booking_id_status =? where id_booking =?";
private static final String SELECT_BOOKING_BY_ID="select * from booking where id_booking=?";
    @Override
    public void insertBooking(Booking booking)  {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING);
                preparedStatement.setInt(1, booking.getPetId());
                preparedStatement.setInt(2, booking.getEmployeeId());
                System.out.println(preparedStatement);
                preparedStatement.executeUpdate();
            }
             catch(SQLException e){
                throw new RuntimeException(e);
            }
        }


    @Override
    public Booking selectBooking(int id)  {
        Booking booking = null;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_BY_ID);) {
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int bookingId = rs.getInt("id_booking");
                int petId = rs.getInt("id_pet");
                int employeeId = rs.getInt("id_employee");
                String  bookingTime= rs.getString("booking_time");
                String estimatedTimeOfArrival = rs.getString("estimated_time_of_arrival");
                String startTime = rs.getString("start_time");
                String endTime = rs.getString("end_time");
                int bookingStatusId = rs.getInt("booking_id_status");
                booking = new Booking(bookingId,petId,employeeId,bookingTime,estimatedTimeOfArrival,startTime,endTime,bookingStatusId);
            }
        } catch (SQLException e) {
           throw new RuntimeException(e);
        }
        return booking;
    }

    @Override
    public List<BookingDTO> selectAllBooking() {
        List<BookingDTO> bookings = new ArrayList<>();
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_BOOKING);) {
            System.out.println(preparedStatement);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                int bookingId = rs.getInt("id_booking");
                String petName = rs.getString("name_pet");
                String customerName = rs.getString("name_customer");
                String employeeName = rs.getString("employee_name");
                String bookingTime = rs.getString("booking_time");
                String estimatedTimeOfArrival = rs.getString("estimated_time_of_arrival");
                String startTime = rs.getString("start_time");
                String endTime = rs.getString("end_time");
                String bookingNameStatus = rs.getString("booking_name_status");
                bookings.add(new BookingDTO(bookingId, petName, customerName, employeeName, bookingTime, estimatedTimeOfArrival, startTime, endTime, bookingNameStatus));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return bookings;
    }

    @Override
    public boolean deleteBooking(int id) throws SQLException {
        boolean rowDeleted;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING_FOR_DELETING);) {
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        return rowDeleted;
    }

    @Override
    public boolean updateBooking(Booking booking) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB(); PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING);) {
            statement.setString(1, booking.getStartTime());
            statement.setString(2, booking.getEndTime());
            statement.setInt(3, booking.getStatusId());
            statement.setInt(4, booking.getBookingId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
}
