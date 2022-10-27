package org.ru.filatov.task2;

import org.apache.commons.lang3.math.NumberUtils;
import org.ru.filatov.task1.Client;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;
import java.util.UUID;

public class CredentialsInput{
    public static void input(Client client){
        Scanner in = new Scanner(System.in);

        System.out.print("Введите имя: ");
        String name = in.nextLine();
        while(NumberUtils.isParsable(name)){
            System.out.print("Имя не может состоять из цифр или быть пустым\nПовторите ввод: ");
            name = in.nextLine();
        }

        System.out.print("Введите фамилию: ");
        String surname = in.nextLine();
        while(NumberUtils.isParsable(surname)){
            System.out.print("Фамилия не может состоять из цифр или быть пустой.\nПовторите ввод: ");
            surname = in.nextLine();
        }

        System.out.print("Введите отчество: ");
        String patronymic = in.nextLine();
        while(NumberUtils.isParsable(patronymic)){
            System.out.print("Отчество не может состоять из цифр или быть пустым.\nПовторите ввод: ");
            patronymic = in.nextLine();
        }

        boolean sex = true;
        String charSex;
        boolean sexIsCorrect;
        System.out.print("Введите пол(М/Ж): ");
        do {
            charSex = in.nextLine();
            sexIsCorrect = true;
            switch (charSex) {
                case "М":
                    sex = false;
                        break;
                case "Ж":
                    sex = true;
                    break;
                default:
                    System.out.print("Неверное значение. Повторите ввод: ");
                    sexIsCorrect = false;
                    break;
            }
        }
        while (!sexIsCorrect);

        System.out.print("Введите дату рождения в формате yyyy-MM-dd: ");
        boolean dateIsCorrect;
        LocalDate birthDate = LocalDate.now();
        do {
            dateIsCorrect = true;
            try {
                birthDate = LocalDate.parse(in.nextLine());
            }
            catch (DateTimeParseException e) {
                dateIsCorrect = false;
                System.out.print("Неверный формат даты.\nПовторите ввод: ");
            }
        }
        while (!dateIsCorrect);

        System.out.print("Введите ИНН: ");
        String inn = in.nextLine();
        while(!NumberUtils.isParsable(inn) || inn.length() != 12){
            System.out.print("ИНН должен состоять из цифр иметь длину 12 символов.\nПовторите ввод: ");
            inn = in.nextLine();
        }

        System.out.print("Введите номер паспорта: ");
        String passportSerial = in.nextLine();
        while(!NumberUtils.isParsable(passportSerial) || passportSerial.length() != 6){
            System.out.print("Номер паспорта должен состоять из цифр иметь длину 6 символов.\nПовторите ввод: ");
            passportSerial = in.nextLine();
        }

        System.out.print("Введите номер телефона: ");
        String phone = in.nextLine();
        while(!NumberUtils.isParsable(phone)){
            System.out.print("Номер телефона должен состоять из цифр.\nПовторите ввод: ");
            phone = in.nextLine();
        }
        client.setId(UUID.randomUUID());
        client.setName(name);
        client.setSurname(surname);
        client.setPatronymic(patronymic);
        client.setSex(sex);
        client.setBirthdate(birthDate);
        client.setInn(inn);
        client.setPassportSerial(passportSerial);
        client.setPhone(phone);
    }
}