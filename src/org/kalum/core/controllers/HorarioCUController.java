package org.kalum.core.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.DataFormat;
import org.kalum.core.db.ConexionPU;
import org.kalum.core.models.Horario;
import org.kalum.core.sistema.Main;


import javax.xml.ws.Holder;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.UUID;

public class HorarioCUController implements Initializable {
    @FXML private ComboBox cbmHorarioInicio;
    @FXML private ComboBox cmbHorarioFinal;

    private Main escenarioPrinicipal;
    private Horario horario;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        this.cbmHorarioInicio.getItems().addAll("08:00", "8:30", "9:00");
        this.cmbHorarioFinal.getItems().addAll("10:00", "10:30", "11:00");
    }

    public void guardar(){
            Horario horario = new Horario();
            String horarioInicio  = cbmHorarioInicio.getSelectionModel().getSelectedItem().toString();
            String horarioFinal = cmbHorarioFinal.getSelectionModel().getSelectedItem().toString();
            DateFormat formato = new SimpleDateFormat("HH:mm");
        try {
            if(horario == null){
            Date horaInicio = formato.parse(horarioInicio.concat(":00"));
            Date horaFinal = formato.parse(horarioFinal.concat(":00"));
            horario.setHorarioInicio(horaInicio);
            horario.setHorarioFinal(horaFinal);
            ConexionPU.getInstancia().agregar(horario);
            Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
            aviso.setTitle("Kalum v1.0.0");
            aviso.setHeaderText("Administracion de Horarios");
            aviso.setContentText("Registro almacenado Correctamente!!");
            aviso.show();
            }else{
                Date horaInicio = formato.parse(horarioInicio.concat(":00"));
                Date horaFinal = formato.parse(horarioFinal.concat(":00"));
                horario.setHorarioInicio(horaInicio);
                horario.setHorarioFinal(horaFinal);
                ConexionPU.getInstancia().modificar(horario);
                Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
                aviso.setTitle("kalum v1");
                aviso.setHeaderText("Administracion de Horarios");
                aviso.setContentText("Registro modificado correctamente");
                aviso.show();
            }
            this.escenarioPrinicipal.mostrarEscenarioHorario();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void cancelar(){
        this.escenarioPrinicipal.mostrarEscenarioHorario();
    }
    public void setEscenarioPrincipal(Main escenarioPrincipal) {
        this.escenarioPrinicipal = escenarioPrincipal;
    }

    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
        this.cbmHorarioInicio.getSelectionModel().select(String.valueOf(horario.getHorarioInicio()));
        this.cmbHorarioFinal.getSelectionModel().select(String.valueOf(horario.getHorarioFinal()));
    }
}
