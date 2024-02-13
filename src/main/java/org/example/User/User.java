package org.example.User;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.States.BotState;

import org.example.States.UserState;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class User {

    private Long chatId;
    private String username;
    private String phoneNumber;
    private String fullName;
    private BotState state;

    private UserState userState;

//    public User(Long chatId, String username, String phoneNumber, String fullName, BotState state, BotState start, LanguageState languageState, UserState userState) {
//        this.chatId = chatId;
//        this.username = username;
//        this.phoneNumber  = phoneNumber;
//        this.fullName = fullName;
//        this.state = state;
//        this.languageState = languageState;
//        this.userState = userState;
//    }

    @Override
    public String toString() {
        return "User{" +
                "chatId=" + chatId +
                ", username='" + username + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", fullName='" + fullName + '\'' +
                ", state=" + state +
                ", userState=" + userState +
                '}';
    }
    public UserState getUserState() {
        return userState;
    }

    public void setUserState(UserState userState) {
        this.userState = userState;
    }

    public Long getChatId() {
        return chatId;
    }

    public void setChatId(Long chatId) {
        this.chatId = chatId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public BotState getState() {
        return state;
    }

    public void setState(BotState state) {
        this.state = state;
    }


}