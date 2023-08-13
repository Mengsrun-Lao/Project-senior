package com.ecamsolution.controller;


import com.ecamsolution.dto.PageDto;
import com.ecamsolution.dto.PaginationDTO;
import com.ecamsolution.entity.Starbucks;
import com.ecamsolution.service.StarbuckService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/starbucks")
public class StarbuckController {


    private final StarbuckService starbuckService;

    @PostMapping
    public ResponseEntity<?> createStarbuck(@RequestBody Starbucks starbucks){

        Starbucks starbuck = starbuckService.create(starbucks);
        return ResponseEntity.ok().body(starbuck);
    }


//    http://localhost:8080/api/starbucks?_page=1&_limit=3
    @GetMapping
    public ResponseEntity<?> getAllByPage(@RequestParam Map<String,String> param){

        Page<Starbucks> allByPage = starbuckService.getAllByPage(param);
        PageDto dto = new PageDto(allByPage);
        return ResponseEntity.ok(dto);

    }

    @PutMapping
    public ResponseEntity<?> udpateProduct(@RequestBody Starbucks newPro){
        starbuckService.updateProduct(newPro);
        return ResponseEntity.ok().body("Update Product Successfully");
    }


    @DeleteMapping("{id}")
    public ResponseEntity<?> deleteProduct(@RequestParam Long id){

        starbuckService.deleteProduct(id);
        return ResponseEntity.ok().body("Delete Product Successfully");
    }








}
