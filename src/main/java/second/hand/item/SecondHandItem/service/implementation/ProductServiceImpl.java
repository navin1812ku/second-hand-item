package second.hand.item.SecondHandItem.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import second.hand.item.SecondHandItem.model.ProductModel;
import second.hand.item.SecondHandItem.model.UserModel;
import second.hand.item.SecondHandItem.model.request.ProductCreationRequest;
import second.hand.item.SecondHandItem.model.response.Response;
import second.hand.item.SecondHandItem.repository.ProductRepository;
import second.hand.item.SecondHandItem.repository.UserRepository;
import second.hand.item.SecondHandItem.service.ProductService;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    UserRepository userRepository;


    @Override
    public Response addProduct(String e_mail, ProductCreationRequest productCreationRequest) {
        UserModel userModel=userRepository.findByEmail(e_mail);
        ProductModel productModel=new ProductModel();
        String id=generateUniqueId();
        productModel.setProductId(id);
        productModel.setE_mail(e_mail);
        productModel.setSellerName(userModel.getFirstName()+" "+userModel.getLastName());
        productModel.setBrand(productCreationRequest.getBrand());
        productModel.setCategory(productCreationRequest.getCategory());
        productModel.setCost(productCreationRequest.getCost());
        productModel.setKilometer(productCreationRequest.getKilometer());
        productModel.setModel(productCreationRequest.getModel());
        productModel.setOwnYear(productCreationRequest.getOwnYear());
        productModel.setPhoneNumber(productCreationRequest.getPhoneNumber());
        productModel.setPlace(productCreationRequest.getPlace());
        productRepository.save(productModel);
        productModel=productRepository.findByProductId(id);
        Response response=new Response();
        if(productModel.equals(null)){
            response.setMessage("Something went wrong your product is not added to sale");
        }
        else{
            response.setMessage("Successfully added");
        }
        return response;
    }

    @Override
    public List<ProductModel> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<ProductModel> getByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    @Override
    public Response removeProduct(String id) {
        ProductModel productModel=productRepository.findByProductId(id);
        productRepository.delete(productModel);
        productModel=productRepository.findByProductId(id);
        Response response=new Response();
        if(productModel.equals(null)){
            response.setMessage("Successfully deleted");
        }
        else{
            response.setMessage("Something went wrong your product was not deleted");
        }
        return response;
    }

    public static String generateUniqueId() {
        long timestamp = System.currentTimeMillis();
        int random = (int) (Math.random() * 100000);
        String uniqueId = String.format("%08d", timestamp % 100000000) + String.format("%05d", random);
        return uniqueId;
    }
}
