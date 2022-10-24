package org.ru.filatov.task1;

import java.util.UUID;

public class Office {
    private UUID id;
    private String address;
    private String lawAdress;
    private Integer cabinetsCount;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLawAdress() {
        return lawAdress;
    }

    public void setLawAdress(String lawAdress) {
        this.lawAdress = lawAdress;
    }

    public Integer getCabinetsCount() {
        return cabinetsCount;
    }

    public void setCabinetsCount(Integer cabinetsCount) {
        this.cabinetsCount = cabinetsCount;
    }

    public Office() {
    }

    public Office(UUID id, String address, String lawAdress, Integer cabinetsCount) {
        this.id = id;
        this.address = address;
        this.lawAdress = lawAdress;
        this.cabinetsCount = cabinetsCount;
    }
}
