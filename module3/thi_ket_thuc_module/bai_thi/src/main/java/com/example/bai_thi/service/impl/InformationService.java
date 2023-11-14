package com.example.bai_thi.service.impl;

import com.example.bai_thi.model.InformationDTO;
import com.example.bai_thi.repository.IIformationRepository;
import com.example.bai_thi.repository.impl.InformationRepository;
import com.example.bai_thi.service.IInformationService;

import java.sql.SQLException;
import java.util.List;

public class InformationService implements IInformationService {
     IIformationRepository informationRepository = new InformationRepository();

    @Override
    public List<InformationDTO> listInformation() throws SQLException {
        return informationRepository.listInformation();
    }

    @Override
    public boolean deleteInformation(String information_code) {
        return false;
    }
}
