package org.kalum.core.models;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "carreraTecnica")
@NamedQueries({@NamedQuery(name="Carrera_Tecnica.findAll", query = "from Carrera_Tecnica")})

public class Carrera_Tecnica implements Serializable {
    private final StringProperty codigoCarrera;
    private final StringProperty nombre;
    private List<Clase> clase;

public Carrera_Tecnica() {
    this.codigoCarrera = new SimpleStringProperty();
    this.nombre = new SimpleStringProperty();
}

    @Override
    public String toString(){
        return this.getNombre();
    }

    @Id
    @Column(name = "codigoCarrera")
    public String getCodigoCarrera(){
    return this.codigoCarrera.get();
    }

    public void setCodigoCarrera(String codigoCarrera){
    this.codigoCarrera.set(codigoCarrera);
    }
    public StringProperty codigoCarrera(){
    return this.codigoCarrera;
    }

    @Column(name = "nombre")
    public String getNombre(){
    return this.nombre.get();
    }

    public void setNombre(String nombre){
    this.nombre.set(nombre);
    }

    public StringProperty nombre(){
    return this.nombre;
    }

    @OneToMany(mappedBy = "carreraTecnica", fetch =FetchType.LAZY)
    public List<Clase> getClase() {
        return clase;
    }

    public void setClase(List<Clase> clase) {
        this.clase = clase;
    }
}
