package com.trallkong.csitsbackend.controller;

import com.trallkong.csitsbackend.entity.Gstate;
import com.trallkong.csitsbackend.service.GstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gstate")
public class GstateController {

    @Autowired
    private GstateService gstateService;

    // 获取所有状态
    @GetMapping("/{id}")
    public ResponseEntity<Gstate> getGstateById(@PathVariable Long id) {
        Gstate gstate = gstateService.getGstateById(id);
        return ResponseEntity.ok(gstate);
    }

    // 添加状态
    @PostMapping
    public ResponseEntity<Gstate> addGstate(@RequestBody Gstate gstate) {
        Gstate newGstate = gstateService.addGstate(gstate);
        return ResponseEntity.ok(newGstate);
    }

    // 删除状态
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGstate(@PathVariable Long id) {
        gstateService.deleteGstate(id);
        return ResponseEntity.ok(null);
    }

    // 修改状态信息
    @PutMapping("/{id}")
    public ResponseEntity<Gstate> updateGstate(@PathVariable Long id, @RequestBody Gstate gstate) {
        Gstate updatedGstate = gstateService.updateGstate(id, gstate);
        return ResponseEntity.ok(updatedGstate);
    }
}
