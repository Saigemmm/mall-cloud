package org.sellers.mall.storage.service.impl;

import org.sellers.mall.storage.repository.StorageRepository;
import org.sellers.mall.storage.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StorageServiceImpl implements StorageService {
    @Autowired
    private StorageRepository storageRepository;

    @Override
    public Integer getStorageByProductId(Integer productId) {
        return storageRepository.getStorageByProductId(productId);
    }
}
