package com.adonyastudios.codingchallenge;

import java.util.ArrayList;

public class Vertex {
    public String name;
    public int layer;
    public ArrayList<Vertex> connectedVertices = new ArrayList<>();
    Vertex(String nameImported,int layerImported){
        this.name = nameImported;
        this.layer = layerImported;
    }

    @Override
    public String toString(){
        return this.name+" on layer "+this.layer;
    }


}
