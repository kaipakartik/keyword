package com.kaipa.keyword;

import java.io.IOException;
import java.net.URLEncoder;

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
		// If the key is null just go to the add page.
		if (key == null) {
			resp.sendRedirect("/add.jsp");
		}
		// If the key is non null but the url go to the add page with the
		// keyword filled.
		if (key != null && url == null) {
			resp.sendRedirect(String.format("/add.jsp?k=%s",
					URLEncoder.encode(key, "UTF-8")));
		}
		// Save the keyword. Show a brief message, then redirect to the actual
		// url.
		// If a url mapping already exists don't do anything.
		if (Keyword.find(key) == null) {
			new Keyword(key, url).save();
			resp.getWriter().println(
					"Added " + key + " " + url + "successfully");
			resp.setHeader("Refresh", ".35; url=" + url);
		} else {
			resp.getWriter().println(
					String.format("It seems as if the key %s already exists",
							key));
		}
	}
}
