package de.labathome.netlib_mnwe;

import java.util.Random;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import dev.ludovic.netlib.lapack.LAPACK;

public class NetlibMNWE {

	@Test
	void dlangeNullWksp() {
		LAPACK lapack = LAPACK.getInstance();
	
		int n = 13;
		double[] greensFunction = new double[n * n];
		
		Random rnd = new Random();
		rnd.setSeed(42);
		
		for (int i=0; i<n*n; ++i) {
			greensFunction[i] = rnd.nextDouble();
		}
		
		final String norm = "1";
		//double[] w = new double[0]; // works
		double[] w = null; // does not work
		final double aNorm = lapack.dlange(norm, n, n, greensFunction, n, w);
		
		System.out.println(aNorm);
		Assertions.assertEquals(aNorm, 8.347588916043293);
	}
	
}
