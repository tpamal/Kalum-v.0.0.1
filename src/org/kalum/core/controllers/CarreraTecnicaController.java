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
import org.kalum.core.models.Alumno;
import org.kalum.core.models.Carrera_Tecnica;
import org.kalum.core.reports.GenerarReporte;
import org.kalum.core.sistema.Main;
import org.kalum.core.utils.KalumException;
import org.kalum.core.utils.KalumViewMessage;

import java.net.URL;
import java.util.*;

public class CarreraTecnicaController implements Initializable {
    @FXML private TableView<Carrera_Tecnica> tblCarreraTecnica;
    @FXML private TableColumn< Carrera_Tecnica, String> colCodigoCarrera;
    @FXML private TableColumn< Carrera_Tecnica, String> colNombre;


    private ObservableList<Carrera_Tecnica> listaCarrerasTecnica;
    private Main escenarioPrincipal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            this.listaCarrerasTecnica = FXCollections.observableArrayList((List<Carrera_Tecnica>) ConexionPU.getInstancia().findAll
                    ("Carrera_Tecnica.findAll"));
        }catch (KalumException e){
            KalumViewMessage.getInstancia().mostrarMessage("Administracion de Horarios", e.getMessage(),50301);
        }
        this.tblCarreraTecnica.setItems(this.listaCarrerasTecnica);
        this.colCodigoCarrera.setCellValueFactory(cellData -> cellData.getValue().codigoCarrera());
        this.colNombre.setCellValueFactory(cellData -> cellData.getValue().nombre());
    }

    public void setEscenarioPrincipal(Main escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public void mostrarMenuPrincipal(){
        this.escenarioPrincipal.mostrarEscenaPrincipal();
    }

    public void mostrarVentanaCarreraTecnicaCU(){ this.escenarioPrincipal.mostrarEscenarioCarreraTecnicaCU();}

    public void mostrarVentanaCarreraTecnicaUpdate(){
        if(tblCarreraTecnica.getSelectionModel().getSelectedItem() == null) {
            Alert aviso = new Alert(Alert.AlertType.ERROR);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText("Administracion de Instructor");
            aviso.setContentText("Debe seleccionar un registro");
            aviso.show();
        } else {
            this.escenarioPrincipal.mostrarEscenarioCarreraTecnicaCU(this.tblCarreraTecnica.getSelectionModel().getSelectedItem());
        }
    }

    public void eliminarCarreraTecnica(){
        if(this.tblCarreraTecnica.getSelectionModel().getSelectedItem() ==null){
            Alert aviso = new Alert(Alert.AlertType.ERROR);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText("Administracion de Instructor");
            aviso.setContentText("Debe seleccionar un registro");
            aviso.show();
        } else {
            Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText("Administracion de Instructor");
            aviso.setContentText("Esta seguro de eliminar el  registro");
            Optional<ButtonType> result = aviso.showAndWait();
            if(result.get() == ButtonType.OK){
                int posicion = this.tblCarreraTecnica.getSelectionModel().getSelectedIndex();
                ConexionPU.getInstancia().eliminar(this.tblCarreraTecnica.getSelectionModel().getSelectedItem());
                this.listaCarrerasTecnica.remove(posicion);
            }
        }
    }

    public void generarReporte(){
        Map parametros = new HashMap();
        GenerarReporte.getInstancia().mostrarReporte("Listado de Carrera Tecnicas",
                "ReporteCarreraTecnica.jasper", parametros);
    }

}
