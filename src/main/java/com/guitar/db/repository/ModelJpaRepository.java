package com.guitar.db.repository;

import com.guitar.db.model.Model;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ModelJpaRepository extends JpaRepository<Model, Long> {

    List<Model> findByPriceGreaterThanEqualAndPriceLessThanEqual(BigDecimal low, BigDecimal high);

    List<Model> findByModelTypeNameIn(List<String> modeTypeNames);

    List<Model> findByModelTypeNameNotIn(List<String> modeTypeNames);

    @Query("select m from Model m where m.price >= :lowest and m.price <= :highest and m.woodType like :wood")
    List<Model> queryByModelTypeAndWoodType(@Param("lowest") BigDecimal low,
                                            @Param("highest") BigDecimal hi,
                                            @Param("wood") String wood);

    List<Model> findAllModelsByType(@Param("name") String name);

}
