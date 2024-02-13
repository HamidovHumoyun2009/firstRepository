package org.example.User.Impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.example.Service.UserService;
import org.example.States.service.FileServiceImpl;
import org.example.User.User;

import java.util.List;

public class UserServiceImp implements UserService {
    private final String fileName = "users.txt";
    private FileServiceImpl fileService = new FileServiceImpl();

    @Override
    public User create(User user) {
        String dataFromFile = fileService.getDataFromFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<User> list = objectMapper.readValue(dataFromFile, List.class);
            list.add(user);
            Gson gson = new Gson();
            String json = gson.toJson(list);
            boolean b = fileService.writeDataToFile(json, fileName);
            System.out.println(b);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public User getUser(long chatId) {
        String dataFromFile = fileService.getDataFromFile(fileName);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<User> list = objectMapper.readValue(dataFromFile, List.class);
            for (User user : list) {
                if (user.getChatId() == chatId) {
                    return user;
                }
            }
        } catch (JsonMappingException e) {
            throw new RuntimeException(e);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
