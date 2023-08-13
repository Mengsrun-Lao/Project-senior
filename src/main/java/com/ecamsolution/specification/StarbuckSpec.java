package com.ecamsolution.specification;

import com.ecamsolution.entity.Starbucks;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;


@Data
public class StarbuckSpec implements Specification<Starbucks> {

    private final StarbuckFilter filter;
    private List<Predicate> predicates = new ArrayList<>();

    @Override
    public Predicate toPredicate(Root<Starbucks> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

        if(filter.getId() !=null){
            Predicate id = root.get("id").in(filter.getId());
            predicates.add(id);
        }

        if(filter.getCoffeType() !=null){
            Predicate coffeType = cb.like(cb.upper(root.get("coffeType")), "%" + filter.getCoffeType().toUpperCase() + "%");
            predicates.add(coffeType);
        }
        return cb.and(predicates.toArray(Predicate[]::new));

    }
}
