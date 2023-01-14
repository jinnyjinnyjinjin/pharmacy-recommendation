package com.jinnyjinnyjinjin.pharmacyrecommend.pharmacy.repository

import com.jinnyjinnyjinjin.pharmacyrecommend.AbstractIntegrationContainerBaseTest
import com.jinnyjinnyjinjin.pharmacyrecommend.pharmacy.entity.Pharmacy
import org.springframework.beans.factory.annotation.Autowired

import java.time.LocalDateTime

class PharmacyRepositoryTest extends AbstractIntegrationContainerBaseTest {

    @Autowired
    private PharmacyRepository pharmacyRepository

    def setup() {
        pharmacyRepository.deleteAll()
    }

    def "PharmacyRepository save"() {
        given:
        String address = "서울 특별시 성북구 종암동"
        String name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        def result = pharmacyRepository.save(pharmacy)

        then:
        result.getPharmacyAddress() == address
        result.getPharmacyName() == name
        result.getLatitude() == latitude
        result.getLongitude() == longitude
    }

    def "PharmacyRepository saveAll"() {
        given:
        String address = "서울 특별시 성북구 종암동"
        String name = "은혜 약국"
        double latitude = 36.11
        double longitude = 128.11

        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .latitude(latitude)
                .longitude(longitude)
                .build()

        when:
        pharmacyRepository.saveAll(List.of(pharmacy))
        def result = pharmacyRepository.findAll()

        then:
        result.size() == 1
    }

    def "BaseTimeEntity 등록"() {
        given:
        LocalDateTime now = LocalDateTime.now()
        String address = "서울특별시 성북구 종암동"
        String name = "은혜약국"

        when:
        def pharmacy = Pharmacy.builder()
                .pharmacyAddress(address)
                .pharmacyName(name)
                .build()

        pharmacyRepository.save(pharmacy)
        def result = pharmacyRepository.findAll()

        then:
        result.size() > 0
        result.get(0).getCreatedDate().isAfter(now)
        result.get(0).getModifiedDate().isAfter(now)
    }
}
