package second.hand.item.SecondHandItem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import second.hand.item.SecondHandItem.model.ProductModel;
import second.hand.item.SecondHandItem.model.request.ProductCreationRequest;
import second.hand.item.SecondHandItem.model.request.ProductUpdateRequest;
import second.hand.item.SecondHandItem.model.response.Response;
import second.hand.item.SecondHandItem.service.ProductService;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("/newOne/{e_mail}")
    public ResponseEntity<Object> productCreation(@PathVariable String e_mail, @RequestBody ProductCreationRequest productCreationRequest){
        return new ResponseEntity<>(productService.addProduct(e_mail,productCreationRequest), HttpStatus.CREATED);
    }

    @GetMapping("/set")
    public ResponseEntity<List<ProductModel>> allProducts(){
        return new ResponseEntity<>(productService.findAll(),HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Object> productUpdate(@PathVariable String id, @RequestBody ProductUpdateRequest productUpdateRequest){
        return new ResponseEntity<>(productService.updateProduct(id,productUpdateRequest),HttpStatus.OK);
    }

    @GetMapping("/productsCategory/{category}")
    public ResponseEntity<List<ProductModel>> productsByCategory(@PathVariable String category){
        return new ResponseEntity<>(productService.getByCategory(category),HttpStatus.PROCESSING);
    }

    @GetMapping("/products/{product}")
    public ResponseEntity<List<ProductModel>> searchByProduct(@PathVariable String product){
        return new ResponseEntity<>(productService.searchByProduct(product),HttpStatus.PROCESSING);
    }

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<Response> productDeletion(@PathVariable String id){
        return new ResponseEntity<>(productService.removeProduct(id),HttpStatus.ACCEPTED);
    }
}
