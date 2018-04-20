package be.tetjes.angulartest.infrastructure;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.HashSet;
import java.util.Set;

import static java.util.stream.Collectors.toSet;
import static javax.validation.Validation.buildDefaultValidatorFactory;

public class SelsValidator {
    private static SelsValidator instance;

    public static SelsValidator validator() {
        if (instance == null) {
            instance = new SelsValidator();
        }
        return instance;
    }

    private Validator validator;

    private SelsValidator() {
        validator = buildDefaultValidatorFactory().getValidator();
    }

    public void validate(Object object) {
        Set<ConstraintViolation<Object>> violations = validator.validate(object);
        if (!violations.isEmpty()) {
            throw new ConstraintViolationException(
                    constraintViolationErrorMessage(violations),
                    new HashSet<ConstraintViolation<?>>(violations));
        }
    }

    private String constraintViolationErrorMessage(Set<ConstraintViolation<Object>> violations) {
        Set<String> violationMessages = violations.stream()
                .map(violation -> String.format("%s#%s can not have value %s because %s", violation.getRootBeanClass(), violation.getPropertyPath(), violation.getInvalidValue(), violation.getMessage()))
                .collect(toSet());
        return StringUtils.join(violationMessages, ", ");
    }
}
