package org.ru.filatov.task1;

import java.time.LocalDate;
import java.util.UUID;

public class Client {
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private Boolean sex;
    private LocalDate birthdate;
    private String inn;
    private String passportSerial;
    private String phone;

    public Client(UUID id, String surname, String name, String patronymic, Boolean sex,
                  LocalDate birthdate, String inn, String passportSerial, String phone) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.sex = sex;
        this.birthdate = birthdate;
        this.inn = inn;
        this.passportSerial = passportSerial;
        this.phone = phone;
    }

    public Client() {

    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public String getBirthdate() { return birthdate.toString(); }
    public LocalDate birthdateAsLocalDate() {return birthdate;}

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getInn() {
        return inn;
    }

    public void setInn(String inn) {
        this.inn = inn;
    }

    public String getPassportSerial() {
        return passportSerial;
    }

    public void setPassportSerial(String passportSerial) {
        this.passportSerial = passportSerial;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
