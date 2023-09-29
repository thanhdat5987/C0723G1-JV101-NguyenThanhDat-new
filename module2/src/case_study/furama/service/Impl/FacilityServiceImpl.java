package case_study.furama.service.Impl;

import case_study.furama.model.Facility;
import case_study.furama.repository.IFacilityRepository;
import case_study.furama.repository.impl.FacilityRepositoryImpl;
import case_study.furama.service.IFacilityService;

import java.util.List;

public class FacilityServiceImpl implements IFacilityService<Facility> {
    private IFacilityRepository<Facility> facilityRepository = new FacilityRepositoryImpl();

    @Override
    public List<Facility> displayFacilityMaintenance() {
        return facilityRepository.displayFacilityMaintenance();
    }

    @Override
    public void deleteFacility(int index) {
        facilityRepository.deleteFacility(index);
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
