package com.blz.opencsvgson;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReadAndParseToBean {
    private static final String CSV_PATH = "C:\\Users\\SONY\\JAVA\\OpenCSV_GSON\\src\\main\\resources\\users.csv";

    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder<CSVUser>(reader)
                    .withType(CSVUser.class)
                    .build();
            List<CSVUser> userList = csvToBean.parse();
            System.out.println(userList);
        } catch (IOException e) {

        }
    }
}
