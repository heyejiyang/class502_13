package org.boardTest.board.validators;

import lombok.RequiredArgsConstructor;
import org.boardTest.board.controllers.RequestBoard;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Controller
@RequiredArgsConstructor
public class BoardValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(RequestBoard.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        if(errors.hasErrors()){
            return;
        }
    }
}
