package case_study.furama.repository;

import java.util.List;

public interface IFacilityRepository<E>extends IRepository<E>{
List<E> displayFacilityMaintenance();
void deleteFacility(int index);
}
