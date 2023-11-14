package com.example.bai_thi.repository;

import com.example.bai_thi.model.InformationDTO;

import java.sql.SQLException;
import java.util.List;

public interface IIformationRepository {
    List<InformationDTO> listInformation() throws SQLException;
    boolean deleteInformation(String information_code) throws SQLException;

}
