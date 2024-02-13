package org.example.Service;

import org.example.User.User;

public interface UserService {
    User create(User user);
    User getUser(long chatId);
}
