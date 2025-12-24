package com.trallkong.csitsbackend.service;

import com.trallkong.csitsbackend.entity.Gstate;
import com.trallkong.csitsbackend.repository.GstateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class GstateService {

    @Autowired
    private GstateRepository gstateRepository;

    // 通过 id 获取商品状态
    public Gstate getGstateById(Long id) {
        try {
            return gstateRepository.findById(id).orElse(null);
        } catch (Exception e) {
            log.error("GstateService-获取商品状态失败");
            throw new RuntimeException(e);
        }
    }

    // 添加商品状态
    public Gstate addGstate(Gstate gstate) {
        try {
            return gstateRepository.save(gstate);
        } catch (Exception e) {
            log.error("GstateService-添加商品状态失败");
            throw new RuntimeException(e);
        }
    }

    // 删除商品状态
    public void deleteGstate(Long id) {
        try {
            gstateRepository.deleteById(id);
        } catch (Exception e) {
            log.error("GstateService-删除商品状态失败");
            throw new RuntimeException(e);
        }
    }

    // 修改商品状态
    public Gstate updateGstate(Long id, Gstate gstate) {
        try {
            Gstate oldGstate = gstateRepository.findById(id).orElse(null);
            if (oldGstate == null) {
                return null;
            }
            oldGstate.setState(gstate.getState());
            return gstateRepository.save(oldGstate);
        } catch (Exception e) {
            log.error("GstateService-修改商品状态失败");
            throw new RuntimeException(e);
        }
    }
}
