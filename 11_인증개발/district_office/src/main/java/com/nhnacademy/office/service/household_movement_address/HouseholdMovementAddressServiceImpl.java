package com.nhnacademy.office.service.household_movement_address;

import com.nhnacademy.office.domain.household_movement_address.HouseholdMovementAddressModifyRequest;
import com.nhnacademy.office.domain.household_movement_address.HouseholdMovementAddressRegisterRequest;
import com.nhnacademy.office.entity.Household;
import com.nhnacademy.office.entity.HouseholdMovementAddress;
import com.nhnacademy.office.exception.AlreadyRegisteredException;
import com.nhnacademy.office.exception.NotFoundException;
import com.nhnacademy.office.repository.household.HouseholdRepository;
import com.nhnacademy.office.repository.household_movement_address.HouseholdMovementAddressRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HouseholdMovementAddressServiceImpl implements HouseholdMovementAddressService {
    private final HouseholdMovementAddressRepository householdMovementAddressRepository;

    private final HouseholdRepository householdRepository;

    public HouseholdMovementAddressServiceImpl(HouseholdMovementAddressRepository householdMovementAddressRepository, HouseholdRepository householdRepository) {
        this.householdMovementAddressRepository = householdMovementAddressRepository;
        this.householdRepository = householdRepository;
    }

    @Override
    public HouseholdMovementAddress registerHouseholdMovementAddress(Long householdSerialNumber, HouseholdMovementAddressRegisterRequest request) {
        HouseholdMovementAddress.Pk pk = getHouseholdMovementAddressPk(householdSerialNumber, request);

        Household household = householdRepository.findByHouseholdSerialNumber(householdSerialNumber)
                .orElseThrow(() -> new NotFoundException(Household.class, householdSerialNumber));

        HouseholdMovementAddress householdMovementAddress = new HouseholdMovementAddress();

        householdMovementAddress.setPk(pk);
        householdMovementAddress.setHouseMovementAddress(request.getAddress());
        householdMovementAddress.setLastAddressYn(request.getLastAddressYn());
        householdMovementAddress.setHousehold(household);

        return householdMovementAddressRepository.save(householdMovementAddress);
    }

    @Override
    public void updateHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDate, HouseholdMovementAddressModifyRequest request) {
        HouseholdMovementAddress.Pk pk = getExistHouseholdMovementAddressPk(householdSerialNumber, reportDate);

        householdMovementAddressRepository.updateLastAddressYnByPk(pk, request.getLastAddressYn());
    }

    @Override
    public void deleteHouseholdMovementAddress(Long householdSerialNumber, LocalDate reportDate) {
        HouseholdMovementAddress.Pk pk = getExistHouseholdMovementAddressPk(householdSerialNumber, reportDate);

        householdMovementAddressRepository.deleteByPk(pk);
    }

    private HouseholdMovementAddress.Pk getHouseholdMovementAddressPk(Long householdSerialNumber, HouseholdMovementAddressRegisterRequest request) {
        HouseholdMovementAddress.Pk pk = new HouseholdMovementAddress.Pk(householdSerialNumber, request.getReportDate());

        if(householdMovementAddressRepository.existsByPk(pk)) {
            throw new AlreadyRegisteredException(HouseholdMovementAddress.class, pk);
        }
        return pk;
    }

    private HouseholdMovementAddress.Pk getExistHouseholdMovementAddressPk(Long householdSerialNumber, LocalDate reportDate) {
        HouseholdMovementAddress.Pk pk = new HouseholdMovementAddress.Pk(householdSerialNumber, reportDate);

        if(!householdMovementAddressRepository.existsByPk(pk)) {
            throw new NotFoundException(HouseholdMovementAddress.class, pk);
        }
        return pk;
    }
}
