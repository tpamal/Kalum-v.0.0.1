package org.kalum.core.controllers;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import org.kalum.core.db.ConexionPU;
import org.kalum.core.models.Horario;
import org.kalum.core.reports.GenerarReporte;
import org.kalum.core.sistema.Main;
import org.kalum.core.utils.KalumException;
import org.kalum.core.utils.KalumViewMessage;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.*;

public class HorarioController implements Initializable {
    @FXML private TableView<Horario> tblHorario;
    @FXML private TableColumn<Horario, String> colHorarioInicio;
    @FXML private TableColumn<Horario, String>colHorarioFinal ;


    private ObservableList<Horario> listaHorarios;
    private Main escenarioPrincipal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        SimpleDateFormat tsdf = new SimpleDateFormat("HH:mm");
        try{
    this.listaHorarios = FXCollections.observableArrayList((List<Horario>) ConexionPU.getInstancia().findAll
            ("Horario.findAll"));
        }catch (KalumException e){
            KalumViewMessage.getInstancia().mostrarMessage("Administracion de Horarios", e.getMessage(),50301);
        }
    this.tblHorario.setItems(this.listaHorarios);
    this.colHorarioInicio.setCellValueFactory(cellData -> new ReadOnlyStringWrapper
            (tsdf.format(cellData.getValue().getHorarioInicio())));
    this.colHorarioFinal.setCellValueFactory(cellData -> new ReadOnlyStringWrapper
            (tsdf.format(cellData.getValue().getHorarioFinal())));

    }

    public void setEscenarioPrincipal(Main escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public void mostrarMenuPrincipal(){
        this.escenarioPrincipal.mostrarEscenaPrincipal();
    }

    public void mostrarVentanaHorarioCU(){ this.escenarioPrincipal.mostrarEscenarioHorarioCU();}

    public void mostrarVentanaHorarioUpdate(){
        if(tblHorario.getSelectionModel().getSelectedItem() == null) {
            Alert aviso = new Alert(Alert.AlertType.ERROR);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText("Administracion de Horarios");
            aviso.setContentText("Debe seleccionar un registro");
            aviso.show();
        } else {
            this.escenarioPrincipal.mostrarEscenaHorarioCUS(this.tblHorario.getSelectionModel().getSelectedItem());
        }
    }

    public void eliminarHorario(){
        if(this.tblHorario.getSelectionModel().getSelectedItem() ==null){
            Alert aviso = new Alert(Alert.AlertType.ERROR);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText("Administracion de Alumnos");
            aviso.setContentText("Debe seleccionar un registro");
            aviso.show();
        } else {
            Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText("Administracion de Alumnos");
            aviso.setContentText("Esta seguro de eliminar el  registro");
            Optional<ButtonType> result = aviso.showAndWait();
            if(result.get() == ButtonType.OK){
                int posicion = this.tblHorario.getSelectionModel().getSelectedIndex();
                ConexionPU.getInstancia().eliminar(this.tblHorario.getSelectionModel().getSelectedItem());
                this.listaHorarios.remove(posicion);
            }
        }
    }

    public void generarReporte(){
        Map parametros = new HashMap();
        GenerarReporte.getInstancia().mostrarReporte("Listado de Horarios", "ReporteAlumnos.jasper", parametros);
    }
}
