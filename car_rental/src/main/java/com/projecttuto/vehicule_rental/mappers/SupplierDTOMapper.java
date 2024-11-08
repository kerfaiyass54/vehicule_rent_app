package com.projecttuto.vehicule_rental.mappers;

import com.projecttuto.vehicule_rental.DTO.SupplierDTO;
import com.projecttuto.vehicule_rental.entities.Supplier;

public class SupplierDTOMapper {

    public SupplierDTO supplierDTOMapper(Supplier supplier) {
        SupplierDTO supplierDTO = new SupplierDTO();
        supplierDTO.setSuppName(supplier.getSuppName());
        supplierDTO.setNationality(supplier.getNationality());
        supplierDTO.setSuppName(supplier.getSuppName());
        supplierDTO.setEmail(supplier.getEmail());
        supplierDTO.setRole(supplier.getRole());
        return supplierDTO;
    }
}
