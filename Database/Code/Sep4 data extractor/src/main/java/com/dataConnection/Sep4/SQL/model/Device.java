package com.dataConnection.Sep4.SQL.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name = "Device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private int Id;
    @Column(name = "name")
    private String name;
    @Column(name = "UIE")
    private String uie;

    public Device() {
        super();
    }

    public Device(String name, String uie) {
        super();
        this.name = name;
        this.uie = uie;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUie() {
        return uie;
    }

    public void setUie(String uie) {
        this.uie = uie;
    }

    public void setId(int id) {
        Id = id;
    }

    @Override
    public String toString() {
        return "Device [Id=" + Id + ", name=" + name + ", uie=" + uie + "]";
    }

}

