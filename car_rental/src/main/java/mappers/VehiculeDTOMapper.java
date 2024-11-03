package mappers;

import DTO.VehiculeDTO;
import entities.Vehicule;

public class VehiculeMapper {

    public VehiculeDTO mapToDTO(Vehicule vehicule) {
        VehiculeDTO vehiculeDTO = new VehiculeDTO();
        vehiculeDTO.setVehiculeStatus(vehicule.getVehiculeStatus());
        vehiculeDTO.setNameVehicule(vehicule.getNameVehicule());
        vehiculeDTO.setTransmission(vehicule.getTransmission());
        vehiculeDTO.setBrand(vehicule.getBrand());
        vehiculeDTO.setColor(vehicule.getColor());
        vehiculeDTO.setPrice(vehicule.getPrice());
        vehiculeDTO.setIdVehicule(vehicule.getIdVehicule());
        vehiculeDTO.setHighSpeed(vehicule.getHighSpeed());
        return vehiculeDTO;
    }
}
