package ru.netology.web.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DataGenerator {
    private DataGenerator() {
    }

    public static String generateDate(int shift) {
        String date = LocalDate.now().plusDays(shift).format(DateTimeFormatter.ofPattern("dd.MM.yyyy"));
        return date;
    }

}
