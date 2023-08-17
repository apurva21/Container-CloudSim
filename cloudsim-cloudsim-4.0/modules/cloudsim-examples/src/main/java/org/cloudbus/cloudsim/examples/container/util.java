package org.cloudbus.cloudsim.examples.container;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.cloudbus.cloudsim.Cloudlet;
import org.cloudbus.cloudsim.util.WorkloadFileReader;

import java.io.FileNotFoundException;
import java.util.List;

/**
 *
 * @author osman
 */
public class util {
	public static void main(String[] args) {
		readSWFWorkload();
		
	}
    public static int[] discretizeSol(double[] sol) {
        int[] discreteSol = new int[sol.length];

        for (int i = 0; i < sol.length; i++) {
            discreteSol[i] = (int) sol[i];
        }

        return discreteSol;
    }

    public static List<Cloudlet> readSWFWorkload() {
        //Read Cloudlets from workload file in the swf format
        WorkloadFileReader workloadFileReader = null;
        try {
            workloadFileReader = new WorkloadFileReader("C:\\Users\\Lenovo\\Mtech\\HPC2N-2002-1.1-cln.swf", 1);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //generate cloudlets from workload file
        List<Cloudlet> cloudletList = workloadFileReader.generateWorkload();
        return cloudletList;
    }
}