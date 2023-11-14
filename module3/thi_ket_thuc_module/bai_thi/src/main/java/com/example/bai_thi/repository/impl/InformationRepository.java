package com.example.bai_thi.repository.impl;

import com.example.bai_thi.model.InformationDTO;
import com.example.bai_thi.repository.BaseRepository;
import com.example.bai_thi.repository.IIformationRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InformationRepository implements IIformationRepository {
    private final String SELECT_ALL_INFORMATION ="select information.infor_code, pet_owner.owner_user_name, pet.pet_code, information.detail, information.date_infor, information.payment from\n" +
            "information join pet_owner \n" +
            "on information.owner_user_name = pet_owner.owner_user_name\n" +
            "join pet on information.pet_code = pet.pet_code";
    private final String DELETE_INFORMATION ="delete from information where information.infor_code=?";

//    information.infor_code, pet_owner.owner_name, pet.pet_code, information.detail, information.date_infor, information.payment
    @Override
    public List<InformationDTO> listInformation() throws SQLException {
        List<InformationDTO> informationDTOList = new ArrayList<>();
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement =connection.prepareStatement(SELECT_ALL_INFORMATION);
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()){
            String informationCode = resultSet.getString("infor_code");
            String userName = resultSet.getString("owner_user_name");
            String petCode = resultSet.getString("owner_user_name");
            String informationDetail = resultSet.getString("detail");
            String dateInfor = resultSet.getString("date_infor");
            int payment = resultSet.getInt("payment");
            informationDTOList.add(new InformationDTO(informationCode,userName,petCode,informationDetail,dateInfor,payment));
        }
        return informationDTOList;
    }

    @Override
    public boolean deleteInformation(String information_code) throws SQLException {
        boolean rowDelete;
        Connection connection = BaseRepository.getConnectDB();
        PreparedStatement preparedStatement =connection.prepareStatement(DELETE_INFORMATION);
        preparedStatement.setString(1,information_code);
        rowDelete = preparedStatement.executeUpdate()>0;
        return rowDelete;
    }
}
