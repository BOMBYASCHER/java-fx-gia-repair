package io.hexlet.javafxrepair;

import io.hexlet.javafxrepair.dto.RequestForm;
import io.hexlet.javafxrepair.model.Request;

import java.sql.Date;

public class RequestMapper {
    public static Request toEntity(RequestForm requestForm) {
        Integer id = requestForm.getRequestNumber();
        Date startDate = requestForm.getStartDate();
        String type = requestForm.getType();
        String model = requestForm.getModel();
        String problem = requestForm.getProblemDescription();
        String phone = requestForm.getPhone();
        String fio = requestForm.getFullName();
        String status = requestForm.getStatus();
        Request request = new Request(
                id,
                startDate,
                type,
                model,
                problem,
                status,
                null,
                "",
                null ,
                null
        );
        return request;
    }
}
