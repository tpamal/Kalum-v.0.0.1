package org.kalum.core.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.kalum.core.db.ConexionPU;
import org.kalum.core.models.Carrera_Tecnica;
import org.kalum.core.models.Salon;
import org.kalum.core.sistema.Main;
import org.kalum.core.utils.KalumException;
import org.kalum.core.utils.KalumViewMessage;

import java.net.URL;
import java.util.ResourceBundle;

public class CarreraTecnicaCUController implements Initializable {
    @FXML TextField txtCodigoCarrera;
    @FXML TextField txtNombre;

    private Main escenarioPrinicipal;
    private Carrera_Tecnica carreraTecnica;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void guardar() {
        try {
        if (carreraTecnica == null) {
                Carrera_Tecnica carreraTecnica = new Carrera_Tecnica();
                carreraTecnica.setCodigoCarrera(txtCodigoCarrera.getText());
                carreraTecnica.setNombre(txtNombre.getText());
                ConexionPU.getInstancia().agregar(carreraTecnica);
                Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
                aviso.setTitle("kalum v1");
                aviso.setHeaderText("Administracion de Carreras Tecnicas");
                aviso.setContentText("Registro almacenado correctamente");
                aviso.show();
            }else{
                carreraTecnica.setCodigoCarrera(txtCodigoCarrera.getText());
                carreraTecnica.setNombre(txtNombre.getText());
                ConexionPU.getInstancia().modificar(carreraTecnica);
                Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
                aviso.setTitle("kalum v1");
                aviso.setHeaderText("Administracion de Carrera Tecnica");
                aviso.setContentText("Registro modificado correctamente");
                aviso.show();
            }
            this.escenarioPrinicipal.mostrarEscenarioCarreraTecnica();
        }catch(KalumException e){
            KalumViewMessage.getInstancia().mostrarMessage("Administracion de Carrera Tecnica", e.getMessage(), 50301);
        }
    }

    public void cancelar(){this.escenarioPrinicipal.mostrarEscenarioCarreraTecnica();}
    public void setEscenarioPrincipal(Main escenarioPrincipal){
        this.escenarioPrinicipal = escenarioPrincipal;
    }

    public Carrera_Tecnica getCarreraTecnica() {
        return carreraTecnica;
    }

    public void setCarreraTecnica(Carrera_Tecnica carreraTecnica) {
        this.carreraTecnica = carreraTecnica;
        this.txtCodigoCarrera.setEditable(false);
        this.txtCodigoCarrera.setText(carreraTecnica.getCodigoCarrera());
        this.txtNombre.setText(carreraTecnica.getNombre());

    }

}
