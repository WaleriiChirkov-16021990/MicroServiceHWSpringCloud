package com.chirkov.utils.customAbstract.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;

@Component
public interface CustomValidator<T,S>  extends Validator {
     S service();
}
