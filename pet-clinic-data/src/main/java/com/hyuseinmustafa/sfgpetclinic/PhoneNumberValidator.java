package com.hyuseinmustafa.sfgpetclinic;

import org.springframework.beans.factory.annotation.Configurable;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Configurable
public class PhoneNumberValidator implements ConstraintValidator<ValidPhoneNumber, String> {

    @Override
    public boolean isValid(String phoneNo, ConstraintValidatorContext constraintValidatorContext) {
        if(phoneNo == null) return true;
        else if(phoneNo == "") return true;
        else if (phoneNo.matches("\\d{10}")) return true;
        return false;
    }
}
