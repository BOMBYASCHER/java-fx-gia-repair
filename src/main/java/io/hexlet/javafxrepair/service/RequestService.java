package io.hexlet.javafxrepair.service;

import io.hexlet.javafxrepair.RequestMapper;
import io.hexlet.javafxrepair.dao.RequestDAO;
import io.hexlet.javafxrepair.dto.RequestForm;
import io.hexlet.javafxrepair.model.Request;
import io.hexlet.javafxrepair.model.User;

public class RequestService {
    public static void saveRequest(RequestForm requestForm) {
        User user = UserService.getUser(requestForm);
        Request request = RequestMapper.toEntity(requestForm);
        request.setClientId(user.getId());
        RequestDAO.addRequest(request);
    }
}
