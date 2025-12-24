package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Gtype;
import com.trallkong.csitsbackend.service.GtypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gtype")
public class GtypeController {

    @Autowired
    private GtypeService gtypeService;

    // 通过 id 获取商品类型
    @GetMapping("{id}")
    public ResponseEntity<Gtype> getGtypeById(@PathVariable Short id) {
        Gtype gtype = gtypeService.getGtypeById(id);
        return ResponseEntity.ok(gtype);
    }

    // 通过 name 获取商品类型
    @GetMapping("{name}")
    public ResponseEntity<Gtype> getGtypeByName(@PathVariable String name) {
        Gtype gtype = gtypeService.getGtypeByName(name);
        return ResponseEntity.ok(gtype);
    }

    // 创建商品类型
    @PostMapping
    public ResponseEntity<Gtype> createGtype(Gtype gtype) {
        Gtype createdGtype = gtypeService.addGtype(gtype);
        return ResponseEntity.ok(createdGtype);
    }
}
