package com.example.casestudy.repository;


import com.example.casestudy.model.Pet;

import java.sql.SQLException;
import java.util.List;

public interface IPetRepository {
    public void insertPet(Pet pet) throws SQLException;

    public Pet selectPet(int id) throws SQLException;

    public List<Pet> selectAllPet();

    public boolean deletePet(int id) throws SQLException;

    public boolean updatePet(Pet pet) throws SQLException;
    List<Pet> searchByName(String name);
}
