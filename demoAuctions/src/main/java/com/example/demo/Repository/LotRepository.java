package com.example.demo.Repository;
import com.example.demo.Model.Lot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface LotRepository extends CrudRepository<Lot, String> {

    List<Lot> findBySellerUsername(String username);
    List<Lot> findByBuyerUsername(String username);
    List<Lot> findByTopic(String topic);
    List<Lot> findByEndDate(String topic);
    Lot findById(Long Id);

    @Transactional
    Long deleteByName(String name);

    void deleteById(Long id);
}


