package com.kaipa.keyword;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kaipa.keyword.entities.Keyword;

@SuppressWarnings("serial")
public class AddServlet extends HttpServlet {
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
		String key = req.getParameter("key");
		String url = req.getParameter("url");
		if (key != null && url != null) {
			new Keyword(key, url).save();
			resp.getWriter().println("Added " + key  + " " + url + "successfully");
			resp.setHeader("Refresh", ".35; url=/add.html");
		} else {
			resp.getWriter().println("Something went wrong");
		}
	}
}
