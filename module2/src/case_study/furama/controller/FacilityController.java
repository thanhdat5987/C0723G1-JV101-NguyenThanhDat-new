package case_study.furama.controller;

import case_study.furama.model.Facility;
import case_study.furama.service.IFacilityService;
import case_study.furama.service.Impl.FacilityServiceImpl;

import java.util.List;

public class FacilityController {
    private IFacilityService<Facility> facilityService = new FacilityServiceImpl();
    public List<Facility> displayFacilityMaintenance() {
        return facilityService.displayFacilityMaintenance();
    }


    public void deleteFacility(int index) {
        facilityService.deleteFacility(index);
    }


    public void add(Facility facility) {
        facilityService.add(facility);
    }


    public List<Facility> display() {
        return facilityService.display();
    }
}
