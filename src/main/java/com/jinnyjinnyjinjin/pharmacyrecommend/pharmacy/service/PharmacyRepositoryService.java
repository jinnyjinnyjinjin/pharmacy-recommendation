package com.jinnyjinnyjinjin.pharmacyrecommend.pharmacy.service;

import com.jinnyjinnyjinjin.pharmacyrecommend.pharmacy.entity.Pharmacy;
import com.jinnyjinnyjinjin.pharmacyrecommend.pharmacy.repository.PharmacyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ObjectUtils;

@Slf4j
@Service
@RequiredArgsConstructor
public class PharmacyRepositoryService {

    private final PharmacyRepository pharmacyRepository;

    @Transactional
    public void updateAddress(Long id, String address) {
        Pharmacy entity = pharmacyRepository.findById(id).orElse(null);

        if (ObjectUtils.isEmpty(entity)) {
            log.error("[PharmacyRepositoryService updateAddress] not found id: {}", id);
            return;
        }
        entity.changePharmacyAddress(address);
    }

    public void updateAddressWithoutTransaction(Long id, String address) {
        Pharmacy entity = pharmacyRepository.findById(id).orElse(null);

        if (ObjectUtils.isEmpty(entity)) {
            log.error("[PharmacyRepositoryService updateAddress] not found id: {}", id);
            return;
        }
        entity.changePharmacyAddress(address);
    }

}
