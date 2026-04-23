
package org.shopsphere.shopsphere.controller;

import org.shopsphere.shopsphere.entity.Product;
import org.shopsphere.shopsphere.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
        import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAll() {
        return ResponseEntity.ok(
                productService.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(
            @PathVariable Long id) {
        return ResponseEntity.ok(
                productService.getProductById(id));
    }

    @GetMapping("/search")
    public ResponseEntity<List<Product>> search(
            @RequestParam String name) {
        return ResponseEntity.ok(
                productService.searchProducts(name));
    }

    @GetMapping("/category")
    public ResponseEntity<List<Product>> getByCategory(
            @RequestParam String category) {
        return ResponseEntity.ok(
                productService.getByCategory(category));
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(
            @RequestBody Product product) {
        return ResponseEntity.ok(
                productService.addProduct(product));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Product> updateProduct(
            @PathVariable Long id,
            @RequestBody Product product) {
        return ResponseEntity.ok(
                productService.updateProduct(
                        id, product));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteProduct(
            @PathVariable Long id) {
        productService.deleteProduct(id);
        return ResponseEntity.ok(
                "Product deleted successfully!");
    }
}
