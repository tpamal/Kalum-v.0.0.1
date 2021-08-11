package org.kalum.core.sistema;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.kalum.core.controllers.*;
import org.kalum.core.models.*;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;

public class Main extends Application {

    private final String paquete_View = "../views/";
    private Stage escenarioPrincipal;

    @Override
    public void start(Stage escenarioPrincipal) throws Exception{
        this.escenarioPrincipal = escenarioPrincipal;
        this.escenarioPrincipal.setTitle("Kalum v1");
        //this.escenarioPrincipal.initStyle(StageStyle.UNDECORATED);
        this.mostrarVentanaLogin();
        this.escenarioPrincipal.show();
    }

    public void mostrarVentanaLogin(){
        try{
            LoginController controlador = (LoginController) this.cambiarEscena("LoginView.fxml", 206, 415);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenaAlumnos(){
        try {
           AlumnoController controlador = (AlumnoController)this.cambiarEscena("AlumnoView.fxml",355 , 600);
           controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public void mostrarEscenarioClases(){
        try {
            ClaseController controlador = (ClaseController) this.cambiarEscena("ClaseView.fxml",319 , 776);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenaClaseCU(){
        try {
            ClaseCUController controlador = (ClaseCUController) this.cambiarEscena("ClaseCUView.fxml", 400 ,600);
            controlador.setEscenarioPrincipal(this);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenaClaseCU(Clase elemento){
        try{
            ClaseCUController controlador = (ClaseCUController)this.cambiarEscena("ClaseCUView.fxml",400, 600);
            controlador.setClase(elemento);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenaPrincipal(){
        try{
           MainController controlador =  (MainController)this.cambiarEscena("MainView.fxml", 400, 600);
           controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenaAlumnoCU(){
        try{
            AlumnoCUController controlador = (AlumnoCUController)this.cambiarEscena("AlumnoCUView.fxml",292, 468);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenaAlumnoCU(Alumno elemento){
        try{
            AlumnoCUController controlador = (AlumnoCUController)this.cambiarEscena("AlumnoCUView.fxml",292, 468);
           controlador.setAlumno(elemento);
           controlador.setEscenarioPrincipal(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioCarreraTecnica(){
        try{
            CarreraTecnicaController controlador = (CarreraTecnicaController)this.cambiarEscena("CarreraTecnicaView.fxml", 319, 377);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioCarreraTecnicaCU(){
        try {
            CarreraTecnicaCUController controlador = (CarreraTecnicaCUController)this.cambiarEscena("CarreraTecnicaCUView.fxml" ,195 , 423);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioCarreraTecnicaCU(Carrera_Tecnica elemento){
        try{
            CarreraTecnicaCUController controlador = (CarreraTecnicaCUController) this.cambiarEscena("CarreraTecnicaCUView.fxml",195, 423);
            controlador.setCarreraTecnica(elemento);
            controlador.setEscenarioPrincipal(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioHorario(){
        try {
            HorarioController controlador = (HorarioController)this.cambiarEscena("HorarioView.fxml", 323, 429);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioHorarioCU(){
        try {
            HorarioCUController controlador = (HorarioCUController)this.cambiarEscena("HorarioCUView.fxml",199 , 354);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

        public void mostrarEscenaHorarioCUS(Horario elemento){
        try{
            HorarioCUController controlador = (HorarioCUController) this.cambiarEscena("HorarioCUView.fxml",292, 468);
            controlador.setHorario(elemento);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioSalon(){
        try {
            SalonController controlador = (SalonController)this.cambiarEscena("SalonView.fxml", 400,600);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioSalonCU(){
        try {
            SalonCUController controlador = (SalonCUController)this.cambiarEscena( "SalonCUView.fxml", 225,406);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioSalonCU(Salon elemento){
        try{
            SalonCUController controlador = (SalonCUController) this.cambiarEscena("SalonCUView.fxml",225, 406);
            controlador.setSalon(elemento);
            controlador.setEscenarioPrincipal(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioInstructor(){
        try{
            InstructorController controlador = (InstructorController)this.cambiarEscena("InstructorView.fxml", 318, 748);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioInstructorCU(){
        try {
            InstructorCUController controlador = (InstructorCUController)this.cambiarEscena("IntructorCUView.fxml", 391, 595);
            controlador.setEscenarioPrincipal(this);
        }catch (IOException e ){
            e.printStackTrace();
        }
    }

    public void mostrarEscenarioInstructorCU(Instructor elemento){
        try{
            InstructorCUController controlador = (InstructorCUController) this.cambiarEscena("IntructorCUView.fxml",391, 595);
            controlador.setIntructor(elemento);
            controlador.setEscenarioPrincipal(this);

        }catch (IOException e){
            e.printStackTrace();
        }
    }
    


    //Metodo para cambiar en el  escenario principal
    public Initializable cambiarEscena(String escena, int ancho, int alto) throws IOException {
        Initializable resultado = null;

        //Cargador del archivo XML
        FXMLLoader cargadorFXML = new FXMLLoader();
        //Asignar logica del archivo
        InputStream archivo = Main.class.getResourceAsStream(this.paquete_View + escena);
        //Cargador de fabrica para cargar el archivo FXML
        cargadorFXML.setBuilderFactory(new JavaFXBuilderFactory());
        //Ubicacion del archivo FXML que se pintara en la escena
        cargadorFXML.setLocation(PrintStream.class.getResource(this.paquete_View + escena));
        //Creacion de la escena
        Scene nuevaEscena = new Scene((AnchorPane)cargadorFXML.load(archivo), alto,ancho);
        //Agregando hoja de estilos
        nuevaEscena.getStylesheets().add("org/kalum/core/resources/styles/estilo.css");
        //Mostrar la escena en el escenario principal
        this.escenarioPrincipal.setScene(nuevaEscena);
        //Ajustar el tamaño del escenario a la escena que se desea mostrar
        this.escenarioPrincipal.sizeToScene();
        //obtener el controlador del archivo FXML
        resultado = (Initializable) cargadorFXML.getController();
        //retornar el controlador de la vista que se esta mostrando
        return resultado;
    }

    /*
    public Initializable cambiarEscena(String escena, int ancho, int alto) throws IOException {
        Initializable resultado = null;
        FXMLLoader cargadorFXML = new FXMLLoader(getClass().getResource(this.paquete_View + escena));
        AnchorPane root = (AnchorPane) cargadorFXML.load();
        Scene scene = new Scene(root, ancho, alto);
        scene.getStylesheets().add("org/kalum/core/resources/styles/estilo.css");
        this.escenarioPrincipal.setScene(scene);
        this.escenarioPrincipal.sizeToScene();
        resultado = (Initializable) cargadorFXML.getController();
        return resultado;
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}
