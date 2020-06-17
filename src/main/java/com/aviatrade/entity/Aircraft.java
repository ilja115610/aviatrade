package com.aviatrade.entity;

import javax.persistence.*;

@Entity
@Table(name = "aircraft")
public class Aircraft {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "aircraft_id")
    private long aircraftId;
    @Column
    private String name;
    @Column
    private int manufacture;
    @Column
    private String location;
    @Column
    private int sn;
    @Column
    private int ttaf;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "owner")
    private User owner;

    @Column
    private String img;

    @Column
    private String reg;

    @Column
    private int price;

    public Aircraft() {
        super();
    }

    public Aircraft(String name, int manufacture, String location, int sn, int ttaf, User owner, String reg) {
        this.name = name;
        this.manufacture = manufacture;
        this.location = location;
        this.sn = sn;
        this.ttaf = ttaf;
        this.owner = owner;
        this.reg = reg;
    }

    public long getAircraftId() {
        return aircraftId;
    }

    public void setAircraftId(long aircraftId) {
        this.aircraftId = aircraftId;
    }

    public String getName() {
        return name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManufacture() {
        return manufacture;
    }

    public void setManufacture(int manufacture) {
        this.manufacture = manufacture;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSn() {
        return sn;
    }

    public void setSn(int sn) {
        this.sn = sn;
    }

    public String getReg() {
        return reg;
    }

    public void setReg(String reg) {
        this.reg = reg;
    }

    public int getTtaf() {
        return ttaf;
    }

    public void setTtaf(int ttaf) {
        this.ttaf = ttaf;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Aircraft{" +
                "aircraft_id=" + aircraftId +
                ", name='" + name + '\'' +
                ", manufacture=" + manufacture +
                ", location='" + location + '\'' +
                ", SN=" + sn +
                ", TTAF=" + ttaf +
                ", user=" + owner +
                '}';
    }
}
