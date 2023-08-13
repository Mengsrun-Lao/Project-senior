package com.ecamsolution.dto;


import lombok.Data;
import org.springframework.data.domain.Page;

import java.util.List;

@Data
public class PageDto {

    private List<?> list;
    private PaginationDTO paginationDTO;

    public  PageDto(Page<?> page){
        this.list =  page.getContent();
        this.paginationDTO = PaginationDTO.builder()
                .empty(page.isEmpty())
                .first(page.isFirst())
                .last(page.isLast())
                .pageSize(page.getPageable().getPageSize())
                .pageNumber(page.getPageable().getPageNumber()+1)
                .totalPages(page.getTotalPages())
                .totalElements(page.getTotalElements())
                .numberOfElements(page.getNumberOfElements())
                .build();
    }

}

