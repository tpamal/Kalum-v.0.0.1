package org.kalum.core.models;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name ="clase")
@NamedQueries({@NamedQuery(name = "Clase.findAll", query = "from Clase")})
public class Clase implements Serializable {
    private final StringProperty claseid;
    private final StringProperty descripcion;
    private final IntegerProperty ciclo;
    private final IntegerProperty cupoMaximo;
    private final IntegerProperty cupoMinimo;
    private Horario horario;
    private Instructor instructor;
    private Salon salon;
    private Carrera_Tecnica carreraTecnica;

    public Clase(){
        this.claseid = new SimpleStringProperty();
        this.descripcion = new SimpleStringProperty();
        this.ciclo = new SimpleIntegerProperty();
        this.cupoMaximo = new SimpleIntegerProperty();
        this.cupoMinimo = new SimpleIntegerProperty();
    }

    @Id
    @Column(name = "clase_id")
    public String getClaseid() {
        return claseid.get();
    }

    public StringProperty claseid() {
        return claseid;
    }

    public void setClaseid(String claseid) {
        this.claseid.set(claseid);
    }
    @Column(name ="descripcion")
    public String getDescripcion() {
        return descripcion.get();
    }

    public StringProperty descripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion.set(descripcion);
    }

    @Column(name = "ciclo")
    public int getCiclo() {
        return ciclo.get();
    }

    public IntegerProperty ciclo() {
        return ciclo;
    }

    public void setCiclo(int ciclo) {
        this.ciclo.set(ciclo);
    }

    @Column(name = "cupo_Maximo")
    public int getCupoMaximo() {
        return cupoMaximo.get();
    }

    public IntegerProperty cupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        this.cupoMaximo.set(cupoMaximo);
    }

    @Column(name = "cupo_Minimo")
    public int getCupoMinimo() {
        return cupoMinimo.get();
    }

    public IntegerProperty cupoMinimo() {
        return cupoMinimo;
    }

    public void setCupoMinimo(int cupoMinimo) {
        this.cupoMinimo.set(cupoMinimo);
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name ="horarioId")
    public Horario getHorario() {
        return horario;
    }

    public void setHorario(Horario horario) {
        this.horario = horario;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "salonId")
    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "instructorId")
    public Instructor getInstructor() {
        return instructor;
    }

    public void setInstructor(Instructor instructor) {
        this.instructor = instructor;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "codigoCarrera")
    public Carrera_Tecnica getCarreraTecnica() {
        return carreraTecnica;
    }

    public void setCarreraTecnica(Carrera_Tecnica carreraTecnica) {
        this.carreraTecnica = carreraTecnica;
    }
}
