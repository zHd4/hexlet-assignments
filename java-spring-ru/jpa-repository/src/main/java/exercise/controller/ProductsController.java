package exercise.controller;

import exercise.exception.ResourceNotFoundException;
import exercise.model.Product;
import exercise.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductsController {

    @Autowired
    private ProductRepository productRepository;

    // BEGIN
    @GetMapping
    public List<Product> index(@RequestParam Optional<Integer> min, @RequestParam Optional<Integer> max) {
        Sort sort = Sort.by(Sort.Order.asc("price"));

        if (min.isPresent() && max.isPresent()) {
            return productRepository.findByPriceBetween(min.get(), max.get(), sort);
        } else {
            if (min.isPresent()) {
                return productRepository.findByPriceGreaterThan(min.get(), sort);
            } else if (max.isPresent()) {
                return productRepository.findByPriceLessThan(max.get(), sort);
            }
        }

        return productRepository.findAll(sort);
    }
    // END

    @GetMapping(path = "/{id}")
    public Product show(@PathVariable long id) {

        var product =  productRepository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Product with id " + id + " not found"));

        return product;
    }
}
