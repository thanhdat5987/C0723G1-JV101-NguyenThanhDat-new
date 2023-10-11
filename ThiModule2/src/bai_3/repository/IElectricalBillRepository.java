package bai_3.repository;

import bai_3.model.ElectricalBill;

import java.util.List;

public interface IElectricalBillRepository {
    void addBill(ElectricalBill bill);
    List<ElectricalBill> getAllBills();
}
