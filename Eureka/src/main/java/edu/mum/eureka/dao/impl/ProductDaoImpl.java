package edu.mum.eureka.dao.impl;


import edu.mum.eureka.dao.ProductDao;
import edu.mum.eureka.domain.Product;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductDaoImpl extends GenericDaoImpl<Product> implements ProductDao {

    public ProductDaoImpl() {
        super.setDaoType(Product.class);
    }

    public List<Product> findProductByCriteria(String name, String description, double minPrice, double maxPrice) {

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        // Typed query - expected results are of the type Member
        CriteriaQuery<Product> query = criteriaBuilder.createQuery(Product.class);
        // From part of the clause
        Root<Product> productRood = query.from(Product.class);
        // The Select
        query.select(productRood);

        List<Predicate> predicateList = new ArrayList<Predicate>();

        // if product name is LIKE passed parameter 'name'
        if ((name != null) && (!(name.isEmpty()))) {
            Predicate namePredicate =
                    criteriaBuilder.like(
                            criteriaBuilder.upper(productRood.get("name")), "%" + name.toUpperCase() + "%");
            predicateList.add(namePredicate);
        }

        // if product description is LIKE passed parameter
        if ((description != null) && (!(description.isEmpty()))) {
            Predicate descriptionPredicate =
                    criteriaBuilder.like(
                            criteriaBuilder.upper(productRood.get("description")), "%" + description.toUpperCase() + "%");
            predicateList.add(descriptionPredicate);
        }

        if (minPrice < maxPrice) {
            // if product price > minPrice
            Predicate minPricePredicate =
                    criteriaBuilder.greaterThanOrEqualTo(productRood.get("price"), minPrice);
            predicateList.add(minPricePredicate);

            // if product price < maxPrice
            Predicate maxPricePredicate =
                    criteriaBuilder.lessThanOrEqualTo(productRood.get("price"), maxPrice);
            predicateList.add(maxPricePredicate);
        }

        Predicate[] predicates = new Predicate[predicateList.size()];
        predicateList.toArray(predicates);
        query.where(criteriaBuilder.and(predicates));

        return entityManager.createQuery(query).getResultList();
    }
}

