package case_study.furama.controller;

import case_study.furama.model.Facility;
import case_study.furama.service.IFacilityService;
import case_study.furama.service.Impl.FacilityServiceImpl;

import java.util.LinkedHashMap;
import java.util.List;

public class FacilityController {
    private IFacilityService<Facility> facilityService = new FacilityServiceImpl();
    public LinkedHashMap<Facility,Integer> displayFacilityMaintenance() {
        return facilityService.displayFacilityMaintenance();
    }


    public void deleteFacility(Facility facility) {
        facilityService.deleteFacility(facility);
    }


    public void add(Facility facility) {
        facilityService.add(facility);
    }


    public LinkedHashMap<Facility, Integer> displayFacility() {
        return facilityService.displayFacility();
    }
}
