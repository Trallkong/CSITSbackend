package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Gtype;
import com.trallkong.csitsbackend.repository.GtypeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GtypeService {

    @Autowired
    private GtypeRepository gtypeRepository;

    // 获取商品类型
    public Gtype getGtypeById(Short id) {
        try {
            return gtypeRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("GtypeService-获取商品类型失败");
            throw new RuntimeException(e);
        }
    }

    // 获取商品类型
    public Gtype getGtypeByName(String name) {
        try {
            return gtypeRepository.findByTypeName(name);
        } catch (Exception e) {
            log.error("GtypeService-获取商品类型失败");
            throw new RuntimeException(e);
        }
    }

    // 添加商品类型
    public Gtype addGtype(Gtype gtype) {
        try {
            return gtypeRepository.save(gtype);
        } catch (Exception e) {
            log.error("GtypeService-添加商品类型失败");
            throw new RuntimeException(e);
        }
    }

    public Gtype getGtypeByTno(String tno) {
        try {
            return gtypeRepository.findByTno(tno);
        } catch (Exception e) {
            log.error("GtypeService-获取商品类型失败");
            throw new RuntimeException(e);
        }
    }
}
