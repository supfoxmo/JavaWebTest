package com.java.bean;

import java.util.Objects;

public class Address {
    private String city;
    private String stress;

    public Address(String city, String stress) {
        this.city = city;
        this.stress = stress;
    }

    public Address() {
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStress() {
        return stress;
    }

    public void setStress(String stress) {
        this.stress = stress;
    }

    @Override
    public String toString() {
        return "Address{" +
                "city='" + city + '\'' +
                ", stress='" + stress + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return Objects.equals(city, address.city) && Objects.equals(stress, address.stress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, stress);
    }
}
