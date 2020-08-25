package com.spring.boot.designpattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.IntStream;

@SpringBootApplication
public class DesignPatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesignPatternApplication.class, args);
		Account accountBuy = new Account();
		System.out.println("Balance before the transaction: "+ accountBuy.getBalance());
		TransactionType.BUY.doTransactionOperation(accountBuy, BigDecimal.valueOf(100));
		System.out.println("Balance after the transaction: "+ accountBuy.getBalance());

		Account accountSell = new Account();
		System.out.println("Balance before the transaction: "+ accountSell.getBalance());
		TransactionType.SELL.doTransactionOperation(accountSell, BigDecimal.valueOf(100));
		System.out.println("Balance after the transaction: "+ accountSell.getBalance());

		int[] numbers = new int[]{1, 23, 13, 9, 26, 90, 3, 8};
		final Integer[] greaterThan = LambdaExpressions.filterGreaterThan(10, numbers);
		System.out.println(Arrays.toString(greaterThan));

		//use of Java Stream to process the elements in the array
		//use predicate to tell the stream how to filter the elements
		/**
		 * We specify what has to be done but not how
		 * Reduces duplication of code
		 * Easier to read and understand
		 * Inherently immutable
		 * Impossible to change state
		 * No longer possible to modify objects passed by reference as arguments
		 * Lazy evaluation
		 */
		final int[] greaterThanTen = Arrays.stream(numbers)
				.filter(number -> number > 10)
				.toArray();
		System.out.println(Arrays.toString(greaterThanTen));

		//Impure functions:
		int number = 10;
		final Function<Integer, Integer> impureTimesFunction = times -> number * times;
		System.out.println(impureTimesFunction.apply(2));

		/*
		pure function:
		this new function accepts one more argument and it does not depend on any external variable
		pure functions gives us support for non sharing state and immutability
		to make it easy to visualise, think of pure functions as pipes.
		pipes where our data travels through, in a complete isolated and safe way,
		where no other thread can touch them.
		Important concept to write concurrent programs in a much safer and simpler way!
		*/

		final BiFunction<Integer, Integer, Integer> pureTimesFunction = (newNumber, times) -> newNumber * times;
		System.out.println(pureTimesFunction.apply(9,2));


		/**
		 * Lambda expression has following structure
		 * (argument1, argument2) -> expression
		 */
		final Supplier<String> supplier = new Supplier<String>() {
			@Override
			public String get() {
				return "Hello World";
			}
		};

		// achieve same using lambda expression
		// reducing boiler plate code
		final Supplier<String> supplier1 = () -> "Hello world";

		final Consumer<String>  consumer = element -> System.out.println("This is next element" + element);

		final Function<String, String> upperCase = word -> word.toUpperCase();

		final Function<String, String> upperCaseUsingMethodReference = String::toUpperCase;

		List<String> elements = List.of("1", "2", "3", "4", "5", "6");
		final IntStream  intStream = elements.stream()
				.mapToInt(Integer::valueOf);

		//our stream will not start processing the elements in the array until we call the
		//terminal operation sum which belong to IntStream interface
		final int sum = intStream.sum();
		System.out.println("The sum is " + sum);

		/**
		 * Popular java stream methods
		 * filter
		 * map
		 * flatMap
		 * reduce
		 */

		/**
		 * Additional features supported
		 * CompletableFuture
		 */
	}
}
