package com.ruoyi.web.controller.work;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.work.admin.StorageArea;
import com.ruoyi.work.service.StorageAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/work/storageArea")
public class StorageAreaController extends BaseController {
    @Autowired
    private StorageAreaService areaService;

    @GetMapping(value = "/list")
    public List<StorageArea> list(StorageArea area) {
        return areaService.areList(area);
    }
    @PostMapping(value = "/add")
    public int add(@RequestBody StorageArea area) {
        return areaService.add(area);
    }
    @PostMapping(value = "/update")
    public int update(@RequestBody StorageArea area) {
        return areaService.update(area);
    }

    @DeleteMapping("/del")
    public int delete(Long[] ids) {
        return areaService.del(ids);
    }
}
