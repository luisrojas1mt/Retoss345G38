package com.example.retos345.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    // ***** ATRIBUTOS *****
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idReservation;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "devolutionDate")
    private Date devolutionDate;

    @Column(name = "status")
    private String status;

    // ***** RELACIONES *****
    // Relacion Muchos a uno. La Reservation tiene enlazados un Client y Un Farm

    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = { "reservations" })
    @JoinColumn(name = "farm_id")
    private Farm farm;

    @ManyToOne(optional = false)
    @JsonIgnoreProperties(value = { "messages", "reservations" })
    @JoinColumn(name = "client_id")
    private Client client;
    // @ManyToOne(fetch = FetchType.LAZY, optional = false)
    // @JoinColumn(name = "ortopedic_id")
    // @JsonProperty(access = Access.WRITE_ONLY)
    // private Ortopedic ortopedic;

    @Column(name = "score")
    private String score;

    // ***** CONSTRUCTOR *****
    public Reservation() {
        this.status = "created";
        this.score = null;
    }

    // ***** METODOS *****

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getDevolutionDate() {
        return devolutionDate;
    }

    public void setDevolutionDate(Date devolutionDate) {
        this.devolutionDate = devolutionDate;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    // public Ortopedic getOrtopedic() {
    // return ortopedic;
    // }

    // public void setOrtopedic(Ortopedic ortopedic) {
    // this.ortopedic = ortopedic;
    // }

    public Farm getFarm() {
        return farm;
    }

    public void setFarm(Farm farm) {
        this.farm = farm;
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

}
