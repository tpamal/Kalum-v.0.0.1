package org.kalum.core.controllers;

import javafx.fxml.Initializable;
import org.kalum.core.sistema.Main;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    private Main escenarioPrincipal;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
    public void ventanaAlumnos(){
        this.escenarioPrincipal.mostrarEscenaAlumnos();
    }

    public void ventanaCarreraTecnica(){
        this.escenarioPrincipal.mostrarEscenarioCarreraTecnica();
    }

    public void ventanaHorario(){
        this.escenarioPrincipal.mostrarEscenarioHorario();
    }

    public void ventanaSalon(){
        this.escenarioPrincipal.mostrarEscenarioSalon();
    }

    public void ventanaInstructor(){
        this.escenarioPrincipal.mostrarEscenarioInstructor();
    }

    public void ventanaClases(){
        this.escenarioPrincipal.mostrarEscenarioClases();
    }

    public void setEscenarioPrincipal(Main escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
    }

    public void cerrarSesion(){
        this.escenarioPrincipal.mostrarVentanaLogin();
    }
}
