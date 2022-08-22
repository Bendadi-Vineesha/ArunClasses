package com.demo.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.demo.models.Book;

public class MyLambdaHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

//	handler: com.demo.handlers.MyLambdaHandler::handleRequest

	List<Book> books = Arrays.asList(
			new Book("Superman", "Mark", 15), 
			new Book("Hulk", "John", 24),
			new Book("Spiderman", "Miley", 10), 
			new Book("Antman", "Emily", 29), 
			new Book("Hanuman", "Tom", 14),
			new Book("Shaktiman", "Kim", 15), 
			new Book("Ironman", "Carl", 19), 
			new Book("Batman", "Mark", 21),
			new Book("Wonder Woman", "Ramesh", 24));

	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {

		try {
			
			// "queryParams":{"author":"mark","title":"batman"}
			String p = event.getQueryStringParameters().get("price");
			System.out.println("String price: "+p);
			int price = Integer.parseInt(p);
			System.out.println("Number price: "+price);

			List<Book> filteredBooks = new ArrayList<Book>();

			for (Book b : books) {
				if (b.getPrice() > price) {
					filteredBooks.add(b);
				}
			}

			System.out.println("FilteredBooks: "+filteredBooks);
			
			return new APIGatewayProxyResponseEvent().withBody(filteredBooks.toString()).withStatusCode(200);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			System.out.println("Returning all books");
			return new APIGatewayProxyResponseEvent().withBody(books.toString()).withStatusCode(200);
		}
	}

}
