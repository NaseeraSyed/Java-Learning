/*
 * package com.javalearning.springboot.helloworld;
 * 
 * import org.springframework.boot.SpringApplication; import
 * org.springframework.boot.autoconfigure.SpringBootApplication;
 * 
 * @SpringBootApplication public class SpringbootHelloworldApplication {
 * 
 * public static void main(String[] args) {
 * SpringApplication.run(SpringbootHelloworldApplication.class, args); }
 * 
 * 
 * }
 */


package com.javalearning.springboot.helloworld;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

import com.javalearning.springboot.helloworld.model.Employee;

public class Driver {
	public static void main(String[] args) {
		
		/*
		String str= "Amar";

		char ch = str.charAt(str.length()-1);
		if(str.contains(String.valueOf(ch))) {
			System.out.println(str+" ends with given character "+ch);
		}else {
			System.out.println(str+"doesn't ends with chaarcter "+ch);
		}
		*/
		
		List<Employee> employees = Employee.getEmployees();
		//display all the employees in the List.
		employees.stream()
			.forEach(emp->System.out.println(emp));
		
		//print the employees whose name starts with "k"
		System.out.println("Employees whose Nme starts with 'K' ");
		for (Employee employee : employees) {
			if(employee.getName().contains("K")) {
				System.out.println(employee);
			}
		}
		
		//using java8 streams
		System.out.println("Employees whose Nme starts with 'K' using java8 streams ");
		List<Employee> employeesWithNamesStartsK = employees.stream()
			.filter(emp->emp.getName().contains("K"))
			.collect(Collectors.toList());
		employeesWithNamesStartsK.forEach(e->System.out.println(e));
		
		 //ParallelStream
		
		List<Integer> empnum= Arrays.asList(101,105,108,110,210,300,400,500,600);
		
		
		List<Integer> empnumlessthan = empnum.parallelStream().filter(n->n<400).collect(Collectors.toList());
		
		System.out.println(empnumlessthan);
		
		// Method refernce using id and Names
		
		List<Employee> empList = Employee.getEmployees();
		System.out.println(empList);
		//id 
		empList.stream().map(Employee :: getId).forEach(System.out :: println);
		//Names
		empList.stream().map(Employee :: getName).forEach(System.out :: println);
		 
		// Filter using the null values with out exceptions 
		
		List<String> empNames = Arrays.asList("Malreddy","Naseera",null,"Aman");
		
		empNames.stream()
		.filter(Objects::nonNull)
		.map(e->e.toUpperCase()).forEach(System.out::println);
		
		// filter a list of integers to get only the even numbers
		
		List<Integer> numbers= Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		
		List<Integer> evennumbers = numbers.stream().filter(n->n%2==0).collect(Collectors.toList());
		
		System.out.println("Evennumbers"  + evennumbers);
		
		 //first element in a list that is greater than 10
		
		List<Integer> nums = Arrays.asList(5, 12, 7, 18, 3);
		
		Optional<Integer> firstGreaterThanTen = nums.stream().filter(n-> n>10).findFirst();
		
		System.out.println(firstGreaterThanTen.orElse(null));
		
		// flatten a list of lists into a single list
		
		List<List<String>> flatlist = Arrays.asList(
	            Arrays.asList("a", "b", "c"),
	            Arrays.asList("d", "e", "f"),
	            Arrays.asList("g", "h", "i")
	        );
				
		List<String> flattenedList = flatlist.stream().flatMap(List :: stream).collect(Collectors.toList());
		
		System.out.println("flatten a list of lists into a single list   "  +   flattenedList);
	}
	
	

}