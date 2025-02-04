package io.hexlet.javafxrepair.service;

import io.hexlet.javafxrepair.dao.UserDAO;
import io.hexlet.javafxrepair.dto.RequestForm;
import io.hexlet.javafxrepair.model.User;

public class UserService {
    public static User getUser(RequestForm requestForm) {
        return UserDAO.getUserByFio(requestForm.getFullName())
                .orElseGet(() -> registry(requestForm));
    }
    public static User registry(RequestForm requestForm) {
        User user = new User(
                "Заказчик",
                "",
                "",
                requestForm.getPhone(),
                requestForm.getFullName(),
                null
        );
        UserDAO.createUser(user);
        return user;
    }
}
