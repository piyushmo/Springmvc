package com.example.spring.mvc.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

public class TimeCheckController extends AbstractController {

	@Override
	protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Calendar calendar = Calendar.getInstance();

		int hour = calendar.get(Calendar.HOUR_OF_DAY);

		String message = null;

		if (hour < 12) {

			message = "Good Morning";
		} else if (hour < 16) {

			message = "Good Afternoon";
		} else if (hour < 20) {

			message = "Good evening";
		} else {
			message = "Good Night";
		}

		return new ModelAndView("greeting","welcomemessage", message);
	}

}
