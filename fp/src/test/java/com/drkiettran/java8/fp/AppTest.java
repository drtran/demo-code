package com.drkiettran.java8.fp;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntToDoubleFunction;
import java.util.stream.Collectors;

import org.junit.Test;

public class AppTest {
	private static Integer globalLineNumber;
	private static final String[] args = { "-filename", "abcdef", "-cmd", "grep", "input1", "input2", "input3" };
	private static final List<String> argsList = Arrays.asList(args);

	@Test
	public void test() {

		List<String> keys = argsList.stream().filter(arg -> arg.charAt(0) == '-').collect(Collectors.toList());
		List<String> values = argsList.stream().filter(arg -> arg.charAt(0) != '-').limit(keys.size())
				.collect(Collectors.toList());
		List<String> leftOver = argsList.stream().skip(keys.size() + values.size()).collect(Collectors.toList());

		keys.stream().forEach(System.out::println);
		values.stream().forEach(System.out::println);
		leftOver.stream().forEach(System.out::println);

		String cmd = "";
		String fileName = "";

		for (int i = 0; i < keys.size(); i++) {
			switch (keys.get(i)) {
			case "-cmd":
				cmd = values.get(i);
				break;
			case "-filename":
				fileName = values.get(i);
				break;
			}

		}
	}

	@Test
	public void basicFP() {

		/**
		 * 
		 * java.util.function.IntToDoubleFunction
		 * 
		 * "@FunctionalInterface"
		 * 
		 * Represents a function that accepts an int-valued argument and produces a
		 * double-valued result. This is the int-to-double primitive specialization for
		 * Function.
		 * 
		 * This is a functional interface whose functional method is
		 * "applyAsDouble(int)".
		 * 
		 * Since:
		 * 
		 * 1.8
		 * 
		 * See Also:
		 * 
		 * Function
		 * 
		 */
		IntToDoubleFunction incrementalCost = time -> 5.1 + 0.15 * time;

		/**
		 * 
		 * java.util.function.Function<String, Integer>
		 * 
		 * "@FunctionalInterface"
		 * 
		 * Represents a function that accepts one argument and produces a result. This
		 * is a functional interface whose functional method is "apply(Object)".
		 * 
		 * Since:
		 * 
		 * 1.8
		 * 
		 */
		Function<String, Integer> wordCount = s -> s.split("").length;

		/**
		 * 
		 * java.util.function.BiFunction<String, Integer, Boolean>
		 * 
		 * "@FunctionalInterface"
		 * 
		 * Represents a function that accepts "two arguments" and produces a result.
		 * This is the two-arity specialization of Function.
		 * 
		 * This is a functional interface whose functional method is "apply(Object,
		 * Object)."
		 * 
		 * Since:
		 * 
		 * 1.8
		 * 
		 * See Also:
		 * 
		 * Function
		 */
		BiFunction<String, Integer, Boolean> exceedsMaxLength = (s, maxLength) -> {
			int actualLength = s.length();
			return actualLength > maxLength;
		};

		resetGlobalCount();
		
		Function<String, String> lineWithLineNumber = line -> {
			return new StringBuilder()
					.append(getLineNumber())
					.append(": ")
					.append(line)
					.toString();
		};
		
		argsList.stream().map(line -> lineWithLineNumber.apply(line))
						 .forEach(System.out::println);
	};
	
	/**
	 * Side-effect: 
	 * 
	 * Increment by 1 for the global line number.
	 * 
	 * @return
	 */
	private static Integer getLineNumber() {
		return globalLineNumber++;
	}

	private static void resetGlobalCount() {
		globalLineNumber = 1;
	}
}