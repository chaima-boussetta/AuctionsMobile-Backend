package com.example.demo.Repository;

import com.example.demo.Model.Purchase;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PurchaseRepository extends CrudRepository<Purchase, String> {
    public List<Purchase> findBySellerUsername (String username);
    public List<Purchase> findByBuyerUsername (String username);
    public List<Purchase> findByPurchaseDate (String username);
}
