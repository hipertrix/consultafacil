package  com.consultafacil.validation.impl;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.consultafacil.dao.UserDao;
import com.consultafacil.model.User;
import com.consultafacil.validation.LoginAvailable;

public class LoginAvailableValidator
    implements ConstraintValidator<LoginAvailable, User> {
    
    @Inject
    private UserDao userDao;

    @Override
    public void initialize(LoginAvailable constraintAnnotation) {

    }

    @Override
    public boolean isValid(User user, ConstraintValidatorContext context) {
        return !userDao.containsUserWithLogin(user.getLogin());
    }
}
