package services;

import models.RentalContract;
import models.CrudManager;

public class RentalContractService {
    private CrudManager<RentalContract> rentalContractManager = new CrudManager<>();

    public void createRentalContract(RentalContract rentalContract) {
        rentalContractManager.create(rentalContract);
    }

    public void listAllRentalContracts() {
        rentalContractManager.readAll();
    }

    public void updateRentalContract(String contractID, RentalContract newRentalContract) {
        rentalContractManager.update(contractID, newRentalContract);
    }

    public void deleteRentalContract(String contractID) {
        rentalContractManager.delete(contractID);
    }

    public CrudManager<RentalContract> getRentalContractManager() {
        return rentalContractManager;
    }
}
