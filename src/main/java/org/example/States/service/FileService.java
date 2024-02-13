package org.example.States.service;

public interface  FileService {
    String getDataFromFile(String fileName);
    boolean writeDataToFile(String data, String fileName);
}
