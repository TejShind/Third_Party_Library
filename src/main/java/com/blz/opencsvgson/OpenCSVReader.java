package com.blz.opencsvgson;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVReader {
    private static final String CSV_PATH = "C:\\Users\\SONY\\JAVA\\File_IO_Operations\\src\\main\\java\\service\\OpenCSV.java";

    public static void main(String[] args) {
        try {
            Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));
            CSVReader csvReader = new CSVReader(reader);
          //  String[] record;
            List<String[]> records = csvReader.readAll();

            for (String[] record : records) {
                System.out.println("Name:" + record[0]);
                System.out.println("email:" + record[1]);
                System.out.println("Phone:" + record[2]);
                System.out.println("country:" + record[3]);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvException e) {
            e.printStackTrace();
        }
    }
}

