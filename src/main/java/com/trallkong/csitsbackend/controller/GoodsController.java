package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Goods;
import com.trallkong.csitsbackend.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    // 获取商品
    @GetMapping("/{id}")
    public ResponseEntity<Goods> getGoodsById(@PathVariable Long id) {
        Goods goods = goodsService.getGoodsById(id);
        return ResponseEntity.ok(goods);
    }

    // 添加商品
    @PostMapping
    public ResponseEntity<Goods> addGoods(@RequestBody Goods goods) {
        Goods newGoods = goodsService.addGoods(goods);
        return ResponseEntity.ok(newGoods);
    }

    // 删除商品
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoods(@PathVariable Long id) {
        goodsService.deleteGoods(id);
        return ResponseEntity.ok(null);
    }

    // 修改商品信息
    @PutMapping("/{id}")
    public ResponseEntity<Goods> updateGoods(@PathVariable Long id, @RequestBody Goods goods) {
        Goods updatedGoods = goodsService.updateGoods(id, goods);
        return ResponseEntity.ok(updatedGoods);
    }
}
