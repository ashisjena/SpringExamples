package com.demo.myapp;

import java.util.Arrays;
import java.util.Iterator;

import org.springframework.stereotype.Component;
import org.springframework.ui.ModelMap;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.context.request.WebRequestInterceptor;

@Component("contactInterceptor")
public class ContactInterceptor implements WebRequestInterceptor {

	@Override
	public void preHandle(WebRequest request) throws Exception {
		Iterator<String> iterator = request.getHeaderNames();
		while (iterator.hasNext()) {
			String headerName = iterator.next();
			System.err.println(headerName + " : " + Arrays.toString(request.getHeaderValues(headerName)));
		}
		System.err.println("PreHandle invoked");
	}

	@Override
	public void postHandle(WebRequest request, ModelMap model) throws Exception {
		model.addAttribute("postHandle", "PostHandle called in Interceptor");
	}

	@Override
	public void afterCompletion(WebRequest request, Exception ex) throws Exception {
		System.out.println(request);
	}
}
