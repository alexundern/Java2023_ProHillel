package hw_35.controller;

import hw_35.dto.ProductDto;
import hw_35.entity.Product;
import hw_35.service.ProductService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@Slf4j
public class ProductController {
    private final ProductService productService;
    private static final Logger logger = LoggerFactory.getLogger("logger");

    @PostMapping("")
    public Integer addNewProduct(@RequestBody ProductDto product){
        logger.info("ProductController - Run method add new product...");
        return productService.addProduct(product);
    }
    @GetMapping("/all")
    public List<Product> getProducts() {
        logger.info("ProductController - Run method get all Products...");
        return productService.getProducts();
    }
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Integer id) {
        logger.info("ProductController - Run method get product by id");
        return productService.getProductById(id);
    }
    @PutMapping("/update")
    public Product updateProductController(@RequestBody Product product){
        logger.info("ProductController - Run method update product...");
        return productService.updateProduct(product);
    }
}