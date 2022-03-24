package de.mome.javaprofis.oop.univ.domain;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;

abstract class UniMember implements IUniMember {

    private String firstname;
    private String lastname;
    private Date birthdate;
    private Address address;

    public static final String BIRTHDATE_FORMATTER = "dd.MM.yyyy";

    public UniMember(final String firstname, final String lastname, final String birthdate) {
        updateFirstname(firstname);
        updateLastname(lastname);
        updateBirthdate(birthdate);
    }

    public String firstname() {
        return firstname;
    }

    protected void updateFirstname(final String firstname) {
        if (StringUtils.isBlank(firstname)) {
            throw new IllegalArgumentException("Firstname value not allowed: " + firstname);
        }
        this.firstname = firstname;
    }

    public String lastname() {
        return lastname;
    }

    public void updateLastname(String lastname) {
        if (StringUtils.isBlank(lastname)) {
            throw new IllegalArgumentException("Lastname value not allowed: " + lastname);
        }
        this.lastname = lastname;
    }

    public Date birthdate() {
        return (birthdate == null) ? null : new Date(birthdate.getTime());
    }

    protected void updateBirthdate(String birthdate) {
        if (StringUtils.isBlank(birthdate)) {
            throw new IllegalArgumentException("Birthdate value not allowed: " + birthdate);
        }
        if (!isAdult(birthdate)) {
            throw new IllegalArgumentException("Member too young: " + birthdate);
        }
        if (!isApt(birthdate)) {
            throw new IllegalArgumentException("Member not apt: " + birthdate);
        }
        try {
            this.birthdate = DateUtils.parseDate(birthdate, BIRTHDATE_FORMATTER);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Can not parse birthdate " + birthdate);
        }
    }

    protected abstract boolean isApt(final String birthdate);

    private boolean isAdult(final String birthdate) {
        return (age(birthdate) >= 18);
    }

    protected int age(final String birthdate) {
        LocalDate bday = LocalDate.parse(birthdate, DateTimeFormatter.ofPattern(BIRTHDATE_FORMATTER));
        LocalDate today = LocalDate.now();
        Period age = Period.between(bday, today);

        return (age != null) ? age.getYears() : -1;
    }

    protected void resetBirthdate(final Date originAge) {
        this.birthdate = originAge;
    }

    public void createAddress(final String street, final String city, final String zipcode) {
        if (address != null) {
            throw new IllegalStateException("One address already exists");
        }

        address = new Address(street, city, zipcode);
        address.updateCity(city);
        address.updateStreet(street);
        address.updateZipcode(zipcode);
    }

    public void updateAddress(final String street, final String city, final String zipcode) {
        if (address == null) {
            throw new IllegalStateException("No address exists");
        }
        address.updateCity(city);
        address.updateStreet(street);
        address.updateZipcode(zipcode);
    }

    public String currentStreet() {
        if (address == null) {
            throw new IllegalStateException("No address created or existed");
        }
        return address.street();
    }

    public String currentCity() {
        if (address == null) {
            throw new IllegalStateException("No address created or existed");
        }
        return address.city();
    }

    public String currentZipcode() {
        if (address == null) {
            throw new IllegalStateException("No address created or existed");
        }
        return address.zipcode();
    }

    public String toString() {
        return "\n" +
                "Firstname: " + firstname() + "\n" +
                "Lastname: " + lastname() + "\n" +
                "Birthdate: " + new SimpleDateFormat(BIRTHDATE_FORMATTER).format(birthdate()) +
                "" + ((address != null) ? "\n" + address : "");
    }

    class Address {
        private String street;
        private String city;
        private String zipcode;

        Address(final String street, final String city, final String zipcode) {
            updateStreet(street);
            updateCity(city);
            updateZipcode(zipcode);
        }

        private void updateZipcode(String zipcode) {
            if (StringUtils.isBlank(zipcode) || !StringUtils.isNumeric(zipcode)) {
                throw new IllegalArgumentException("Zipcode value allowed: " + zipcode);
            }
            this.zipcode = zipcode;
        }

        private String zipcode() {
            return zipcode;
        }

        private void updateCity(String city) {
            if (StringUtils.isBlank(city)) {
                throw new IllegalArgumentException("City value not allowed: " + city);
            }
            this.city = city;
        }

        private String city() {
            return city;
        }

        private void updateStreet(final String street) {
            if (StringUtils.isBlank(street)) {
                throw new IllegalArgumentException("Street value not allowed: " + street);
            }
            this.street = street;
        }

        private String street() {
            return street;
        }

        public String toString() {
            return "Address: " + address.street() + ", " + address.city() + " " + address.zipcode();
        }
    }

    //overloading examples
    /*public void draw(int x, int y) {
        System.out.println("draw method with int parameter types");
    }

    public void draw(Integer x, Integer y) {
        System.out.println("draw method with Integer parameter types");
    }*/

}
