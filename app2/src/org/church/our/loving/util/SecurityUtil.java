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
		request.getRequestDispatcher(path).forward(request, response);
	}

	public static Boolean checkFormRequest (String formId, HttpServletRequest request, HttpServletResponse response, String errorPage) throws IOException {
		Boolean isvalid = false;
		if (StringUtil.isEmpty(formId)) formId = request.getParameter(IOurChurchConstants.FORM_ID);
		if (StringUtil.isEmpty(formId)) formId = "";
		String formIdSession = (String) request.getSession().getAttribute(IOurChurchConstants.FORM_ID);
		if (StringUtil.isEmpty(formIdSession)) formIdSession = "";
		if (! formIdSession.equalsIgnoreCase(formId)) {
			response.sendRedirect(errorPage);
			return isvalid;
		} else {
			return true;
		}
	}
	
}
