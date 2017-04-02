package org.planeat.core.db;

import org.planeat.core.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ProductRepository extends CrudRepository<Product, Long> {
}
