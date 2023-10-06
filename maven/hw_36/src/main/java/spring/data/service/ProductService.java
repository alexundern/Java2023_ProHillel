package spring.data.service;

import spring.data.dto.ProductDto;
import spring.data.entity.Product;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface ProductService {
    List<Product> getProducts();

    Product getProductById(Long id);

    Page<Product> getProductsPage(Pageable pageable);

    Long addProduct(ProductDto productDto);
}
