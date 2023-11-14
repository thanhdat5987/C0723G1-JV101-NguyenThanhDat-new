package com.example.casestudy.repository.impl;


import com.example.casestudy.dto.BookingDTO;
import com.example.casestudy.dto.BookingNamDTO;
import com.example.casestudy.dto.DetailServiceBookingDTO;
import com.example.casestudy.dto.DetailServiceDTO;
import com.example.casestudy.model.*;
import com.example.casestudy.repository.BaseRepository;
import com.example.casestudy.repository.IBookingRepository;

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
            "where customer.id_account=?";
    private static final String UPDATE_BOOKING_FOR_DELETING = "update booking set delete_booking =1 where id_booking =?";
    private static final String UPDATE_BOOKING = "update booking set id_employee=?,start_time =? , end_time =? , booking_id_status =? where id_booking =?";
    private static final String SELECT_BOOKING_BY_ID = "select * from booking where id_booking=?";
    private static final String SELECT_BOOKING_STATUS_LIST = "select * from booking_status";
    private static final String SELECT_EMPLOYEE_LIST = "select employees.id_employee, employees.employee_name from employees";
    private static final String SELECT_PET_CUSTOMER_LIST = "select pet.id_pet, concat(pet.name_pet ,\" - KH \", customer.name_customer) as pet_name \n" +
            "from pet\n" +
            "join customer on pet.id_pet = customer.id_customer";
    private static final String INSERT_DETAIL_SERVICE = "INSERT INTO detail_service (id_booking,id_service,quantity) VALUES (?, ?, ?)";
    private static final String SELECT_SERVICE_LIST = "select service.id_service, service.service_name from service";
    private static final String SELECT_DETAIL_SERVICE_BY_BOOKING_ID = "select detail_service.id_detail_service, pet.name_pet, customer.name_customer, employees.employee_name, booking.start_time, booking.end_time, service.service_name, detail_service.quantity, service.service_price,(service.service_price*detail_service.quantity) as total, booking.customer_comment\n" +
            "from booking join\n" +
            "pet on booking.id_pet = pet.id_pet\n" +
            "join customer on customer.id_customer = pet.id_customer\n" +
            "left join employees on booking.id_employee = employees.id_employee\n" +
            "join detail_service on detail_service.id_booking = booking.id_booking\n" +
            "join service on service.id_service = detail_service.id_service\n" +
            "where booking.delete_booking =0 and booking.id_booking =?;";
private static final String SELECT_DETAIL_SERVICE_BY_ID ="select detail_service.id_detail_service, pet.name_pet, customer.name_customer, employees.employee_name, booking.start_time, booking.end_time, service.service_name, detail_service.quantity, service.service_price, (service.service_price*detail_service.quantity) as total, booking.customer_comment\n" +
        "from booking join\n" +
        "pet on booking.id_pet = pet.id_pet\n" +
        "join customer on customer.id_customer = pet.id_customer\n" +
        "left join employees on booking.id_employee = employees.id_employee\n" +
        "join detail_service on detail_service.id_booking = booking.id_booking\n" +
        "join service on service.id_service = detail_service.id_service\n" +
        "where detail_service.id_detail_service =?";
private static final String UPDATE_DETAIL_SERVICE ="update detail_service set quantity =? where id_detail_service =?";

    private static final String
            SELECT_BOOKING_DETAIL = "select \n" +
            "*,service.service_price*quantity as sum_detail\n" +
            "            from booking b\n" +
            "            join booking_status s on s.booking_id_status = b.booking_id_status\n" +
            "            join detail_service d on d.id_booking=b.id_booking\n" +
            "            join service on service.id_service = service.id_service\n" +
            "            where b.id_booking =? ;";

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
    public List<EmployeeBooking> selectEmployeelist() throws SQLException {
        List<EmployeeBooking> employeeList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_EMPLOYEE_LIST);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int employeeId = rs.getInt("id_employee");
            String employeeName = rs.getString("employee_name");
            employeeList.add(new EmployeeBooking(employeeId, employeeName));
        }
        return employeeList;
    }


    @Override
    public List<PetBooking> selectPetList() throws SQLException {
        List<PetBooking> petList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PET_CUSTOMER_LIST);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int petId = rs.getInt("id_pet");
            String petName = rs.getString("pet_name");
            petList.add(new PetBooking(petId, petName));
        }
        return petList;
    }

    @Override
    public List<PetBooking> selectPetOfCustomerList(int idAcc) throws SQLException {
        List<PetBooking> petList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();

        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PET_OF_CUSTOMER);
        preparedStatement.setInt(1,idAcc);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int petId = rs.getInt("id_pet");
            String petName = rs.getString("name_pet");
            petList.add(new PetBooking(petId, petName));
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
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(UPDATE_BOOKING);) {
            statement.setInt(1, booking.getEmployeeId());
            statement.setString(2,booking.getStartTime());
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
        preparedStatement.setInt(1, detailService.getBookingId());
        preparedStatement.setInt(2, detailService.getServiceId());
        preparedStatement.setInt(3, detailService.getQuantity());
        System.out.println(preparedStatement);
        preparedStatement.execute();
    }

    @Override
    public List<ServiceBooking> selectServiceList() throws SQLException {
        List<ServiceBooking> serviceList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_SERVICE_LIST);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int serviceId = rs.getInt("id_service");
            String serviceName = rs.getString("service_name");
            serviceList.add(new ServiceBooking(serviceId, serviceName));
        }
        return serviceList;
    }

    @Override
    public List<DetailServiceBookingDTO> selectDetailServiceList(int id) throws SQLException {
        List<DetailServiceBookingDTO> detailServiceList = new ArrayList<>();
        Connection connection =BaseRepository.getConnectDB();
        PreparedStatement preparedStatement =connection.prepareStatement(SELECT_DETAIL_SERVICE_BY_BOOKING_ID);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()){
            int detailServiceId = rs.getInt("id_detail_service");
            String petName = rs.getString("name_pet");
            String customerName = rs.getString("name_customer");
            String employeeName = rs.getString("employee_name");
            String startTime = rs.getString("start_time");
            String endTime = rs.getString("end_time");
            String serviceName = rs.getString("service_name");
            int quantity = rs.getInt("quantity");
            int price = rs.getInt("service_price");
            int total = rs.getInt("total");
            String customerComment = rs.getString("customer_comment");
            detailServiceList.add(new DetailServiceBookingDTO(detailServiceId,petName,customerName,employeeName,startTime,endTime,serviceName,quantity,price,total,customerComment));
        }
        return detailServiceList;
    }

    @Override
    public DetailServiceDTO selectDetailService(int id) throws SQLException {
        DetailServiceDTO detailService = null;
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DETAIL_SERVICE_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet rs = preparedStatement.executeQuery();
        while (rs.next()) {
            int detailServiceId = rs.getInt("id_detail_service");
            String petName = rs.getString("name_pet");
            String customerName = rs.getString("name_customer");
            String employeeName = rs.getString("employee_name");
            String startTime = rs.getString("start_time");
            String endTime = rs.getString("end_time");
            String serviceName = rs.getString("service_name");
            int quantity = rs.getInt("quantity");
            int price = rs.getInt("service_price");
            int total = rs.getInt("total");
            String customerComment = rs.getString("customer_comment");
            detailService = new DetailServiceDTO(detailServiceId,petName,customerName,employeeName,startTime,endTime,serviceName,quantity,price,total,customerComment);
        }
        return detailService;
    }

    @Override
    public boolean updateDetailService(DetailService detailService) throws SQLException {
        boolean rowUpdated;
        try (Connection connection = BaseRepository.getConnectDB();
             PreparedStatement statement = connection.prepareStatement(UPDATE_DETAIL_SERVICE);) {
            statement.setInt(1, detailService.getQuantity());
            statement.setInt(2, detailService.getDetailServiceId());
            rowUpdated = statement.executeUpdate() > 0;
        }
        return rowUpdated;
    }
    @Override
    public List<BookingNamDTO> bookingDetail(int bookingId) {
        Connection connection =BaseRepository.getConnectDB();
        List<BookingNamDTO> serviceList=new ArrayList<>();
        BookingNamDTO service=null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_BOOKING_DETAIL);
            preparedStatement.setInt(1,bookingId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                String serviceName = resultSet.getString("service_name");
                int quantity=resultSet.getInt("quantity");
                String unit = resultSet.getString("unit");
                int priceTotal = resultSet.getInt("sum_detail");
                service=new BookingNamDTO(serviceName,quantity,unit,priceTotal);
                serviceList.add(service);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return serviceList;

    }
}
