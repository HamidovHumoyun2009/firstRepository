package org.example.States.service;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class ButtonService {

    public InlineKeyboardMarkup mainMenu() {
        InlineKeyboardMarkup markup = new InlineKeyboardMarkup();

        InlineKeyboardButton button1 = new InlineKeyboardButton();
        button1.setText("O'zbek tili");
        button1.setCallbackData("uz");

        InlineKeyboardButton button2 = new InlineKeyboardButton();
        button2.setText("руский язык");
        button2.setCallbackData("rus");

        List<InlineKeyboardButton> row1 = new ArrayList<>();
        row1.add(button1);

        List<InlineKeyboardButton> row2 = new ArrayList<>();
        row2.add(button2);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(row1);
        rowList.add(row2);

        markup.setKeyboard(rowList);

        return markup;
    }
}
