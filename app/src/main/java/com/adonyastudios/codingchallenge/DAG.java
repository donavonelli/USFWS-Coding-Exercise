package com.adonyastudios.codingchallenge;

import java.util.ArrayList;

public class DAG {

//    public Vertex vertex;
//    public ArrayList<Vertex> connectedVertices = new ArrayList<Vertex>();

//    DAG(Vertex vertexImported){
//        this.vertex = vertexImported;
//    }
    private int longestPathStepCount = 0;
    private String pathing = "";

    public void connectVertices(Vertex startingVertex, Vertex pointToVertex){
        //edge case 1 : to prevent connecting to itself
        if (startingVertex.equals(pointToVertex)){
            System.err.println("Cannot connect to itself");
        } //edge case 2 : the vertex already is connected to
        else if(startingVertex.connectedVertices.contains(pointToVertex)){
            System.err.println("Cannot have duplicate connections");
        } //edge case 3 :  the vertex that is attempting to be connected to already connects to this one + no backwards movement
        else if(pointToVertex.connectedVertices.contains(startingVertex)){
            System.err.println("Cannot connect to previous Vertex");
        } //edge case 4 : preventing connecting a vector in the opposite direction
        else if(startingVertex.layer>pointToVertex.layer){
            System.err.println("Cannot connect to a Vertex on a higher level");
        }else{
            if(!startingVertex.connectedVertices.isEmpty()) {

                //edge case 5 : preventing connecting a vector connection in the opposite direction
                for (int i = 0; i < startingVertex.connectedVertices.size(); i++) {
                    if (startingVertex.connectedVertices.get(i).layer > pointToVertex.layer) {
                        System.err.println("Cannot contain a Vertex that connects to a higher layer"+ startingVertex +" "+ pointToVertex);
                        break;
                    }
                }
            }
            startingVertex.connectedVertices.add(pointToVertex);
        }
    }

    public String calculateLongestPath(Vertex vertex){
        int totalSteps =0;
        // case 6 : Vertex doesn't have any other connections
        if(vertex.connectedVertices.isEmpty()){
            System.out.println( "Vertex: "+ vertex.name+" has no other connections making its longest path 1");
            return "Vertex: "+ vertex.name+" has no other connections making its longest path 1";
        }

        for (Vertex outsideVertex:
             vertex.connectedVertices) {
            int insideSteps =1;
            System.out.println("From given vertex: "+vertex.name+ " stepped to: "+ outsideVertex.name);
            if(pathing.isEmpty()){
                pathing = vertex.name + " -> "+outsideVertex.name;
            }
            System.out.println("Starting on step: "+ insideSteps);
            if (!outsideVertex.connectedVertices.isEmpty()){
                System.out.println(outsideVertex.name+ " goes deeper. It connects to "+ outsideVertex.connectedVertices);
                deeperComputation(outsideVertex,outsideVertex.connectedVertices,insideSteps);
            }
        }
        System.out.println("The longest path of Vertex "+ vertex.name+ " is \n"+
                pathing);
        return null;
    }

    private ArrayList<Vertex> deeperComputation(Vertex vertex,ArrayList<Vertex> vertexArrayList, int stepCount){
        int startingStepCount = stepCount;
        String startingPathing = pathing;
        for (Vertex insideVertex:vertexArrayList
             ) {
            stepCount=startingStepCount;
            pathing = startingPathing;
            if(!insideVertex.connectedVertices.isEmpty()){
                stepCount++;
                if(stepCount>longestPathStepCount){
                    pathing += " -> "+ insideVertex.name ;
                    System.out.println("Starting Pathing: "+ pathing);
                    longestPathStepCount=stepCount;
                }
                System.out.println("Current vertex is: "+vertex.name+ " stepping to: "+ insideVertex.name+ " and on step: "+ stepCount);
                deeperComputation(insideVertex, insideVertex.connectedVertices,stepCount);
            } else{
                stepCount++;
                System.out.println("stepped from: "+ vertex+ " to: "+ insideVertex+" and ended the journey on step: "+ stepCount);
                if(stepCount>longestPathStepCount){
                    pathing += " -> "+ insideVertex.name ;
                    System.out.println("ending pathing: "+ pathing);
                    longestPathStepCount=stepCount;
                }
            }
        }
        return null;
    }

}
