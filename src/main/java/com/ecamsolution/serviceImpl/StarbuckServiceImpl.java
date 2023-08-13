package com.ecamsolution.serviceImpl;

import com.ecamsolution.entity.Starbucks;
import com.ecamsolution.repository.StarbuckRepository;
import com.ecamsolution.service.StarbuckService;
import com.ecamsolution.specification.PageUtil;
import com.ecamsolution.specification.StarbuckFilter;
import com.ecamsolution.specification.StarbuckSpec;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service
@RequiredArgsConstructor
public class StarbuckServiceImpl implements StarbuckService {

    private final StarbuckRepository starbuckRepository;

    @Override
    public Starbucks create(Starbucks starbucks) {
        return starbuckRepository.save(starbucks);
    }

    @Override
    public Page<Starbucks> getAllByPage(Map<String, String> param) {

        // TODO Block Specification
        StarbuckFilter filter = new StarbuckFilter();
        if(param.containsKey("id")){
            filter.setId(Long.parseLong(param.get("id")));
        }
        if(param.containsKey("coffeeType")){
            filter.setCoffeType(param.get("coffeeType"));
        }
        StarbuckSpec spec = new StarbuckSpec(filter);

        // TODO pagination
        int pageNumber = PageUtil.DEFAULT_PAGE_NUMBER;
        int pageLimit = PageUtil.DEFAULT_PAGE_LIMIT;

        if(param.containsKey(PageUtil.PAGE_LIMIT)){
            pageLimit = Integer.parseInt(param.get(PageUtil.PAGE_LIMIT));
        }
        if(param.containsKey(PageUtil.PAGE_NUMBER)){
            pageNumber = Integer.parseInt(param.get(PageUtil.PAGE_NUMBER));
        }
        Pageable pageable = PageUtil.getPageable(pageNumber, pageLimit);
        return starbuckRepository.findAll(spec,pageable);

    }

    @Override
    public void updateProduct(Starbucks newPro) {
        Starbucks starbucks = starbuckRepository.findById(newPro.getId()).orElseThrow(RuntimeException::new);
        newPro.setId(starbucks.getId());
        starbuckRepository.save(newPro);

    }

    @Override
    public void deleteProduct(Long id) {
        starbuckRepository.findById(id).orElseThrow(RuntimeException::new);
        starbuckRepository.deleteById(id);
    }

}
