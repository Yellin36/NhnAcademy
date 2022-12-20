package com.nhnacademy.office.repository.household_movement_address;

import com.nhnacademy.office.config.RootConfig;
import com.nhnacademy.office.config.WebConfig;
import com.nhnacademy.office.domain.household_movement_address.HouseholdMovementAddressDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@WebAppConfiguration
@Transactional
@ContextHierarchy({
        @ContextConfiguration(classes = RootConfig.class),
        @ContextConfiguration(classes = WebConfig.class)
})
class HouseholdMovementAddressRepositoryTest {

    @Autowired
    HouseholdMovementAddressRepository householdMovementAddressRepository;

    @Test
    void getByHouseholdSerialNumber() {
        List<HouseholdMovementAddressDto> address = householdMovementAddressRepository.getByHouseholdSerialNumber(1L);
        address.stream().forEach(System.out::println);
    }
}