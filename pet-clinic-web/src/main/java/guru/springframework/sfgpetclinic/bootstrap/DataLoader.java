package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.*;
import guru.springframework.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    private final PetTypeService petTypeService;

    private final SpecialityService specialitiesService;

    //private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialitiesService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
    }


    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();
        if(count == 0)
        {
            loadData();
        }


    }

    private void loadData() {
        PetType dog= new PetType();
        dog.setName("Moti");
        PetType savedDogPetType= petTypeService.save(dog);

        PetType cat= new PetType();
        cat.setName("rani");
        PetType savedCatPetType= petTypeService.save(cat);

        Speciality radiology = new Speciality();
        radiology.setDescription("Radiology");
        Speciality savedRadiology = specialitiesService.save(radiology);

        Speciality surgery = new Speciality();
        surgery.setDescription("Surgery");
        Speciality savedSurgery = specialitiesService.save(surgery);

        Speciality dentistry = new Speciality();
        dentistry.setDescription("Dentist");
        Speciality savedDentistry = specialitiesService.save(dentistry);


        Owner owner= new Owner();
        owner.setId(1L);
        owner.setFirstName("Ranjeet");
        owner.setLastName("Gupta");
        owner.setAddress("Bramhanand nagar");
        owner.setCity("Bhiwandi");
        owner.setTelephone("123233455");

        Pet mikePet = new Pet();
        mikePet.setPetType(savedDogPetType);
        mikePet.setOwner(owner);
        mikePet.setBirthDate(LocalDate.now());
        mikePet.setName("Rosso");
        owner.getPets().add(mikePet);
        ownerService.save(owner);

        Owner owner1= new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Bharat");
        owner1.setLastName("Singh");
        owner1.setAddress("shanti nagar");
        owner1.setCity("Mumbai");
        owner1.setTelephone("543445666");

        Pet bharatCat = new Pet();
        bharatCat.setPetType(savedCatPetType);
        bharatCat.setOwner(owner1);
        bharatCat.setBirthDate(LocalDate.now());
        bharatCat.setName("Fionna");
        owner1.getPets().add(bharatCat);
        ownerService.save(owner1);
        System.out.println("Loaded Owner..........");

//        Visit catVisit = new Visit();
//        catVisit.setPet(bharatCat);
//        catVisit.setDate(LocalDate.now());
//        catVisit.setDescription("Sneezy Kitty");
//
//        visitService.save(catVisit);

        Vet vet=new Vet();
        vet.setId(1L);
        vet.setFirstName("Vijay");
        vet.setLastName("Verma");
        vet.getSpeciality().add(savedRadiology);

        vetService.save(vet);

        Vet vet1=new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Sukarjan");
        vet1.setLastName("Jain");
        vet1.getSpeciality().add(savedDentistry);

        vetService.save(vet1);
        System.out.println("Loaded Vet..........");



    }
}
