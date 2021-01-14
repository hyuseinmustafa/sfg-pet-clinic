package com.hyuseinmustafa.sfgpetclinic.formatters;

import com.hyuseinmustafa.sfgpetclinic.model.PetType;
import com.hyuseinmustafa.sfgpetclinic.services.PetTypeService;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Collection;
import java.util.Locale;

@Component
public class PetTypeFormatter implements Formatter<PetType> {

    private final PetTypeService petTypeService;

    public PetTypeFormatter(PetTypeService petTypeService) {
        this.petTypeService = petTypeService;
    }

    public String print(PetType petType, Locale locale){
        return petType.getName();
    }

    public PetType parse(String text, Locale locale) throws ParseException {
        Collection<PetType> findPetTypes = petTypeService.findAll();
        for (PetType petType: findPetTypes){
            if (petType.getName().equals(text)){
                return petType;
            }
        }
        throw new ParseException("type not found: " + text, 0);
    }
}
