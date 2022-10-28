package org.ru.filatov.task4;

import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class StuffStatistics {
    public static final Integer CSV_ID_COLUMN = 0;
    public static final Integer CSV_NAME_COLUMN = 1;
    public static final Integer CSV_SURNAME_COLUMN = 2;
    public static final Integer CSV_PATRONYMIC_COLUMN = 3;
    public static final Integer CSV_BIRTH_DATE_COLUMN = 4;
    public static final Integer CSV_SEX_COLUMN = 5;
    public static final Integer CSV_SALARY_COLUMN = 6;

    private final List<Stuff> stuffsRow = new ArrayList<>();

    public StuffStatistics(String file){
        try(CSVReader reader = new CSVReaderBuilder
                (new FileReader(StuffStatistics.class.getResource(file).getFile())).build()){
            List<String[]> rows = reader.readAll();
            List<Stuff> mappedStuffList = rows.stream()
                    .map(row -> {
                        Stuff stuff = new Stuff();
                        stuff.setId(UUID.fromString(row[CSV_ID_COLUMN]));
                        stuff.setName(row[CSV_NAME_COLUMN]);
                        stuff.setSurname(row[CSV_SURNAME_COLUMN]);
                        stuff.setPatronymic(row[CSV_PATRONYMIC_COLUMN]);
                        stuff.setSex(!Boolean.parseBoolean(row[CSV_SEX_COLUMN]));
                        stuff.setBirthdate(LocalDate.parse(row[CSV_BIRTH_DATE_COLUMN]));
                        stuff.setSalary(Double.valueOf(row[CSV_SALARY_COLUMN]));
                        return stuff;
                    }).toList();
            stuffsRow.addAll(mappedStuffList);
        } catch (IOException | CsvException e) {
            throw new RuntimeException(e);
        }
    }
    public int nameStat(String name){
        return (int)stuffsRow.stream()
                .filter(p -> p.getName().equals(name))
                .count();
    }
    public int surnameStat(String surname){
        return (int)stuffsRow.stream()
                .filter(p -> p.getSurname().equals(surname))
                .count();
    }
    public  int birthMonthStat(int month){
        return (int)stuffsRow.stream()
                .filter(p -> p.getBirthdate().getMonthValue() == month)
                .count();
    }
    public int sexStat(boolean sex){
        return (int)stuffsRow.stream()
                .filter(p -> p.getSex().equals(sex))
                .count();
    }
    public int salaryStat(int lowerBound){
        return (int)stuffsRow.stream()
                .filter(p -> p.getSalary() >= lowerBound)
                .count();
    }
    public int salaryStat(int lowerBound, int higherBound){
        return (int)stuffsRow.stream()
                .filter(p -> p.getSalary() >= lowerBound &&
                             p.getSalary() <= higherBound)
                .count();
    }
}
