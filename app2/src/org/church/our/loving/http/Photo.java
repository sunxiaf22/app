package org.church.our.loving.http;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.church.our.loving.util.StringUtil;
/**
 * Servlet implementation class Photo
 */
public class Photo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Photo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		File outdir = new File(ConfigureSetup.uploadFolder);
		File [] files = outdir.listFiles();
		String ouputContent = "";
		for (int i = 0; i < files.length; i++) {
			File file = files[i];
			if (!file.isDirectory()) {
				String originalFilename = file.getName();
				if (originalFilename.toLowerCase().matches(".*\\.(jpg|png|gif|jpeg)")) {
					String fileContent = "";
					try {
						fileContent =  FileUtils.readFileToString(new File(ConfigureSetup.uploadFolder + originalFilename+".txt"),  "utf-8");
					} catch (Exception e) {
					}
					if(StringUtil.isEmpty(fileContent)) fileContent = "We are one !!";
					ouputContent += "<div class=\"w3-third\">" +
							"<img src=\"upload/" + originalFilename + "\" widht=\"321 \" height=\"385\" onclick=\"onClick(this)\" alt=\""+fileContent+"\">"
							+"</div>";
				}
			}
		}
		request.setAttribute("images", ouputContent);
		request.getRequestDispatcher("photo.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
