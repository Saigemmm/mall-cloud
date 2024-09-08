package org.sellers.mall.storage.controller;

import org.sellers.mall.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/storage")
public class InternalStorageController {
    @Autowired
    private StorageService storageService;

    @PostMapping("/getStorageByProductId")
    public Integer getStorageByProductId(Integer productId) {
        return storageService.getStorageByProductId(productId);
    }
}
