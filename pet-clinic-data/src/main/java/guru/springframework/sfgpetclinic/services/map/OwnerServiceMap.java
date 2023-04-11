package guru.springframework.sfgpetclinic.services.map;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Pet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.PetService;
import guru.springframework.sfgpetclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner,Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner object) {

        if(object !=null)
        {
            if(object.getPets() !=null)
            {
                object.getPets().forEach(pets ->{
                    if(pets.getPetType() != null)
                    {
                        if(pets.getPetType().getId() == null)
                        {
                            pets.setPetType(petTypeService.save(pets.getPetType()));
                        }
                    }else{
                        throw new RuntimeException("");
                    }

                    if(pets.getId() == null)
                    {
                        Pet savedPet = petService.save(pets);
                        pets.setId(savedPet.getId());
                    }
                });
            }
            return super.save(object);

        }else {
            return null;
        }

    }

    @Override
    public void delete(Owner owner) {
         super.delete(owner);

    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);

    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}
