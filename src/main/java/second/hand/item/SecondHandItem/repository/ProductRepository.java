package second.hand.item.SecondHandItem.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import second.hand.item.SecondHandItem.model.ProductModel;
import second.hand.item.SecondHandItem.model.UserModel;

import java.util.List;

@Repository
public interface ProductRepository extends MongoRepository<ProductModel,String> {
    ProductModel findByProductId(String id);
    List<ProductModel> findByCategory(String category);
    List<ProductModel> findByModelOrBrandOrCategoryOrOwnYearOrCost(String product);
}
