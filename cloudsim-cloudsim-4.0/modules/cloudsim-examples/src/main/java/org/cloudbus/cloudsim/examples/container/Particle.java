package org.cloudbus.cloudsim.examples.container;

import java.util.Random;

public class Particle {
	 private int[] position;
     private double[] velocity;
     private double bestFitness;
     private int[] bestPosition;

     public Particle(int numVMs, int numContainers) {
         this.position = new int[numContainers];
         this.velocity = new double[numContainers];
         this.bestFitness = Double.MAX_VALUE;
         this.bestPosition = new int[numContainers];

         // Initialize position and velocity randomly
         Random random = new Random();
         for (int i = 0; i < numContainers; i++) {
             this.position[i] = random.nextInt(numVMs)+1;
             this.velocity[i] = random.nextDouble();
         }
     }

     public int[] getPosition() {
         return position;
     }

     public void setPosition(int[] position) {
         this.position = position;
     }

     public double[] getVelocity() {
         return velocity;
     }

     public void setVelocity(double[] velocity) {
         this.velocity = velocity;
     }

     public double getBestFitness() {
         return bestFitness;
     }

     public void setBestFitness(double bestFitness) {
         this.bestFitness = bestFitness;
     }

     public int[] getBestPosition() {
         return bestPosition;
     }

     public void setBestPosition(int[] bestPosition) {
         this.bestPosition = bestPosition;
     }
 }



