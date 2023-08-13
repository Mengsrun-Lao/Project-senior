package com.ecamsolution.service;

import com.ecamsolution.entity.Starbucks;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface StarbuckService {

    Starbucks create(Starbucks starbucks);

    Page<Starbucks> getAllByPage(Map<String,String> param);

    void updateProduct(Starbucks newPro);
    void deleteProduct(Long id);


}
