package com.example.demo.personnages;

public interface Personnage {
    float getTaille();
    void setTaille(float taille);
    boolean isSwag();
    void setSwag(boolean swag);
    String getAction();
    void setAction(String action);
    int getPv();
    void setPv(int pv);
    void subirDegats(int degats);

    default int calculerDegats() {
        int degats = 5;
        degats += (int) (getTaille() / 20);
        if (isSwag()) {
            degats += 3;
        }
        return degats;
    }
}