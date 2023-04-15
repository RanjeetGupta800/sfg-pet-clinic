package guru.springframework.sfgpetclinic.services.springdatajpa;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.repositories.OwnerRepository;
import guru.springframework.sfgpetclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
@Service
@Profile("springDatajpa")
public class OwnerSDjpaService implements OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerSDjpaService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> owners = new HashSet<>();
        ownerRepository.findAll().forEach(owners :: add);
        return owners;
    }

    @Override
    public Owner findById(Long id) {
        Optional<Owner> ownerOptional=ownerRepository.findById(id);
        return ownerOptional.orElse(null);
    }

    @Override
    public Owner save(Owner Object) {
        return ownerRepository.save(Object);
    }

    @Override
    public void delete(Owner Object) {
    ownerRepository.delete(Object);
    }

    @Override
    public void deleteById(Long aLong) {
    ownerRepository.deleteById(aLong);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }
}
