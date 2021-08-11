package org.kalum.core.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.kalum.core.db.ConexionPU;
import org.kalum.core.models.Alumno;
import org.kalum.core.models.Salon;
import org.kalum.core.sistema.Main;
import org.kalum.core.utils.KalumException;
import org.kalum.core.utils.KalumViewMessage;

import java.net.URL;
import java.util.ResourceBundle;

public class SalonCUController implements Initializable {
    @FXML TextField txtSalonId;
    @FXML TextField txtCapacidad;
    @FXML TextField txtDescripcion;
    @FXML TextField txtNombreSalon;

    private Main escenarioPrinicipal;
    private Salon salon;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void guardar() {
        try {
            if (salon == null) {
                Salon salon = new Salon();
                salon.setSalonId(txtSalonId.getText());
                salon.setCapacidad(txtCapacidad.getText());
                salon.setDescripcion(txtDescripcion.getText());
                salon.setNombreSalon(txtNombreSalon.getText());
                ConexionPU.getInstancia().agregar(salon);
                Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
                aviso.setTitle("kalum v1");
                aviso.setHeaderText("Administracion de Salon");
                aviso.setContentText("Registro almacenado correctamente");
                aviso.show();
            } else {
                salon.setSalonId(txtSalonId.getText());
                salon.setCapacidad(txtCapacidad.getText());
                salon.setDescripcion(txtDescripcion.getText());
                salon.setNombreSalon(txtNombreSalon.getText());
                ConexionPU.getInstancia().modificar(salon);
                Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
                aviso.setTitle("kalum v1");
                aviso.setHeaderText("Administracion de Salon");
                aviso.setContentText("Registro modificado correctamente");
                aviso.show();
            }
            this.escenarioPrinicipal.mostrarEscenarioSalon();
        } catch (
                KalumException e) {
            KalumViewMessage.getInstancia().mostrarMessage("Administracion de Salon", e.getMessage(), 50301);
        }
    }

    public void cancelar(){this.escenarioPrinicipal.mostrarEscenarioSalon();}
    public void setEscenarioPrincipal(Main escenarioPrincipal){
        this.escenarioPrinicipal = escenarioPrincipal;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
        this.txtSalonId.setEditable(false);
        this.txtSalonId.setText(salon.getSalonId());
        this.txtCapacidad.setText(salon.getCapacidad());
        this.txtDescripcion.setText(salon.getDescripcion());
        this.txtNombreSalon.setText(salon.getNombreSalon());
    }
}
