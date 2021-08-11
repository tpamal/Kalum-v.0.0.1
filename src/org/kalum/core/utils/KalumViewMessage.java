package org.kalum.core.utils;

import javafx.scene.control.Alert;

public class KalumViewMessage {

    public static KalumViewMessage instancia;
    public static KalumViewMessage getInstancia(){
        if (instancia == null){
            instancia = new KalumViewMessage();
        }
        return instancia;
    }

    public void mostrarMessage(String cabecera, String mensaje, int codigoError){
        if(String.valueOf(codigoError).substring(0,3).equals("503")){
            Alert aviso = new Alert(Alert.AlertType.ERROR);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText(cabecera);
            aviso.setContentText(mensaje);
            aviso.show();
        }else if(String.valueOf(codigoError).substring(0,3).equals("400")){
            Alert aviso = new Alert(Alert.AlertType.WARNING);
            aviso.setTitle("kalum v1");
            aviso.setHeaderText(cabecera);
            aviso.setContentText(mensaje);
            aviso.show();
        }
    }
}
