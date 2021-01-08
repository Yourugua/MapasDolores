package com.cadol.mapasdolores;

public class CADOL {

    private String nombre;
    private double lat;
    private double lon;
    private int foto;

    public CADOL(int foto, String nombre, double lat, double lon) {
        this.nombre = nombre;
        this.lat = lat;
        this.lon = lon;
        this.foto = foto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getLat() { return lat; }

    public void setLat(double lat) { this.lat = lat; }

    public double getLon() { return lon; }

    public void setLon(double lon) { this.lon = lon; }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

}
