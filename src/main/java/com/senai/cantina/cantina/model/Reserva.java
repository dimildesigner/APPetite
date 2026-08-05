package com.senai.cantina.cantina.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

public class Reserva {

    private Long idReserva;
    private LocalTime horarioReserva;
    private LocalDate dataReserva;

    public Long getIdReserva() {
        return idReserva;
    }

    public void setIdReserva(Long idReserva) {
        this.idReserva = idReserva;
    }

    public LocalTime getHorarioReserva() {
        return horarioReserva;
    }

    public void setHorarioReserva(LocalTime horarioReserva) {
        this.horarioReserva = horarioReserva;
    }

    public LocalDate getDataReserva() {
        return dataReserva;
    }

    public void setDataReserva(LocalDate dataReserva) {
        this.dataReserva = dataReserva;
    }

    public Reserva(){

    }

    public Reserva(Long idReserva, LocalTime horarioReserva, LocalDate dataReserva) {
        this.idReserva = idReserva;
        this.horarioReserva = horarioReserva;
        this.dataReserva = dataReserva;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o)
            return true;
        if(o == null || getClass()!= o.getClass())
            return false;
        Reserva that = (Reserva) o;
        return idReserva != null && idReserva.equals(that.idReserva);
    }

    @Override
    public int hashCode() {
        return Objects.hash(getClass());
    }

}
