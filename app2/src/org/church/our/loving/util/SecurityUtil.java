package org.church.our.loving.util;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecurityUtil {
	public static void sendRequestDispatcher(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = UUID.randomUUID().toString();
		request.getSession().setAttribute("formid", uuid);
		request.getRequestDispatcher(path).forward(request, response);
	}

	public static boolean checkFormRequest (HttpServletRequest request, HttpServletResponse response) {
		String formId = request.getParameter("formid");
		if (StringUtil.isEmpty(formId)) formId = "";
		String formIdSession = (String) request.getSession().getAttribute("formid");
		if (StringUtil.isEmpty(formIdSession)) formIdSession = "";
		return formIdSession.equalsIgnoreCase(formId);
	}
	
	
}
