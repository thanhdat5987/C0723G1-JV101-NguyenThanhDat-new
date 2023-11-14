package com.example.casestudy.service.impl;


import com.example.casestudy.model.Pet;
import com.example.casestudy.repository.IPetRepository;
import com.example.casestudy.repository.impl.PetRepository;
import com.example.casestudy.service.IPetService;

import java.sql.SQLException;
import java.util.List;

public class PetService implements IPetService {
    private final IPetRepository petRepository= new PetRepository();

    @Override
    public void insertPet(Pet pet) throws SQLException {
        petRepository.insertPet(pet);
    }

    @Override
    public Pet selectPet(int id) throws SQLException {
        return petRepository.selectPet(id);
    }

    @Override
    public List<Pet> selectAllPet() {
        return petRepository.selectAllPet();
    }

    @Override
    public boolean deletePet(int id) throws SQLException {
        return petRepository.deletePet(id);
    }

    @Override
    public boolean updatePet(Pet pet) throws SQLException {
        return petRepository.updatePet(pet);
    }

    @Override
    public List<Pet> searchByName(String name) {
        return petRepository.searchByName(name);
    }


}
