package ru.tagirov.TheMedicalSystem.Services;


import ru.tagirov.TheMedicalSystem.Models.Address;

import java.util.List;

public interface AddressService {
    List<Address> findAllAddresses();
    Address saveAddress(Address Address);
    Address updateAddress(Address Address);
}
