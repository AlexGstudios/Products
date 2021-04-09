package Alexander.demo.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import Alexander.demo.Model.Entity.ProductEntity;

import java.util.Optional;

@Repository
public interface ProductRepo extends CrudRepository<ProductEntity, Long> {
    

    Optional<ProductEntity> findByProductId(String productId);
}
