package org.church.our.loving.http;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.church.our.loving.constants.IOurChurchConstants;
import org.church.our.loving.util.StringUtil;

/**
 * Servlet implementation class ConfigureSetup
 */
public class ConfigureSetup extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String uploadFolder = "";
	public static String ROOT_DIR = "";
	private final Logger logger = Logger.getLogger(getClass().getName());   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ConfigureSetup() {
        super();
    }
 
    
    
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}



	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		try {
			File targetfile = new File(StringUtil.getRootDir() + "/upload/log4j.properties");
			if (targetfile.exists()) {
				PropertyConfigurator.configure(StringUtil.getRootDir() + "/upload/log4j.properties"); 
				uploadFolder = IOurChurchConstants.UPLOAD_DIR;
			} else {
				PropertyConfigurator.configure(getServletContext().getRealPath("/") + "config/log4j.properties");
				ROOT_DIR = getServletContext().getRealPath("/");
				uploadFolder = getServletContext().getRealPath("/") + "upload/";
			}
			
		} catch (Exception e) {
			logger.error(e);
		}
		logger.debug("========================Start Server Configuration===================");
		logger.debug("Upload Folder is: " + uploadFolder);
	}


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
