package com.chirkov.utils.validation;

import com.chirkov.model.Issue;
import com.chirkov.service.IssueService;
import com.chirkov.utils.customAbstract.services.CustomServices;
import com.chirkov.utils.customAbstract.validator.CustomValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class MyValidation implements CustomValidator<Issue, CustomServices<Issue, Long, JpaRepository<Issue, Long>>> {

    private final CustomServices<Issue, Long, JpaRepository<Issue, Long>> customServices;

    @Autowired
    public MyValidation(IssueService customServices) {
        this.customServices = customServices;
    }

    /**
     * @return
     */
    @Override
    public CustomServices<Issue, Long, JpaRepository<Issue, Long>> service() {
        return customServices;
    }


    /**
     * Can this {@link Validator} {@link #validate(Object, Errors) validate}
     * instances of the supplied {@code clazz}?
     * <p>This method is <i>typically</i> implemented like so:
     * <pre class="code">return Foo.class.isAssignableFrom(clazz);</pre>
     * (Where {@code Foo} is the class (or superclass) of the actual
     * object instance that is to be {@link #validate(Object, Errors) validated}.)
     *
     * @param clazz the {@link Class} that this {@link Validator} is
     *              being asked if it can {@link #validate(Object, Errors) validate}
     * @return {@code true} if this {@link Validator} can indeed
     * {@link #validate(Object, Errors) validate} instances of the
     * supplied {@code clazz}
     */
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(Issue.class);
    }

    /**
     * Validate the given {@code target} object which must be of a
     * {@link Class} for which the {@link #supports(Class)} method
     * typically has returned (or would return) {@code true}.
     * <p>The supplied {@link Errors errors} instance can be used to report
     * any resulting validation errors, typically as part of a larger
     * binding process which this validator is meant to participate in.
     * Binding errors have typically been pre-registered with the
     * {@link Errors errors} instance before this invocation already.
     *
     * @param target the object that is to be validated
     * @param errors contextual state about the validation process
     * @see ValidationUtils
     */
    @Override
    public void validate(Object target, Errors errors) {
            Issue issue = (Issue) target;
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "title", "title.empty","title.empty.message");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "description", "description.empty","description.empty.message");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userId", "userId.empty","userId.empty.message");
            ValidationUtils.rejectIfEmptyOrWhitespace(errors, "bookId", "bookId.empty","bookId.empty.message");
            if (service().getById(issue.getId()) == null) {
                errors.rejectValue("id", "id.issue","issue already is exists");
            }
    }
}
