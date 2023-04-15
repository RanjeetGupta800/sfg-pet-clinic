package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Speciality;
import guru.springframework.sfgpetclinic.repositories.SpecialityRepository;
import guru.springframework.sfgpetclinic.services.SpecialityService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
@Service
@Profile("springDatajpa")
public class SpecialitySDjpaService implements SpecialityService {

    private final SpecialityRepository specialityRepository;

    public SpecialitySDjpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialitites = new HashSet<>();
        specialityRepository.findAll().forEach(specialitites :: add);
        return specialitites;
    }

    @Override
    public Speciality findById(Long aLong) {
        return specialityRepository.findById(aLong).orElse(null);
    }

    @Override
    public Speciality save(Speciality Object) {
        return specialityRepository.save(Object);
    }

    @Override
    public void delete(Speciality Object) {
    specialityRepository.delete(Object);
    }

    @Override
    public void deleteById(Long aLong) {
    specialityRepository.deleteById(aLong);
    }
}
