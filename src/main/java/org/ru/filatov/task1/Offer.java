package org.ru.filatov.task1;

import java.time.LocalDateTime;
import java.util.UUID;

public class Offer {
    private UUID id;
    private String serialNumber;
    private LocalDateTime signDate;
    private LocalDateTime endingDate;
    private LocalDateTime startDate;

    public Offer() {
    }

    public Offer(UUID id, String serialNumber, LocalDateTime signDate,
                 LocalDateTime endingDate, LocalDateTime startDate) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.signDate = signDate;
        this.endingDate = endingDate;
        this.startDate = startDate;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDateTime getSignDate() {
        return signDate;
    }

    public void setSignDate(LocalDateTime signDate) {
        this.signDate = signDate;
    }

    public LocalDateTime getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(LocalDateTime endingDate) {
        this.endingDate = endingDate;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }
}
