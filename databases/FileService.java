package databases;

import java.io.*;
import java.util.*;
import java.util.stream.*;


/*
 * Класс Singletone, отвечающий работу с файлом.
 * FileService instance - instance.
 */
public class FileService {
    private static FileService instance;

    public static synchronized FileService getInstance() {
        if(instance == null) {
            instance = new FileService();
        }
        return instance;
    }

    /*
     * Функция осуществляет чтение файла базы данных.
     */
    public static List<Account> readCSV(String path) {
        File file = new File(path);
        FileInputStream fileIn;
        List<List<String>> accounts = new ArrayList<List<String>>();
        try {
            if (!file.exists()) {
                List<Account> item = new ArrayList<Account>();
                FileService.writeCSV(item, path);
                return item;
            }
            fileIn = new FileInputStream(path);
            BufferedReader buff = new BufferedReader(new InputStreamReader(fileIn, "UTF-8"));
            String data;
            while ( (data = buff.readLine()) != null ) {
                accounts.add(Arrays.asList(data.split(",")));
            }
            buff.close();
        } catch(IOException exception) {
            exception.printStackTrace();
        }
        if (accounts.size() > 1) {
            accounts =  accounts.subList(1, accounts.size());
        }
        else {
            accounts = new ArrayList<List<String>>();
        }
        return accounts.stream().map(rec -> new Account(rec.get(0), rec.get(1), rec.get(2), rec.get(3))).collect(Collectors.toList());
    }

     /*
     * Функция осуществляет запись в файл базы данных.
     */
    public static void writeCSV(List<Account> dataset, String path) {
        FileOutputStream fileOut;
        try {
            fileOut = new FileOutputStream(path);
            BufferedWriter buff = new BufferedWriter(new OutputStreamWriter(fileOut, "UTF-8"));
            buff.write("name,birthDate,email,password\n");
            for (Account item: dataset) {
                buff.write(String.format("%s,%s,%s,%s\n", item.getName(), item.getBirthDate(), item.getEmail(), item.getPassword()));
            }
            buff.close();
        } catch(IOException exception) {
            exception.printStackTrace();
        }
    }
}
