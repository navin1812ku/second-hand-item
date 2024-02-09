package second.hand.item.SecondHandItem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import second.hand.item.SecondHandItem.model.ProductModel;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,String> {
    ProductModel findByProductId(String id);
    List<ProductModel> findByCategory(String category);
}
