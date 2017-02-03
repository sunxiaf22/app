package org.church.our.loving.http;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.church.our.loving.util.ImageUtil;
import org.church.our.loving.util.SecurityUtil;
import org.church.our.loving.util.StringUtil;

/**
 * Servlet implementation class RegisterDO
 */
public class RegisterDO extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterDO() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			if (isMultipart) {
				DiskFileItemFactory factory = new DiskFileItemFactory();
				ServletFileUpload upload = new ServletFileUpload(factory);
				List<FileItem> items = upload.parseRequest(request);
				String subject = "";
				String fileNameS= "";
				boolean isImage = false;
				for (FileItem item : items) {
					if (item.isFormField()) {
						StringUtil.debug(this.getClass().getName(), request, "register user info" + item.getFieldName() + "***" + item.getString("utf-8"));
					}else {
//						String fileName = item.getName();
//						String contentType = item.getContentType();
//						boolean isInMemory = item.isInMemory();
//						long sizeInBytes = item.getSize();
//						String fileNameEncoded = URLEncoder.encode(fileName,"utf-8");
//						File uploadDir = new File(ConfigureSetup.uploadFolder);
//						if (!uploadDir.exists()) {
//							uploadDir.mkdirs();
//						}
//						File output = new File(ConfigureSetup.uploadFolder  +  fileNameEncoded);
//						item.write(output);
//						fileNameS = fileNameEncoded;
//						if (contentType.toLowerCase().contains("image") ) {
//							if (sizeInBytes > 500*1024)
//								ImageUtil.convertImage(300, ConfigureSetup.uploadFolder  +  fileNameEncoded);
//							String newFilename="image_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
//							output.renameTo(new File(ConfigureSetup.uploadFolder +  newFilename));
//							fileNameS = newFilename;
//							isImage = true;
//						}
//						String writeDate = StringUtil.formateDateToString(new Date(), StringUtil.DATE_FORMAT_SESCOND);
					}
				}
			}
			StringUtil.debug(this.getClass().getName(), request, "register user info");
			
			
			if (SecurityUtil.checkFormRequest("", request, response,"error.jsp")) { 
				
			}
		} catch (Exception e) {
			StringUtil.error(this, request, "", e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
