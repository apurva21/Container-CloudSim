package org.cloudbus.cloudsim.examples.container;

import java.util.Random;
public class Wolf {
    private int[] position; // Array representing the solution (container placement)
    private double fitness; // Fitness value of the solution

    private int[] alphaWolf; // Position of alpha wolf
    private int[] betaWolf;  // Position of beta wolf
    private int[] deltaWolf; // Position of delta wolf

    public Wolf(int numVms, int numContainers) {
        position = new int[numContainers];
        // Initialize the position randomly
        for (int i = 0; i < numContainers; i++) {
            position[i] = new Random().nextInt(numVms) + 1; // Random VM index (1 to numVms)
        }
    }

    public int[] getPosition() {
        return position;
    }

    public void setPosition(int[] newPosition) {
        this.position = newPosition;
    }

    public void setAlphaWolf(int[] alphaWolf) {
        this.alphaWolf = alphaWolf;
    }

    public void setBetaWolf(int[] betaWolf) {
        this.betaWolf = betaWolf;
    }

    public void setDeltaWolf(int[] deltaWolf) {
        this.deltaWolf = deltaWolf;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    public void updatePosition(double a, int maxVmIndex) {
        for (int i = 0; i < position.length; i++) {
            double r1 = new Random().nextDouble();
            double r2 = new Random().nextDouble();

            double A1 = 2 * a * r1 - a;
            double C1 = 2 * r2;

            double D_alpha = Math.abs(C1 * alphaWolf[i] - position[i]);
            double D_beta = Math.abs(C1 * betaWolf[i] - position[i]);
            double D_delta = Math.abs(C1 * deltaWolf[i] - position[i]);

            double X1 = alphaWolf[i] - A1 * D_alpha;
            double X2 = betaWolf[i] - A1 * D_beta;
            double X3 = deltaWolf[i] - A1 * D_delta;

            // Update the wolf's position
            position[i] = boundPosition((int) Math.round((X1 + X2 + X3) / 3), maxVmIndex);
        }
    }

    private int boundPosition(int position, int maxVmIndex) {
        if (position <= 0) {
            return 1;
        } else if (position > maxVmIndex) {
            return maxVmIndex;
        }
        return position;
    }
}
