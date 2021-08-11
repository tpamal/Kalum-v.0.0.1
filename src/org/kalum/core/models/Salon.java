package org.kalum.core.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "salon")
@NamedQueries({@NamedQuery(name = "Salon.findAll", query = "from Salon")})

public class Salon implements Serializable {
    private final StringProperty salonId;
    private final StringProperty capacidad;
    private final StringProperty descripcion;
    private final StringProperty nombreSalon;
    private List<Clase> clase;

    public Salon() {
        this.salonId = new SimpleStringProperty();
        this.capacidad = new SimpleStringProperty();
        this.descripcion = new SimpleStringProperty();
        this.nombreSalon = new SimpleStringProperty();
    }

    @Override
    public String toString(){
        return this.getNombreSalon();
    }

    @Id
    @Column(name = "salonId")
    public String getSalonId(){
        return this.salonId.get();
    }

    public void setSalonId(String salonId){
        this.salonId.set(salonId);
    }

    public StringProperty salonId(){
        return this.salonId;
    }

    @Column(name = "capacidad")
    public String getCapacidad(){
        return this.capacidad.get();
    }

    public void setCapacidad(String capacidad){
        this.capacidad.set(capacidad);
    }

    public StringProperty capacidad(){
        return this.capacidad;
    }

    @Column(name = "descripcion")
    public String getDescripcion(){
        return this.descripcion.get();
    }

    public void setDescripcion(String descripcion){
        this.descripcion.set(descripcion);
    }

    public StringProperty descripcion(){
        return this.descripcion;
    }

    @Column(name = "nombreSalon")
    public String getNombreSalon(){
        return this.nombreSalon.get();
    }

    public void setNombreSalon(String nombreSalon){
        this.nombreSalon.set(nombreSalon);
    }

    public StringProperty nombreSalon(){
        return this.nombreSalon;
    }

    @OneToMany(mappedBy = "salon", fetch =FetchType.LAZY)
    public List<Clase> getClase() {
        return clase;
    }

    public void setClase(List<Clase> clase) {
        this.clase = clase;
    }
}
