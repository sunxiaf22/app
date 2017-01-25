package org.church.our.loving.http;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.church.our.loving.util.ImageUtil;
import org.church.our.loving.util.StringUtil;

/**
 * Servlet implementation class Upload
 */
public class Upload extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static Map<String, String> fileDateMapping = new HashMap<String,String>(); 
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Upload() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html");
		//File repository = new File(StringUtil.getRootDir());
		PrintWriter out =  response.getWriter();
		try {
			boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			out.println("Has file upload request.<br/><br/>");
			out.println(".<br/><br/>");
			String uploadDate =  StringUtil.formateDateToString(new Date(), StringUtil.DATE_FORMAT_SESCOND);
			if (isMultipart) {
				// Create a factory for disk-based file items
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// Create a new file upload handler
				ServletFileUpload upload = new ServletFileUpload(factory);
				//upload.setProgressListener(progressListener);
				// Parse the request
				List<FileItem> items = upload.parseRequest(request);
				String subject = "";
				String fileNameS= "";
				boolean isImage = false;
				for (FileItem item : items) {
					if (item.isFormField()) {
						out.println("===================INPUTS================<br/>");
						out.println("Field Name: " + item.getFieldName() + " - Value : " + item.getString("utf-8"));
							subject += item.getString("utf-8") + "<br/>";
					}else {
						out.println("===================FILE================<br/>");
					    String fileName = item.getName();
					    String contentType = item.getContentType();
					    boolean isInMemory = item.isInMemory();
					    long sizeInBytes = item.getSize();
						out.println("File: " + fileName +  " - contentType : " + contentType + " isInMemory:" + isInMemory + " sizeInBytes : "+ sizeInBytes );
						String fileNameEncoded = URLEncoder.encode(fileName,"utf-8");
						out.println("Encoded file name " + fileNameEncoded);
						
						File uploadDir = new File(ConfigureSetup.uploadFolder);
						if (!uploadDir.exists()) {
							uploadDir.mkdirs();
						}
						File output = new File(ConfigureSetup.uploadFolder  +  fileNameEncoded);
						item.write(output);
						fileNameS = fileNameEncoded;
						if (contentType.toLowerCase().contains("image") ) {
							if (sizeInBytes > 500*1024)
							ImageUtil.convertImage(300, ConfigureSetup.uploadFolder  +  fileNameEncoded);
							String newFilename="image_" + Calendar.getInstance().getTimeInMillis() + ".jpg";
							output.renameTo(new File(ConfigureSetup.uploadFolder +  newFilename));
							fileNameS = newFilename;
							isImage = true;
						}
						String writeDate = StringUtil.formateDateToString(new Date(), StringUtil.DATE_FORMAT_SESCOND);
						fileDateMapping.put(fileNameEncoded, "File was uploaded at: [" + uploadDate + "  to  " + writeDate + "]");
					}
				}
				if (isImage) {
					org.apache.commons.io.FileUtils.writeStringToFile(new File(ConfigureSetup.uploadFolder + fileNameS+".txt"), subject, "utf-8");
					response.sendRedirect("photo");
				}
			}
			
		} catch (Exception e) {
			out.println(StringUtil.processException(e));
		} finally {
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
}
