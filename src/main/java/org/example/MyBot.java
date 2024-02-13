package org.example;




import org.example.States.BotState;
import org.example.States.UserState;
import org.example.States.service.ButtonService;
import org.example.User.Impl.UserServiceImp;
import org.example.User.User;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;


import java.util.ArrayList;
import java.util.List;




public  class MyBot extends TelegramLongPollingBot {
    UserServiceImp userService = new UserServiceImp();
    ButtonService buttonService = new ButtonService();
    List<Long> AdminList = new ArrayList<>();
    List<User> users = new ArrayList<>();

    public MyBot(String botToken) {
        super(botToken);
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage() && update.getMessage().hasText()) {

            long chatId = update.getMessage().getChatId();
            String text = update.getMessage().getText();


            if (text.equals("/start")) {
                User user = new User();
                user.setChatId(chatId);
                user.setState(BotState.UZ);
                User user1 = userService.create(user);

            } else {
                User user = userService.getUser(chatId);
                switch (user.getState()) {

                    case UZ -> {
                        if (user.getState() == BotState.UZ) {
                            user.setState(BotState.MENU);
                            SendMessage message = new SendMessage();
                            message.setText("Tini tanlang");
                            message.setChatId(chatId);
                            message.setReplyMarkup(buttonService.mainMenu());

                            try {
                                execute(message);
                            } catch (TelegramApiException e) {
                                throw new RuntimeException(e);
                            }

                        }

                    }

                }
            }

        } else if (update.hasCallbackQuery()) {

        }
    }

    @Override
    public String getBotUsername () {
        return "midlegroupbot";
    }
}