package com.drkiettran.java8.fp;

import java.util.Scanner;
import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Sample Code from Jessica Kerr
 *
 */
public class App {
	public static void main(String[] args) {
		readFromStdin("Knock knock. ").anyMatch(s -> s.equals("Who's there?"));
		System.out.println("Boo.");
		readFromStdin("").anyMatch(s -> s.equals("Boo who?"));
		System.out.println("You don't have to cry about it.");
	}

	private static Stream<String> readFromStdin(String prompt) {
		Scanner scanner = new Scanner(System.in);
		Supplier<String> stdin = () -> {
			System.out.print(prompt);
			return scanner.nextLine();
		};
		return Stream.generate(stdin);
	}
}
