package com.spring.boot.designpattern;

import com.spring.boot.designpattern.dependencyinjection.Consumer1;
import com.spring.boot.designpattern.dependencyinjection.Consumer2;
import com.spring.boot.designpattern.dependencyinjection.Producer;
import com.spring.boot.designpattern.dependencyinjection.Producer2;
import com.spring.boot.designpattern.enums.Account;
import com.spring.boot.designpattern.enums.TransactionType;
import com.spring.boot.designpattern.immutability.Address;
import com.spring.boot.designpattern.immutability.Gandalf;
import com.spring.boot.designpattern.immutability.Hobbit;
import com.spring.boot.designpattern.lambda.LambdaExpressions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
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
		/**
		 * Enums
		 */
		Account accountBuy = new Account();
		System.out.println("Balance before the transaction: "+ accountBuy.getBalance());
		TransactionType.BUY.doTransactionOperation(accountBuy, BigDecimal.valueOf(100));
		System.out.println("Balance after the transaction: "+ accountBuy.getBalance());

		Account accountSell = new Account();
		System.out.println("Balance before the transaction: "+ accountSell.getBalance());
		TransactionType.SELL.doTransactionOperation(accountSell, BigDecimal.valueOf(100));
		System.out.println("Balance after the transaction: "+ accountSell.getBalance());

		/**
		 * Streams and Lambda Expressions
		 */
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

		final Consumer<String> consumer = element -> System.out.println("This is next element" + element);

		final Function<String, String> upperCase = word -> word.toUpperCase();

		final Function<String, String> upperCaseUsingMethodReference = String::toUpperCase;

		List<String> elements = List.of("1", "2", "3", "4", "5", "6");
		final IntStream intStream = elements.stream()
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

		/**
		 * Equals and Hashcode
		 */

		/**
		 * Immutability classes in java
		 */

		Gandalf gandalf = new Gandalf("Frodo Baggins", new Address("Hobitton", "Shire"), Collections.emptyList());
		Hobbit hobbit = new Hobbit("Sweta", new Address("test","test1"), Collections.emptyList());
		//Hobbit hobbit = (Hobbit) gandalf;
		System.out.println(hobbit.getName());
		gandalf.hackTheImmutability("Mr. Underhill");
		System.out.println();

		System.out.println(hobbit.getName());


		/**
		 * Dependency injection and inversion of control
		 * Let's understand Dependency Injection and Inversion of Control
		 * Dependency injection example
		 * Analogy: CD Player and Music CD's
		 */

		Consumer1 c1 = new Consumer1();
		c1.purchaseItem();


		String purchaseStatus;
		Producer producer = new Producer2();
		Consumer2 consumer2 =  new Consumer2(producer);

		purchaseStatus = consumer2.purchaseItem();

		System.out.println(">> Purchase Status: " + purchaseStatus);

	}
}
