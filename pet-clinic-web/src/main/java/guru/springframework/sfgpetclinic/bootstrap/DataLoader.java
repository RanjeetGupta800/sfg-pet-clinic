package guru.springframework.sfgpetclinic.bootstrap;

import guru.springframework.sfgpetclinic.model.Owner;
import guru.springframework.sfgpetclinic.model.Vet;
import guru.springframework.sfgpetclinic.services.OwnerService;
import guru.springframework.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner= new Owner();
        owner.setId(1L);
        owner.setFirstName("Ranjeet");
        owner.setLastName("Gupta");

        ownerService.save(owner);

        Owner owner1= new Owner();
        owner1.setId(2L);
        owner1.setFirstName("Bharat");
        owner1.setLastName("Singh");

        ownerService.save(owner1);
        System.out.println("Loaded Owner..........");

        Vet vet=new Vet();
        vet.setId(1L);
        vet.setFirstName("Vijay");
        vet.setLastName("Verma");

        vetService.save(vet);

        Vet vet1=new Vet();
        vet1.setId(2L);
        vet1.setFirstName("Sukarjan");
        vet1.setLastName("Jain");

        vetService.save(vet1);
        System.out.println("Loaded Vet..........");

    }
}
