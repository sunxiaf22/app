package org.church.our.loving.util;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.church.our.loving.constants.IOurChurchConstants;

public class SecurityUtil {
	public static void sendRequestDispatcher(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = UUID.randomUUID().toString();
		request.getSession().setAttribute(IOurChurchConstants.FORM_ID, uuid);
		request.setAttribute(IOurChurchConstants.FORM_ID, uuid);
		System.out.println("set req attr" + uuid);
		request.getRequestDispatcher(path).forward(request, response);
	}

	public static void checkFormRequest (String formId, HttpServletRequest request, HttpServletResponse response, String errorPage) throws IOException {
		if (StringUtil.isEmpty(formId)) formId = request.getParameter(IOurChurchConstants.FORM_ID);
		if (StringUtil.isEmpty(formId)) formId = "";
		String formIdSession = (String) request.getSession().getAttribute(IOurChurchConstants.FORM_ID);
		if (StringUtil.isEmpty(formIdSession)) formIdSession = "";
		System.out.println("get req attr" + formId + " session id : " + formIdSession);
		if (! formIdSession.equalsIgnoreCase(formId)) {
			response.sendRedirect(errorPage);
			return;
		}
	}
	
}
