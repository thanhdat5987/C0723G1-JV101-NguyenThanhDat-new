package com.example.product_management.repository;
import com.example.product_management.model.Product;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
private static final String SELECT_BY_NAME = "select p from Product p where p.name like :name";
    @PersistenceContext
    private EntityManager entityManager;
    @Override
    public List<Product> findAll() {
        List<Product> productList = new ArrayList<>();
        TypedQuery<Product> query = entityManager.createQuery("select p from Product p", Product.class);
        productList = query.getResultList();
        return productList;
    }
    @Transactional
    @Override
    public void save(Product product) {
        entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }
    @Transactional
    @Override
    public void update(Product product) {
        Product editingProduct = findById(product.getId());
        editingProduct.setName(product.getName());
        editingProduct.setPrice(product.getPrice());
        editingProduct.setDescription(product.getDescription());
        entityManager.merge(editingProduct);
    }
    @Transactional
    @Override
    public void remove(int id) {
        Product product = findById(id);
        entityManager.remove(product);
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> productList = new ArrayList<>();
        TypedQuery<Product> query = entityManager.createQuery(SELECT_BY_NAME, Product.class);
        query.setParameter("name", "%"+name+"%");
        productList = query.getResultList();
        return productList;
    }
}
