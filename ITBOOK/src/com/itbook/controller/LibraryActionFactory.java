package com.itbook.controller;

import com.itbook.controller.action.Action;

import com.itbook.controller.action.MainAction;
import com.itbook.controller.action.library.AdminLibraryList;
import com.itbook.controller.action.library.LibraryListAction;
import com.itbook.controller.action.library.LibraryRegAction;
import com.itbook.controller.action.library.LibraryRegFormAction;
import com.itbook.controller.action.library.LibraryUpdateAction;
import com.itbook.controller.action.library.LibraryUpdateFormAction;


/**
 * @author 수아
 */

public class LibraryActionFactory {

	private static LibraryActionFactory instance = new LibraryActionFactory();

	private LibraryActionFactory() {
		super();
	}

	public static LibraryActionFactory getInstance() {
		return instance;
	}

	public Action getAction(String command) {
		Action action = null;

		System.out.println("LibraryActionFactory : " + command);

		if (command.equals("main")) {
			action = new MainAction();

			// 도서관 리스트로 이동
		} else if (command.equals("libraryList")) {
			action = new LibraryListAction();

			// 관리자 도서관 리스트
		} else if (command.equals("adminLibraryList")) {
			action = new AdminLibraryList();

			// 도서관 등록
		} else if (command.equals("libraryReg")) {
			action = new LibraryRegAction();

			// 도서관 등록 폼
		} else if (command.equals("libraryRegForm")) {
			action = new LibraryRegFormAction();

			// 도서관 수정
		} else if (command.equals("libraryUpdate")) {
			action = new LibraryUpdateAction();

			// 도서관 수정 폼
		} else if (command.equals("libraryUpdateForm")) {
			action = new LibraryUpdateFormAction();

		}
		return action;
	}

}
