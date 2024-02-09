package com.chirkov.api.controllers;

import com.chirkov.model.Issue;
import com.chirkov.service.IssueService;
import com.chirkov.utils.customAbstract.controllers.CustomControllers;
import com.chirkov.utils.customAbstract.services.CustomServices;
import com.chirkov.utils.customAbstract.validator.CustomValidator;
import com.chirkov.utils.validation.MyValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/issues")
public class IssueController implements CustomControllers<Issue,
        Long,
        CustomServices<Issue, Long, JpaRepository<Issue, Long>>,
        CustomValidator<Issue, CustomServices<Issue, Long, JpaRepository<Issue, Long>>>> {
    private final CustomServices<Issue, Long, JpaRepository<Issue, Long>> customServices;
    private final CustomValidator<Issue, CustomServices<Issue, Long, JpaRepository<Issue, Long>>> customValidator;

    @Autowired
    public IssueController(IssueService customServices,
                           MyValidation customValidator) {
        this.customServices = customServices;
        this.customValidator = customValidator;
    }

    /**
     * @return the custom service
     */
    @Override
    public CustomServices<Issue, Long, JpaRepository<Issue, Long>> service() {
        return this.customServices;
    }

    /**
     * @return the custom validator
     */
    @Override
//    @Bean
    public CustomValidator<Issue, CustomServices<Issue, Long, JpaRepository<Issue, Long>>> validator() {
        return this.customValidator;
    }
}
