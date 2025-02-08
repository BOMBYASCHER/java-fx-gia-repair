package io.hexlet.javafxrepair.service;

import io.hexlet.javafxrepair.model.User;

public class LoginService {
    private static User currentUser;

    public static boolean authenticate(String username, String password) {
        try {
            User user = UserService.getUser(username);
            if (user.getPassword().equals(password)) {
                setCurrentUser(user);
                return true;
            } else
                throw new Exception();
        } catch (Exception e) {
            return false;
        }
    }

    public static User getCurrentUser() {
        return currentUser;
    }

    public static void setCurrentUser(User currentUser) {
        LoginService.currentUser = currentUser;
    }
}