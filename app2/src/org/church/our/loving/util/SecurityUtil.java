package org.church.our.loving.util;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.church.our.loving.constants.IOurChurchConstants;
import org.church.our.loving.http.ConfigureSetup;

public class SecurityUtil {
	public static void sendRequestDispatcher(String path, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uuid = UUID.randomUUID().toString();
		request.getSession().setAttribute(IOurChurchConstants.FORM_ID, uuid);
		request.setAttribute(IOurChurchConstants.FORM_ID, uuid);
		request.getRequestDispatcher(path).forward(request, response);
	}

	public static Boolean checkFormRequest (String formId, HttpServletRequest request, HttpServletResponse response, String errorPage) throws IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		Boolean isvalid = false;
		if (StringUtil.isEmpty(formId)) formId = request.getParameter(IOurChurchConstants.FORM_ID);
		if (StringUtil.isEmpty(formId)) formId = "";
		StringUtil.debug(SecurityUtil.class.getName(), request, " form id :  " + formId);
		String formIdSession = (String) request.getSession().getAttribute(IOurChurchConstants.FORM_ID);
		StringUtil.debug(SecurityUtil.class.getName(), request, " form session id :  " + formIdSession);
		if (StringUtil.isEmpty(formIdSession)) formIdSession = "";
		if (! formIdSession.equalsIgnoreCase(formId)) {
			response.sendRedirect(errorPage);
			return isvalid;
		} else {
			return true;
		}
	}
	
	public static Map<String, String> requestWrapper(HttpServletRequest request, Boolean isMultiPart) throws Exception {
		Map<String, String> result = new HashMap<String, String>();
		if (isMultiPart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);
				for (FileItem item : items) {
					if (item.isFormField()) {
						String fieldName = item.getFieldName();
						String fieldValu = item.getString("utf-8");
						result.put(fieldName, fieldValu);
					}else {
						String fileName = item.getName();
						String contentType = item.getContentType();
						boolean isInMemory = item.isInMemory();
						long sizeInBytes = item.getSize();
						String fileNameEncoded = URLEncoder.encode(fileName,"utf-8");
						File uploadDir = new File(ConfigureSetup.uploadFolder);
						if (!uploadDir.exists()) {
							uploadDir.mkdirs();
						}
						File output = new File(ConfigureSetup.uploadFolder  +  fileNameEncoded);
						item.write(output);
						String fileNameS = fileNameEncoded;
						if (contentType.toLowerCase().contains("image") ) {
							if (sizeInBytes > 500*1024)
								ImageUtil.convertImage(300, ConfigureSetup.uploadFolder  +  fileNameEncoded);
							String newFilename="image_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
							output.renameTo(new File(ConfigureSetup.uploadFolder +  newFilename));
							fileNameS = newFilename;
						}
						String writeDate = StringUtil.formateDateToString(new Date(), StringUtil.DATE_FORMAT_SESCOND);
					}
				}
			
		}else {
			
			
		}
		return result;
		
	}
}
