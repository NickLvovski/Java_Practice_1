package org.ru.filatov.task1;

import java.time.LocalDate;
import java.util.UUID;

public class Stuff {
    private UUID id;
    private String surname;
    private String name;
    private String patronymic;
    private Boolean sex;
    private LocalDate birthdate;
    private Double salaryMultiplier;
    private Position position;

    public Stuff(UUID id, String surname, String name, String patronymic,
                 Boolean sex, LocalDate birthdate, Double salaryMultiplier, Position position) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.sex = sex;
        this.birthdate = birthdate;
        this.salaryMultiplier = salaryMultiplier;
        this.position = position;
    }

    public Stuff() {
    }
}
