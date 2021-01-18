package com.hyuseinmustafa.sfgpetclinic.bootstrap;

import com.hyuseinmustafa.sfgpetclinic.model.*;
import com.hyuseinmustafa.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialityService specialityService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialityService specialityService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialityService = specialityService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {
        if(petTypeService.findAll().size() == 0) loadData();
    }

    private void loadData() {
        PetType petType = new PetType();
        petType.setName("Dog");
        PetType savedDogPetType = petTypeService.save(petType);

        petType = new PetType();
        petType.setName("Cat");
        PetType savedCatPetType = petTypeService.save(petType);

        System.out.println("Pet Types Loaded ...");

        Speciality speciality = new Speciality();
        speciality.setDescription("Radiology");
        Speciality savedRadiology = specialityService.save(speciality);

        speciality = new Speciality();
        speciality.setDescription("Surgery");
        Speciality savedSurgery = specialityService.save(speciality);

        speciality = new Speciality();
        speciality.setDescription("Dentistry");
        Speciality savedDentistry = specialityService.save(speciality);

        System.out.println("Specialities Loaded ...");

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

        Visit visit = new Visit();
        visit.setPet(pet);
        visit.setDate(LocalDate.now());
        visit.setDescription("Sneezy Kitty");
        visitService.save(visit);

        System.out.println("Visit Loaded for pet: " + pet.getName() + " ...");

        Vet vet = new Vet();
        vet.setFirstName("Sam");
        vet.setLastName("Axe");
        vet.getSpecialities().add(savedRadiology);
        vetService.save(vet);

        vet = new Vet();
        vet.setFirstName("Jessie");
        vet.setLastName("Porter");
        vet.getSpecialities().add(savedSurgery);
        vetService.save(vet);

        System.out.println("Vets Loaded ...");
    }
}
