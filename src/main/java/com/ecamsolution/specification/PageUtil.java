package com.ecamsolution.specification;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
public interface PageUtil {

    int DEFAULT_PAGE_LIMIT =5;
    int DEFAULT_PAGE_NUMBER =1;
    String PAGE_LIMIT = "_limit";
    String PAGE_NUMBER = "_page";

    static Pageable getPageable(int pageNumber, int pageLimit){
        if(pageNumber < DEFAULT_PAGE_NUMBER){
            pageNumber = DEFAULT_PAGE_NUMBER;
        }
        if(pageLimit < 1){
            pageLimit = DEFAULT_PAGE_LIMIT;
        }
        Pageable pageable = PageRequest.of(pageNumber-1, pageLimit);
        return pageable;

    }
}
