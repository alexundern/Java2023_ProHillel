package hw_35.service;

import hw_35.dto.ProductDto;
import hw_35.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Integer addProduct(ProductDto product);

    Product getProductById(Integer id);

    Product updateProduct(Product product);
}
