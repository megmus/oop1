package de.mome.javaprofis.oop.univ.domain;

import java.text.SimpleDateFormat;

final class UniStaff implements IStaffRO {

    private final IUniMember instance;

    public UniStaff(final IUniMember uniMember) {
        instance = uniMember;
    }

    @Override
    public long id() {
        return instance.id();
    }

    @Override
    public String firstname() {
        return instance.firstname();
    }

    @Override
    public String lastname() {
        return instance.lastname();
    }

    @Override
    public String birthdate() {
        return SimpleDateFormat.getInstance().format(UniMember.BIRTHDATE_FORMATTER);
    }

    @Override
    public String currentStatus() {
        return instance.currentStatus().toString();
    }

    public String toString() {
        return instance.toString();
    }

}