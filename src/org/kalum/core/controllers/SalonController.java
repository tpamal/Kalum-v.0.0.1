package org.kalum.core.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.kalum.core.db.ConexionPU;
import org.kalum.core.models.Salon;
import org.kalum.core.reports.GenerarReporte;
import org.kalum.core.sistema.Main;
import org.kalum.core.utils.KalumException;
import org.kalum.core.utils.KalumViewMessage;

import java.net.URL;
import java.util.*;

public class SalonController implements Initializable {
    @FXML private TableView<Salon> tblSalon;
    @FXML private TableColumn<Salon, String> colSalonId;
    @FXML private TableColumn<Salon, String> colCapacidad;
    @FXML private TableColumn<Salon, String> colDescripcion;
    @FXML private TableColumn<Salon, String> colNombreSalon;

    private ObservableList<Salon> listaSalon;
    private Main escenarioPrincipal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
        this.listaSalon = FXCollections.observableArrayList((List<Salon>) ConexionPU.getInstancia().findAll
                ("Salon.findAll"));
        }catch (KalumException e){
            KalumViewMessage.getInstancia().mostrarMessage("Administracion de Salones", e.getMessage(),50301);
        }
        this.tblSalon.setItems(this.listaSalon);
        this.colSalonId.setCellValueFactory(cellData -> cellData.getValue().salonId());
        this.colCapacidad.setCellValueFactory(cellData -> cellData.getValue().capacidad());
        this.colDescripcion.setCellValueFactory(cellData -> cellData.getValue().descripcion());
        this.colNombreSalon.setCellValueFactory(cellData -> cellData.getValue().nombreSalon());
    }

    public void setEscenarioPrincipal(Main escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public void mostrarMenuPrincipal(){
        this.escenarioPrincipal.mostrarEscenaPrincipal();
    }
    public void mostrarVentanaSalonCU(){ this.escenarioPrincipal.mostrarEscenarioSalonCU();}


    public void mostrarVentanaSalonUpdate(){
        if(tblSalon.getSelectionModel().getSelectedItem() == null) {
            Alert aviso = new Alert(Alert.AlertType.ERROR);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText("Administracion de Salon");
            aviso.setContentText("Debe seleccionar un registro");
            aviso.show();
        } else {
            this.escenarioPrincipal.mostrarEscenarioSalonCU(this.tblSalon.getSelectionModel().getSelectedItem());
        }
    }

    public void eliminarSalon(){
        if(this.tblSalon.getSelectionModel().getSelectedItem() ==null){
            Alert aviso = new Alert(Alert.AlertType.ERROR);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText("Administracion de Salon");
            aviso.setContentText("Debe seleccionar un registro");
            aviso.show();
        } else {
            Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText("Administracion de Salon");
            aviso.setContentText("Esta seguro de eliminar el  registro");
            Optional<ButtonType> result = aviso.showAndWait();
            if(result.get() == ButtonType.OK){
                int posicion = this.tblSalon.getSelectionModel().getSelectedIndex();
                ConexionPU.getInstancia().eliminar(this.tblSalon.getSelectionModel().getSelectedItem());
                this.listaSalon.remove(posicion);
            }
        }
    }

    public void generarReporte(){
        Map parametros = new HashMap();
        GenerarReporte.getInstancia().mostrarReporte("Listado de Salones",
                "ReporteSalon.jasper", parametros);
    }
}
