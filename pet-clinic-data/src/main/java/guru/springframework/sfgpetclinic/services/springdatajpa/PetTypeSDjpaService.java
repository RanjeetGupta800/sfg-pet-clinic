package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.PetType;
import guru.springframework.sfgpetclinic.repositories.PetTypeRepository;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@Profile("springDatajpa")
public class PetTypeSDjpaService implements PetTypeService {

    private final PetTypeRepository petTypeRepository;

    public PetTypeSDjpaService(PetTypeRepository petTypeRepository) {
        this.petTypeRepository = petTypeRepository;
    }


    @Override
    public Set<PetType> findAll() {
        Set<PetType> petTypes = new HashSet<>();
        petTypeRepository.findAll().forEach(petTypes :: add);
        return petTypes;
    }

    @Override
    public PetType findById(Long aLong) {
        return petTypeRepository.findById(aLong).orElse(null);
    }

    @Override
    public PetType save(PetType Object) {
        return petTypeRepository.save(Object);
    }

    @Override
    public void delete(PetType Object) {
    petTypeRepository.delete(Object);
    }

    @Override
    public void deleteById(Long aLong) {
    petTypeRepository.deleteById(aLong);
    }
}
