import com.blz.opencsvgson.CSVUser;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class OpenCSVANDGSONTester {
    private static final String CSV_PATH = "C:\\Users\\SONY\\JAVA\\OpenCSV_GSON\\src\\main\\resources\\users.csv";
    private static final String JSON_FILE_PATH = "C:\\Users\\SONY\\JAVA\\OpenCSV_GSON\\src\\main\\resources\\userjson.json";

    public static void main(String[] args) {
        try {

            Reader reader = Files.newBufferedReader(Paths.get(CSV_PATH));
            CsvToBean<CSVUser> csvToBean = new CsvToBeanBuilder<CSVUser>(reader)
                    .withType(CSVUser.class)
                    .build();
            List<CSVUser> csvUsers = csvToBean.parse();
            Gson gson = new Gson();
            String json = gson.toJson(csvUsers);
            System.out.println(json);

//            //converting java object to json
            FileWriter fileWriter = new FileWriter(JSON_FILE_PATH);
            fileWriter.write(json);
            fileWriter.close();
            BufferedReader bufferedReader = new BufferedReader(new FileReader(JSON_FILE_PATH));
            CSVUser[] users = gson.fromJson(bufferedReader, CSVUser[].class);
            for (CSVUser user : users) {
                System.out.println(user);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
