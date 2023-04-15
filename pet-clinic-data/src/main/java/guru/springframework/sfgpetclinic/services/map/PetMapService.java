package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class PetMapService extends AbstractMapService<Pet,Long> implements PetService {
    private final PetTypeService petTypeService;
    private final PetService petService;

    public PetMapService(@Lazy PetTypeService petTypeService,@Lazy PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public void delete(Pet object) {
        super.delete(object);

    }

    @Override
    public Pet save(Pet pet) {
        return super.save(pet);
    }

    @Override
    public Pet findById(Long id) {
        return super.findById(id);
    }
}
