package com.chirkov.utils.customAbstract.controllers;

//import com.chirkov.utils.customAbstract.services.CustomServices;
//import com.chirkov.utils.customAbstract.validator.CustomValidator;

import com.chirkov.utils.customAbstract.models.CustomEntityInterface;
import com.chirkov.utils.customAbstract.services.CustomServices;
import com.chirkov.utils.customAbstract.validator.CustomValidator;
import jakarta.validation.Valid;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public interface CustomControllers<T extends CustomEntityInterface<R>,
                                    R extends Number,
                                    S extends CustomServices<T, R, JpaRepository<T, R>>,
                                    V extends CustomValidator<T, S>> {

    S service();

    V validator();

    @PostMapping
    default ResponseEntity<T> createEntity(@RequestBody @Valid T t, BindingResult errors) {
        validator().validate(t, errors);
        if (errors.hasErrors()) {
            return ResponseEntity.badRequest().body(null);
        }
        service().create(t);
        return ResponseEntity.ok(t);
    }

    @GetMapping("/{id}")
    default ResponseEntity<T> readEntity(@PathVariable R id) {
        T entity = (T) service().getById(id);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(entity);
    }

    @PutMapping("/{id}")
    default ResponseEntity<T> updateEntity(@PathVariable R id, @RequestBody @Valid T t) {

        T entity = (T) service().getById(id);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        service().update(id, t);
        return ResponseEntity.ok(t);
    }

    @DeleteMapping("/{id}")
    default ResponseEntity<HttpStatus> deleteEntity(@PathVariable R id) {
        T entity = (T) service().getById(id);
        if (entity == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        service().delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @GetMapping
    default ResponseEntity<List<T>> getAllEntities() {
        List<T> entities = service().getAll();
        return ResponseEntity.ok(entities);
    }

}
