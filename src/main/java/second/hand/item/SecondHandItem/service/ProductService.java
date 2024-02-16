package second.hand.item.SecondHandItem.service;

import org.springframework.stereotype.Service;
import second.hand.item.SecondHandItem.model.ProductModel;
import second.hand.item.SecondHandItem.model.request.ProductCreationRequest;
import second.hand.item.SecondHandItem.model.request.ProductUpdateRequest;
import second.hand.item.SecondHandItem.model.response.Response;

import java.util.List;

public interface ProductService {
    Response addProduct(String e_mail, ProductCreationRequest productCreationRequest);
    List<ProductModel> findAll();
    List<ProductModel> getByCategory(String category);
    List<ProductModel> searchByProduct(String product);
    Response removeProduct(String id);
    Response updateProduct( String id, ProductUpdateRequest productUpdateRequest);
}
