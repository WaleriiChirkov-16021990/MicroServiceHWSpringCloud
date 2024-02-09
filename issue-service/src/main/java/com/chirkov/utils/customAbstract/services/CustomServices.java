package com.chirkov.utils.customAbstract.services;

import com.chirkov.utils.customAbstract.models.CustomEntityInterface;
import com.chirkov.utils.customException.BadRequestAbstract;
import com.chirkov.utils.customException.NotFoundAbstract;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
//@Service
@Transactional(readOnly = true,
        propagation = Propagation.REQUIRED,
        rollbackFor = BadRequestAbstract.class)
public interface CustomServices<T extends CustomEntityInterface<I>, I extends Number, R extends JpaRepository<T, I>> {
    R getRepo();

    default T getById(I id) {
        return getRepo().findById(id).orElseThrow(() -> new NotFoundAbstract("Not found entity with id: " + id));
    }

    default List<T> getAll() {
        return getRepo().findAll();
    }

    @Transactional
    default void create(T t) {
        getRepo().save(t);
    }

    @Transactional
    default void update(I id, T t) {
        t.setId(id);
        getRepo().save(t);
    }

    @Transactional
    default void delete(I id) {
        getRepo().deleteById(id);
    }
}
