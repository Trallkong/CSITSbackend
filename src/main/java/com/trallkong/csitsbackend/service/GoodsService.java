package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Goods;
import com.trallkong.csitsbackend.repository.GoodsRepository;
import com.trallkong.csitsbackend.repository.GtypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    @Autowired
    private GtypeRepository gtypeRepository;

    // 通过 id 获取商品
    public Goods getGoodsById(Long id) {
        try {
            return goodsRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("GoodsService-获取商品失败", e);
            throw new RuntimeException(e);
        }
    }

    // 添加商品
    public Goods addGoods(Goods goods) {
        try {
            return goodsRepository.save(goods);
        } catch (Exception e) {
            log.error("GoodsService-添加商品失败", e);
            throw new RuntimeException(e);
        }
    }

    // 删除商品
    public void deleteGoods(Long id) {
        try {
            goodsRepository.deleteById(id);
        } catch (Exception e) {
            log.error("GoodsService-删除商品失败", e);
            throw new RuntimeException(e);
        }
    }

    // 修改商品信息
    public Goods updateGoods(Long id, Goods goods) {
        try {
            Goods oldGoods = goodsRepository.findById(id).orElse(null);
            if (oldGoods == null) {
                return null;
            }
            oldGoods.setGname(goods.getGname());
            oldGoods.setGtypeId(goods.getGtypeId());
            oldGoods.setDon(goods.getDon());
            oldGoods.setPrice(goods.getPrice());
            oldGoods.setImagePath(goods.getImagePath());
            oldGoods.setRemark(goods.getRemark());
            oldGoods.setSellerId(goods.getSellerId());
            return goodsRepository.save(oldGoods);
        } catch (Exception e) {
            log.error("GoodsService-修改商品信息失败", e);
            throw new RuntimeException(e);
        }
    }
}
