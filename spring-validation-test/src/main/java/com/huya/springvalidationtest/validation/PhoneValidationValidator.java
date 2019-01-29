package com.huya.springvalidationtest.validation;


import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: licg
 * @Date: 2019/1/28
 * @Description：手机号校验类
 */
public class PhoneValidationValidator implements ConstraintValidator<PhoneValidation, String> {
    private static final Pattern PHONE_PATTERN = Pattern.compile(
            "^((13[0-9])|(15[^4])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$"
    );

    @Override
    public void initialize(PhoneValidation constraintAnnotation) {

    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        Matcher matcher = PHONE_PATTERN.matcher(s);
        return matcher.matches();
    }
}