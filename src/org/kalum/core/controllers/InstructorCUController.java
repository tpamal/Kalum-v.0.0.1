package org.kalum.core.controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import org.kalum.core.db.ConexionPU;
import org.kalum.core.models.Instructor;
import org.kalum.core.models.Salon;
import org.kalum.core.sistema.Main;
import org.kalum.core.utils.KalumException;
import org.kalum.core.utils.KalumViewMessage;

import java.net.URL;
import java.util.ResourceBundle;

public class InstructorCUController implements Initializable {
    @FXML private TextField txtInstructorId;
    @FXML private TextField txtApellidos;
    @FXML private TextField txtNombres;
    @FXML private TextField txtDireccion;
    @FXML private TextField txtTelefono;
    @FXML private TextField txtFoto;
    @FXML private TextField txtEstatus;
    @FXML private TextField txtComentario;

    private Main escenarioPrinicipal;
    private Instructor instructor;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }


    public void guardar() {
        try {
            if (instructor == null) {
                Instructor instructor = new Instructor();
                instructor.setInstructorId(txtInstructorId.getText());
                instructor.setApellidos(txtApellidos.getText());
                instructor.setComentario(txtComentario.getText());
                instructor.setDireccion(txtDireccion.getText());
                instructor.setEstatus(txtEstatus.getText());
                instructor.setFoto(txtFoto.getText());
                instructor.setNombres(txtNombres.getText());
                instructor.setTelefono(txtTelefono.getText());
                ConexionPU.getInstancia().agregar(instructor);
                Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
                aviso.setTitle("kalum v1");
                aviso.setHeaderText("Administracion de Instructor");
                aviso.setContentText("Registro almacenado correctamente");
                aviso.show();
            } else {
                instructor.setInstructorId(txtInstructorId.getText());
                instructor.setApellidos(txtApellidos.getText());
                instructor.setComentario(txtComentario.getText());
                instructor.setDireccion(txtDireccion.getText());
                instructor.setEstatus(txtEstatus.getText());
                instructor.setFoto(txtFoto.getText());
                instructor.setNombres(txtNombres.getText());
                instructor.setTelefono(txtTelefono.getText());
                ConexionPU.getInstancia().modificar(instructor);
                Alert aviso = new Alert(Alert.AlertType.CONFIRMATION);
                aviso.setTitle("kalum v1");
                aviso.setHeaderText("Administracion de Instructor");
                aviso.setContentText("Registro modificado correctamente");
                aviso.show();
            }
            this.escenarioPrinicipal.mostrarEscenarioInstructor();
        } catch (KalumException e) {
            KalumViewMessage.getInstancia().mostrarMessage("Administracion de Instructor", e.getMessage(), 50301);
        }
    }

    public void cancelar() {this.escenarioPrinicipal.mostrarEscenarioInstructor();}
    public void setEscenarioPrincipal(Main escenarioPrincipal){
        this.escenarioPrinicipal = escenarioPrincipal;
    }


    public Instructor getInstructor() {
        return instructor;
    }

    public void setIntructor(Instructor instructor) {
        this.instructor = instructor;
        this.txtInstructorId.setEditable(false);
        this.txtInstructorId.setText(instructor.getInstructorId());
        this.txtApellidos.setText(instructor.getApellidos());
        this.txtComentario.setText(instructor.getComentario());
        this.txtDireccion.setText(instructor.getDireccion());
        this.txtEstatus.setText(instructor.getEstatus());
        this.txtFoto.setText(instructor.getFoto());
        this.txtNombres.setText(instructor.getNombres());
        this.txtTelefono.setText(instructor.getTelefono());

    }

}
