package com.example.bai_thi.service;

import com.example.bai_thi.model.InformationDTO;

import java.sql.SQLException;
import java.util.List;

public interface IInformationService {
    List<InformationDTO> listInformation() throws SQLException;
    boolean deleteInformation(String information_code);
}
