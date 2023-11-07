package com.example.quan_ly_booking.repository.impl;

import com.example.quan_ly_booking.model.*;
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
            "left join employees on employees.id_employee = booking.id_employee\n" +
            "join booking_status on booking_status.booking_id_status = booking.booking_id_status\n" +
            "where booking.delete_booking =0 order by id_booking desc";
    private static final String INSERT_BOOKING = "insert into booking (id_pet, id_employee) value(?,?)";
    private static final String INSERT_CUSTOMER_BOOKING = "insert into booking (id_pet, estimated_time_of_arrival, customer_comment) value(?,?,?)";
    private static final String SELECT_PET_OF_CUSTOMER = "select pet.id_pet, pet.name_pet \n" +
            "from pet\n" +
            "join customer on pet.id_customer = customer.id_customer\n" +
            "where customer.id_customer=1";
    private static final String UPDATE_BOOKING_FOR_DELETING = "update booking set delete_booking =1 where id_booking =?";
    private static final String UPDATE_BOOKING = "update booking set id_employee=?,start_time =? , end_time =? , booking_id_status =? where id_booking =?";
    private static final String SELECT_BOOKING_BY_ID = "select * from booking where id_booking=?";
    private static final String SELECT_BOOKING_STATUS_LIST = "select * from booking_status";
    private static final String SELECT_EMPLOYEE_LIST = "select employees.id_employee, employees.employee_name from employees";
    private static final String SELECT_PET_CUSTOMER_LIST = "select pet.id_pet, concat(pet.name_pet ,\" - KH \", customer.name_customer) as pet_name \n" +
            "from pet\n" +
            "join customer on pet.id_pet = customer.id_customer";
    private static final String INSERT_DETAIL_SERVICE ="INSERT INTO detail_service (id_booking,id_service,quantity) VALUES (?, ?, ?)";
private static final String SELECT_SERVICE_LIST ="select service.id_service, service.service_name from service";
    @Override
    public void insertBooking(Booking booking) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_BOOKING);
            preparedStatement.setInt(1, booking.getPetId());
            preparedStatement.setInt(2, booking.getEmployeeId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Booking selectBooking(int id) {
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
                String bookingTime = rs.getString("booking_time");
                String estimatedTimeOfArrival = rs.getString("estimated_time_of_arrival");
                String startTime = rs.getString("start_time");
                String endTime = rs.getString("end_time");
                int bookingStatusId = rs.getInt("booking_id_status");
                booking = new Booking(bookingId, petId, employeeId, bookingTime, estimatedTimeOfArrival, startTime, endTime, bookingStatusId);
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
    public List<BookingStatus> selectBookingStatus() throws SQLException {
        List<BookingStatus> bookingStatusList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_STATUS_LIST);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int bookingIdStatus = rs.getInt("booking_id_status");
            String bookingNameStatus = rs.getString("booking_name_status");
            bookingStatusList.add(new BookingStatus(bookingIdStatus, bookingNameStatus));
        }
        return bookingStatusList;
    }

    @Override
    public List<Employee> selectEmployeelist() throws SQLException {
        List<Employee> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_LIST);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int employeeId = rs.getInt("id_employee");
            String employeeName = rs.getString("employee_name");
            employeeList.add(new Employee(employeeId, employeeName));
        }
        return employeeList;
    }


    @Override
    public List<Pet> selectPetList() throws SQLException {
        List<Pet> petList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PET_CUSTOMER_LIST);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int petId = rs.getInt("id_pet");
            String petName = rs.getString("pet_name");
            petList.add(new Pet(petId, petName));
        }
        return petList;
    }

    @Override
    public List<Pet> selectPetOfCustomerList() throws SQLException {
        List<Pet> petList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PET_OF_CUSTOMER);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int petId = rs.getInt("id_pet");
            String petName = rs.getString("name_pet");
            petList.add(new Pet(petId, petName));
        }
        return petList;
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
            statement.setInt(1,booking.getEmployeeId());
            statement.setString(2, booking.getStartTime());
            statement.setString(3, booking.getEndTime());
            statement.setInt(4, booking.getStatusId());
            statement.setInt(5, booking.getBookingId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }

    @Override
    public void insertCustomerBooking(Booking booking) {
        Connection connection = BaseRepository.getConnectDB();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_CUSTOMER_BOOKING);
            preparedStatement.setInt(1, booking.getPetId());
            preparedStatement.setString(2, booking.getEstimatedTimeOfArrival());
            preparedStatement.setString(3, booking.getCustomerComment());
            System.out.println(preparedStatement);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insertDetailService(DetailService detailService) throws SQLException {
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DETAIL_SERVICE);
        preparedStatement.setInt(1,detailService.getBookingId());
        preparedStatement.setInt(2,detailService.getServiceId());
        preparedStatement.setInt(3,detailService.getQuantity());
        System.out.println(preparedStatement);
        preparedStatement.execute();
    }

    @Override
    public List<Service> selectServiceList() throws SQLException {
        List<Service> serviceList =new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement =connection.prepareStatement(SELECT_SERVICE_LIST);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            int serviceId = rs.getInt("id_service");
            String serviceName = rs.getString("service_name");
            serviceList.add(new Service(serviceId, serviceName));
        }
        return serviceList;
    }
}
