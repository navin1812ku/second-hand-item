package second.hand.item.SecondHandItem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import second.hand.item.SecondHandItem.model.ProductModel;
import second.hand.item.SecondHandItem.model.request.ProductCreationRequest;
import second.hand.item.SecondHandItem.model.response.Response;
import second.hand.item.SecondHandItem.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/new_one/{e-mail}")
    ResponseEntity<Response> productCreation(@PathVariable String e_mail, @RequestBody ProductCreationRequest productCreationRequest){
        return new ResponseEntity<Response>(productService.addProduct(e_mail,productCreationRequest), HttpStatus.CREATED);
    }

    @GetMapping("/all_products")
    ResponseEntity<List<ProductModel>> allProducts(){
        return new ResponseEntity<>(productService.findAll(),HttpStatus.OK);
    }

    @GetMapping("/products_category/{category}")
    ResponseEntity<List<ProductModel>> productsByCategory(@PathVariable String category){
        return new ResponseEntity<>(productService.getByCategory(category),HttpStatus.PROCESSING);
    }

    @GetMapping("/products/{product}")
    ResponseEntity<List<ProductModel>> products(@PathVariable String product){
        return new ResponseEntity<>(productService.getByProducts(product),HttpStatus.OK);
    }

    @DeleteMapping("/delete_product/{id}")
    ResponseEntity<Response> productDeletion(@PathVariable String id){
        return new ResponseEntity<>(productService.removeProduct(id),HttpStatus.ACCEPTED);
    }
}