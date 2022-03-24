package de.mome.javaprofis.oop.univ.domain;

import java.util.Date;

public interface IUniMember {

    long id();

    IStaffRO.Staffstatus currentStatus();

    String firstname();

    String lastname();

    Date birthdate();

    void createAddress(final String street, final String city, final String zipcode);

    void updateAddress(final String street, final String city, final String zipcode);

    String currentStreet();

    String currentCity();

    String currentZipcode();
}
