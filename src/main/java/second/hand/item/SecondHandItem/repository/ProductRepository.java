package second.hand.item.SecondHandItem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import second.hand.item.SecondHandItem.model.ProductModel;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductModel,String> {
    @Query("SELECT a FROM ProductModel a WHERE " +
            "a.model = :product OR " +
            "a.brand = :product OR " +
            "a.category = :product OR " +
            "a.ownYear = :product OR " +
            "a.place = :product OR " +
            "a.cost = :product")
    List<ProductModel> findByProduct(@Param("product") String product);
    ProductModel findByProductId(String id);
    List<ProductModel> findByCategory(String category);
}
