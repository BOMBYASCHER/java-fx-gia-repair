package io.hexlet.javafxrepair.controller;

import io.hexlet.javafxrepair.RepairApplication;
import io.hexlet.javafxrepair.dao.RequestDAO;
import io.hexlet.javafxrepair.model.Request;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableRow;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Date;

public class MainController {
    @FXML
    private TableView<Request> tableView;
    @FXML
    private TableColumn<Request, Date> tableColumn1;
    @FXML
    private TableColumn<Request, String> tableColumn2;
    @FXML
    private TableColumn<Request, String> tableColumn3;
    @FXML
    private TableColumn<Request, String> tableColumn4;
    @FXML
    private TableColumn<Request, String> tableColumn5;
    @FXML
    private TableColumn<Request, Date> tableColumn6;
    @FXML
    private TableColumn<Request, String> tableColumn7;
    @FXML
    private TableColumn<Request, Integer> tableColumn8;
    @FXML
    private TableColumn<Request, Integer> tableColumn9;
    @FXML
    private Button addRequest;

    @FXML
    private void initialize() {
        tableView.setEditable(true);
        tableView.setRowFactory(requestTableView -> {
            TableRow<Request> row = new TableRow<>();
            row.setOnMouseClicked(mouseEvent -> {
                Request request = row.getItem();
                System.out.println(request);
                EditRequestController controller = new EditRequestController(request);
                createWindow("edit-request.fxml", controller);
            });
            return row;
        });
        tableColumn1.setCellValueFactory(new PropertyValueFactory<>("startDate"));
        tableColumn2.setCellValueFactory(new PropertyValueFactory<>("type"));
        tableColumn3.setCellValueFactory(new PropertyValueFactory<>("model"));
        tableColumn4.setCellValueFactory(new PropertyValueFactory<>("problemDescription"));
        tableColumn5.setCellValueFactory(new PropertyValueFactory<>("status"));
//        tableColumn5.setCellFactory(new Callback<>() {
//            @Override
//            public TableCell<Request, String> call(TableColumn<Request, String> requestStringTableColumn) {
//                var cbtc = new ChoiceBoxTableCell<Request, String>("Новая заявка", "В процессе ремонта", "Готово к выдаче") {
//                    @Override
//                    public void commitEdit(String s) {
//                        super.commitEdit(s);
//                        System.out.println("IT WORKS!");
//                    }
//                };
//                return cbtc;
//            }
//        });

//        tableColumn5.setOnEditCommit(c -> {
//            c.getRowValue().setStatus(c.getNewValue());
//        });

//        tableColumn5.setCellFactory(ChoiceBoxTableCell.forTableColumn("Новая заявка", "В процессе ремонта", "Готово к выдаче"));
//        tableColumn5.setCellValueFactory(requestStringCellDataFeatures -> {
//            requestStringCellDataFeatures.getTableColumn().setCellFactory(requestStringTableColumn -> {
//                var cell = new TableCell<Request, String>();
//                var menu = new ContextMenu(new MenuItem("Новая заявка"),
//                        new MenuItem("В процессе ремонта"),
//                        new MenuItem("Готово к выдаче"));
//                menu.getItems().forEach(menuItem -> menuItem.setOnAction(e -> cell.setText(menuItem.getText())));
//                cell.setContextMenu(menu);
//                return cell;
//            });
//            return new ObservableValueBase<>() {
//                @Override
//                public String getValue() {
//                    return requestStringCellDataFeatures.getValue().getStatus();
//                }
//            };
//        });
//        tableColumn5.setCellFactory(requestStringTableColumn -> {
//            var cell = new TableCell<Request, String>() {
//                @Override
//                protected void updateItem(String s, boolean b) {
//                    super.updateItem(s, b);
//                    if (!b) {
//                        this.setText(s);
//                    }
//                }
//            };
//            var menu = new ContextMenu(new MenuItem("Новая заявка"),
//                    new MenuItem("В процессе ремонта"),
//                    new MenuItem("Готово к выдаче"));
//            menu.getItems().forEach(menuItem -> menuItem.setOnAction(e -> cell.setText(menuItem.getText())));
//            cell.setContextMenu(menu);
//            return cell;
//        });

        tableColumn6.setCellValueFactory(new PropertyValueFactory<>("finishDate"));
        tableColumn7.setCellValueFactory(new PropertyValueFactory<>("repairParts"));
        tableColumn8.setCellValueFactory(new PropertyValueFactory<>("masterId"));
        tableColumn9.setCellValueFactory(new PropertyValueFactory<>("clientId"));
        tableView.setItems(RequestDAO.getRequests());

        addRequest.setOnMouseClicked(mouseEvent -> {
            createWindow("add-view.fxml", null);
        });

//        tableColumn5.setCellFactory(new Callback<TableColumn<Request, String>, TableCell<Request, String>>() {
//            @Override
//            public TableCell<Request, String> call(TableColumn<Request, String> requestStringTableColumn) {
//                var cell = new TableCell<Request, String>();
//                var menu = new ContextMenu(new MenuItem("Новая заявка"),
//                        new MenuItem("В процессе ремонта"),
//                        new MenuItem("Готово к выдаче"));
//                menu.getItems().forEach(menuItem -> menuItem.setOnAction(e -> cell.setText(menuItem.getText())));
//                cell.setContextMenu(menu);
//                return cell;
//            }
//        });
    }

    private void createWindow(String fxml, Object controller) {
        FXMLLoader fxmlLoader = new FXMLLoader(RepairApplication.class.getResource(fxml));
        Scene scene;
        try {
            if (controller != null) {
                fxmlLoader.setController(controller);
            }
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage = new Stage();
        stage.setTitle("Request");
        stage.setScene(scene);
        stage.show();
    }
}