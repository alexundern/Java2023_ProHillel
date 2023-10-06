package hw_35.service.impl;

import hw_35.dto.ProductDto;
import hw_35.entity.Product;
import hw_35.exception.ProductNotFoundException;
import hw_35.repository.ProductRepository;
import hw_35.service.ProductService;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    @Override
    public Integer addProduct(ProductDto productDto) {
        Product product = new Product()
                .setName(productDto.getName())
                .setCost(productDto.getCost());
        return productRepository.save(product).getId();
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id)
                .orElseThrow(() -> {
                            return new ProductNotFoundException("PRODUCT NOT FOUND");
                        }
                );
    }

    @Override
    public Product updateProduct(Product product) {
        return productRepository.save(product);
    }
}
