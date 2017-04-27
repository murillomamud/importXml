package org.desenvolvimento.aberto;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.URL;
import java.nio.charset.StandardCharsets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import netscape.javascript.JSObject;
import sun.misc.IOUtils;

/**
 * Servlet implementation class importXml
 */
@WebServlet("/importxml")
public class importXml extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public importXml() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		addCorsHeader(response);		
		String valorDoParametro = request.getParameter("xml");
        PrintWriter imprimir = response.getWriter();
        
        //String print = valorDoParametro;
        //imprimir.println(print);
		
	    InputStream input = new URL( valorDoParametro ).openStream();
	    try {
	    	int ch;
	    	StringBuilder sb = new StringBuilder();
	    	while((ch = input.read()) != -1)
	    	    sb.append((char)ch);	
	    	//imprimir.println(sb.toString());
	    	
	    	//String message = "XML_OK";
	    	
	    	String json = "{\"status\" : \"XML_OK\"}";
	    	
	    	//JSONObject json = new JSONObject(message);
	    	
	    	imprimir.println(json);
	    	
	    } finally {
	        
	    }
	    
	    
		
	}
	
    private void addCorsHeader(HttpServletResponse response){
        //TODO: externalize the Allow-Origin
        response.addHeader("Access-Control-Allow-Origin", "*");
        response.addHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, PUT, DELETE, HEAD");
        response.addHeader("Access-Control-Allow-Headers", "X-PINGOTHER, Origin, X-Requested-With, Content-Type, Accept");
        response.addHeader("Access-Control-Max-Age", "1728000");
    }	

}
