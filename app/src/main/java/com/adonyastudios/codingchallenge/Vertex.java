package com.adonyastudios.codingchallenge;

import java.util.ArrayList;

public class Vertex {
    public String name;
    public int layer;
    public ArrayList<Vertex> toVertices = new ArrayList<>();
    public ArrayList<Vertex> fromVertices = new ArrayList<>();
    Vertex(String nameImported,int layerImported){
        this.name = nameImported;
        this.layer = layerImported;
    }

    @Override
    public String toString(){
        return this.name+" on layer "+this.layer;
    }


}
