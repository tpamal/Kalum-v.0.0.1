package org.kalum.core.models;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import jdk.nashorn.internal.runtime.ParserException;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Entity
@Table(name = "horario")
@NamedQueries({@NamedQuery(name = "Horario.findAll", query = "from Horario")})
public class Horario implements Serializable {
    private final StringProperty horarioId;
    private final ObjectProperty<Date> horarioInicio;
    private final ObjectProperty<Date> horarioFinal;
    private List<Clase> clase;

    public Horario(){
        this.horarioId = new SimpleStringProperty();
        this.horarioInicio = new SimpleObjectProperty<Date>();
        this.horarioFinal = new SimpleObjectProperty<Date>();
    }

    @Override
    public String toString(){
        //TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        DateFormat formato = new SimpleDateFormat("HH:mm");
        return formato.format(this.getHorarioInicio()).concat(" | ").concat(formato.format(this.getHorarioFinal()));
    }


    @Id
    @Column(name = "horarioId")
    public String getHorarioId(){
    return this.horarioId.get();
    }
    public void setHorarioId(String horarioId){
        this.horarioId.set(horarioId);
    }
    public StringProperty horarioId(){
        return this.horarioId;
    }

    @Column(name = "horario_inicio", nullable = false)
    @Temporal(value = TemporalType.TIME)
    public Date getHorarioInicio(){
    return this.horarioInicio.get();
    }
    public void setHorarioInicio(Date horarioInicio){
        this.horarioInicio.set(horarioInicio);
    }
    public ObjectProperty<Date> horarioInicio(){
        return this.horarioInicio;
    }

    @Column(name = "horario_final", nullable = false)
    @Temporal(value = TemporalType.TIME)
    public Date getHorarioFinal(){
        return this.horarioFinal.get();
    }
    public void setHorarioFinal(Date horarioFinal){
        this.horarioFinal.set(horarioFinal);
    }
    public ObjectProperty<Date> horarioFinal(){
        return this.horarioFinal;
    }

    @OneToMany(mappedBy = "horario", fetch = FetchType.LAZY)
    public List<Clase> getClase() {
        return clase;
    }

    public void setClase(List<Clase> clase) {
        this.clase = clase;
    }
}
