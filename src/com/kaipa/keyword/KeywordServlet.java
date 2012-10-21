package com.kaipa.keyword;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaipa.keyword.entities.Keyword;

@SuppressWarnings("serial")
public class KeywordServlet extends HttpServlet {
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		process(req, resp);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		process(req, resp);
	}

	public void process(HttpServletRequest req, HttpServletResponse resp)
			throws IOException {
		String query = req.getParameter("q") == null?req.getParameter("query"): req.getParameter("q");
		if (query == null) {
			resp.sendRedirect("http://www.google.com");
			return;
		}
		Keyword keyword = Keyword.find(query);
		if (keyword != null) {
			keyword.incrementCount();
			keyword.save();
			resp.sendRedirect(keyword.getUrl());
		} else {
			resp.sendError(404, "Keyword not found");
		}
	
	}
}

