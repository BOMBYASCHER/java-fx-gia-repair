package io.hexlet.javafxrepair.model;

import lombok.*;

import java.sql.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Request {
    private Integer id;
    private Date startDate;
    private String type;
    private String model;
    private String problemDescription;
    private String status;
    private Date finishDate;
    private String repairParts;
    private Integer masterId;
    private Integer clientId;
}
