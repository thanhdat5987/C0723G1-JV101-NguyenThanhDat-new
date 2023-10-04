package case_study.furama.service.Impl;

import case_study.furama.model.Facility;
import case_study.furama.repository.IFacilityRepository;
import case_study.furama.repository.impl.FacilityRepositoryImpl;
import case_study.furama.service.IFacilityService;

import java.util.LinkedHashMap;
import java.util.List;

public class FacilityServiceImpl implements IFacilityService<Facility> {
    private final IFacilityRepository<Facility> facilityRepository = new FacilityRepositoryImpl();

    @Override
    public LinkedHashMap<Facility, Integer> displayFacilityMaintenance() {
        return facilityRepository.displayFacilityMaintenance();
    }

    @Override
    public void deleteFacility(Facility facility) {
        facilityRepository.deleteFacility(facility);
    }

    @Override
    public LinkedHashMap<Facility, Integer> displayFacility() {
        return facilityRepository.displayFacility();
    }

    @Override
    public void add(Facility facility) {
        facilityRepository.add(facility);
    }

    @Override
    public List<Facility> display() {
        return facilityRepository.display();
    }
}
