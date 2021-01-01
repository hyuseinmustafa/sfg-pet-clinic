package com.hyuseinmustafa.sfgpetclinic.bootstrap;

import com.hyuseinmustafa.sfgpetclinic.model.Owner;
import com.hyuseinmustafa.sfgpetclinic.model.Pet;
import com.hyuseinmustafa.sfgpetclinic.model.PetType;
import com.hyuseinmustafa.sfgpetclinic.model.Vet;
import com.hyuseinmustafa.sfgpetclinic.services.OwnerService;
import com.hyuseinmustafa.sfgpetclinic.services.PetTypeService;
import com.hyuseinmustafa.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType petType = new PetType();
        petType.setName("Dog");
        PetType savedDogPetType = petTypeService.save(petType);

        petType = new PetType();
        petType.setName("Cat");
        PetType savedCatPetType = petTypeService.save(petType);

        Owner owner = new Owner();
        owner.setFirstName("Micheal");
        owner.setLastName("Weston");
        owner.setAddress("123 Brickerel");
        owner.setCity("Miami");
        owner.setTelephone("1233452341");
        Pet pet = new Pet();
        pet.setName("Rosco");
        pet.setPetType(savedDogPetType);
        pet.setBirthDate(LocalDate.now());
        pet.setOwner(owner);
        owner.getPets().add(pet);
        ownerService.save(owner);

        owner = new Owner();
        owner.setFirstName("Fiona");
        owner.setLastName("Glenanne");
        owner.setAddress("16 Stone");
        owner.setCity("London");
        owner.setTelephone("52487823689");
        pet = new Pet();
        pet.setName("Koti");
        pet.setPetType(savedCatPetType);
        pet.setBirthDate(LocalDate.now());
        pet.setOwner(owner);
        owner.getPets().add(pet);
        ownerService.save(owner);

        System.out.println("Owners Loaded ...");

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Jessie");
        vet.setLastName("Porter");
        vetService.save(vet);

        System.out.println("Vets Loaded ...");


    }
}
