package com.apap.tutorial7.service;


import com.apap.tutorial7.model.PilotModel;
import com.apap.tutorial7.repository.PilotDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * PilotServiceImpl
 */
@Service
@Transactional
public class PilotServiceImpl implements PilotService {
    @Autowired
    private PilotDb pilotDb;

    @Override
    public PilotModel getPilotDetailByLicenseNumber(String licenseNumber) {
        return pilotDb.findByLicenseNumber(licenseNumber);
    }

    @Override
    public PilotModel addPilot(PilotModel pilot) {
        return pilotDb.save(pilot);
    }

    @Override
    public void deletePilotByLicenseNumber(String licenseNumber) {
        pilotDb.deleteByLicenseNumber(licenseNumber);
    }

    @Override
    public Optional<PilotModel> getPilotDetailById(long id) {
        return pilotDb.findById(id);
    }

    @Override
    public boolean deletePilotById(long id) {
        pilotDb.deleteById(id);
        return true;
    }

    @Override
    public PilotModel getPilotById(long id) {
        return pilotDb.getOne(id);
    }

    @Override
    public PilotModel updatePilot(PilotModel pilot) {
        PilotModel pilotToUpdate = pilotDb.getOne(pilot.getId());
        pilotToUpdate.setFlyHour(pilot.getFlyHour());
        pilotToUpdate.setLicenseNumber(pilot.getLicenseNumber());
        pilotToUpdate.setName(pilot.getName());

        pilotDb.save(pilotToUpdate);

        return pilotToUpdate;
    }
}