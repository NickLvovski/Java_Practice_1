package org.ru.filatov.task1;

import java.util.UUID;

public class Position {
    private UUID id;
    private String surname;
    private Integer salary;

    public Position() {
    }
    public Position(UUID id, String surname, Integer salary) {
        this.id = id;
        this.surname = surname;
        this.salary = salary;
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

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

}
