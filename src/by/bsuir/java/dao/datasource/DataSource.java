package by.bsuir.java.dao.datasource;




import by.bsuir.java.dao.converter.Converter;
import by.bsuir.java.dao.converter.exception.ConverterException;
import by.bsuir.java.dao.datasource.exception.DataSourceException;
import by.bsuir.java.dao.validator.DAOValidator;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class DataSource<T> implements DAOValidator {

    private String filePath;

    public DataSource(String filePath) {
        this.filePath = filePath;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    private boolean isExist(File file){
        boolean fileExists = true;
        if (!isNull(file)){
            fileExists = file.exists();
        }
        return fileExists;
    }

    public List<T> read(Converter<T> converter) throws DataSourceException {
        if (isNull(filePath)) {
            String message = "Path has null value.";
            throw new DataSourceException(message);
        }
        InputStream is = this.getClass().getResourceAsStream(filePath);

        try (
             BufferedReader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"))) {
            List<T> list = new ArrayList<>();
            String currentLine;
            while (!isNull(currentLine = reader.readLine())) {
                if (currentLine.isEmpty()) {
                    continue;
                }
                T element = converter.getFromString(currentLine);
                list.add(element);
            }
            return list;
        } catch (IOException | ConverterException e) {
            String message = e.getMessage();
            throw new DataSourceException(message, e);
        }
    }

    public void write(T element, boolean append, Converter<T> converter)
            throws DataSourceException {
        if (isNull(element)) {
            String message = "Element has null value.";
            throw new DataSourceException(message);
        }
        try {
            URL resourceUrl = getClass().getResource(filePath);
            File file = new File(resourceUrl.toURI());
            OutputStream output = new FileOutputStream(file, append);
            try (//Writer fileWriter = new FileWriter(filePath, append);
                 BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output))) {
                String str = converter.convertToString(element);
                writer.write(str);
                writer.newLine();
            } catch (ConverterException | IOException e) {
                String message = e.getMessage();
                throw new DataSourceException(message, e);
            }
        }catch (FileNotFoundException | URISyntaxException e) {
            String message = e.getMessage();
            throw new DataSourceException(message, e);
        }
    }

    public void write(List<T> elements, Converter<T> converter)
            throws DataSourceException {
        if (isNull(elements)) {
            String message = "Elements has null value.";
            throw new DataSourceException(message);
        }
        try {
            URL resourceUrl = getClass().getResource(filePath);
            File file = new File(resourceUrl.toURI());
            OutputStream output = new FileOutputStream(file, false);
            try (
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output))) {
                for (T element : elements
                ) {
                    String str = converter.convertToString(element);
                    writer.write(str);
                    writer.newLine();
                }

            } catch (ConverterException | IOException e) {
                String message = e.getMessage();
                throw new DataSourceException(message, e);
            }
        } catch (FileNotFoundException | URISyntaxException e) {
            String message = e.getMessage();
            throw new DataSourceException(message, e);
        }
    }

}
