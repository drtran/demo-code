package com.bemach.aep.utility;

import java.io.IOException;
import java.util.Scanner;

public class MeanStdDevCalculator {
	public static void main(String... args) throws IOException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("number of reals: ");
		Integer n = scanner.nextInt();

		if (n <= 0 || n > 10) {
			System.err.println("ERROR! Invalid value entered (must be > 0 & < 10)");
			System.exit(-1);
		}

		Float sum = 0.0f;
		Float[] floats = new Float[n];

		for (int i = 0; i < n; i++) {
			floats[i] = scanner.nextFloat();
		}

		for (Float f : floats) {
			sum += f;
		}

		float mean = sum / n;

		System.out.println("mean: " + mean);

		Float sumOfSqrs = 0.0f;

		for (float f : floats) {
			sumOfSqrs += (float) Math.pow(f - mean, 2);
		}

		Float stdDev = (float) (Math.sqrt(sumOfSqrs) / n);

		System.out.println("stddev: " + stdDev);
	}
}
