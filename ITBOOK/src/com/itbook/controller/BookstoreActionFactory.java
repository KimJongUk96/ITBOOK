package com.itbook.controller;

import com.itbook.controller.action.Action;
import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.bookstore.BookstoreListAction;

public class BookstoreActionFactory {
	
private static BookstoreActionFactory instance = new BookstoreActionFactory();
	
	private BookstoreActionFactory() {
		super();
	}
	
	public static BookstoreActionFactory getInstance() {
		return instance;
	}
	
	public Action getAction(String command) {
		Action action = null;
		
		System.out.println("ActionFactory : " + command);
		
		if(command.equals("main")) {
			action = new MainAction();

		}else if(command.equals("bookstoreList")) {
			
			action = new BookstoreListAction();
			
		}
		return action;
}
	
}