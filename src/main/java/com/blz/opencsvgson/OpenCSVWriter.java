package com.blz.opencsvgson;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class OpenCSVWriter {


    public static void main(String[] args) throws IOException {
        String SAMPLE_CSV = "C:\\Users\\SONY\\JAVA\\OpenCSV_GSON\\src\\main\\resources\\sample.csv";
        Writer writer = null;
        try {
            writer = Files.newBufferedWriter((Paths.get(SAMPLE_CSV)));
            StatefulBeanToCsv<CSVUser> beanToCsv = new StatefulBeanToCsvBuilder<CSVUser>(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();
            List<CSVUser> userList = new ArrayList<>();
            userList.add(new CSVUser("Rajeev Kumar Singh", "rajeevs@example.com", "+91-9999999999", "India"));

            beanToCsv.write(userList);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (CsvRequiredFieldEmptyException e) {
            e.printStackTrace();
        } catch (CsvDataTypeMismatchException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }
}