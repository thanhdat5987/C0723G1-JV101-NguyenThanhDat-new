package bai_3.service;

import bai_3.model.ElectricalBill;

import java.util.List;

public interface IElectricalBillService {
    void addBill(ElectricalBill bill);
    List<ElectricalBill> getAllBills();
}
