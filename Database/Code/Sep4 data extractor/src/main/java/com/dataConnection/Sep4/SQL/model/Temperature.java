package com.dataConnection.Sep4.SQL.model;

import javax.persistence.*;
import java.util.Date;


@Entity
@Table(name = "Temperature")
public class Temperature {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private int id;

    @ManyToOne
    private Room room;

    @Column(name = "status")
    private String status;

    @Column(name = "Timestamp")
    private Date date;

    @Column(name = "value")
    private String value;

    @Column(name = "date")
    private Date localDate;


    public Temperature(){

    }

    public Temperature(Date localDate, String status, Date date, String value,  Room room) {
        this.localDate = localDate;
        this.status = status;
        this.date = date;
        this.value = value;
        this.room = room;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getId() { return id; }

    public void setId(int id) { this.id = id; }

    public Date getDate() { return date; }

    public void setDate(Date date) { this.date = date; }


    public Date getLocalDate() {
        return localDate;
    }

    public void setLocalDate(Date localDate) {
        this.localDate = localDate;
    }

    @Override
    public String toString() {
        return "Temperature{" +
                "id=" + id +
                ", room=" + room +
                ", status='" + status + '\'' +
                ", date=" + date +
                ", value='" + value + '\'' +
                ", localDate=" + localDate +
                '}';
    }
}