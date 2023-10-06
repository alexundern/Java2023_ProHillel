package spring.data.service.impl;

import spring.data.dto.ProductDto;
import spring.data.entity.Product;
import spring.data.exceptions.ProductNotFoundException;
import spring.data.repository.ProductRepository;
import spring.data.service.ProductService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Override
    public List<Product> getProducts() {
        return repository.findAll();
    }

    @Override
    public Product getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("COULD NOT FOUND PRODUCT"));
    }

    @Override
    public Page<Product> getProductsPage(Pageable page) {
        return repository.findAll(page);
    }

    @Override
    public Long addProduct(ProductDto product) {
        Product productEntity = new Product().setName(product.getName()).setCost(product.getPrice());
        return repository.save(productEntity).getId();
    }
}
