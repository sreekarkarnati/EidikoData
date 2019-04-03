package com.ibm.eidikoemp;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.GenericPortlet;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.PortletSession;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.json.JSONObject;

import com.ibm.wsspi.portletcontainer.portlet.PortletUtils;

public class EidikoEmpPortlet extends GenericPortlet {

	public static final String JSP_FOLDER    = "/_EidikoEmp/jsp/";    // JSP folder name
	public static final String VIEW_JSP      = "EidikoEmpPortletView";         // JSP file name to be rendered on the view mode
	public static final String SESSION_BEAN  = "EidikoEmpPortletSessionBean";  // Bean name for the portlet session
	public static final String FORM_SUBMIT   = "EidikoEmpPortletFormSubmit";   // Action name for submit form
	public static final String FORM_TEXT     = "EidikoEmpPortletFormText";     // Parameter name for the text input
	public  static String  baseURL= "http://192.168.3.62:8080/EmployeeTimeline/rest/getTimelineByEmployeeId";
	
	
	public static final String Response_JSP  = "Response";
	@SuppressWarnings("rawtypes")
	public List list;
	public void init() throws PortletException{
		super.init();
	}

	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void doView(RenderRequest request, RenderResponse response) throws PortletException, IOException {
		response.setContentType(request.getResponseContentType());
		String action = request.getParameter("Action");
		String property=request.getProperty("data");
		System.out.println("PropertyFILE>>>"+property);
		if(action != null && "Confirm".equals(action)){
			System.out.println("inside if confirm  "+action);
			PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(request, Response_JSP));
			rd.include(request,response);
		}else {
		PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(getJspFilePath(request, VIEW_JSP));
		rd.include(request,response); 
		}
		
	}

	
	public void processAction(ActionRequest request, ActionResponse response) throws PortletException, java.io.IOException {
		  System.out.println("In processAction ");
			String employeeId=request.getParameter("empId");
			Client client =new Client();
			list=client.callGetRestService(baseURL,employeeId);
		    System.out.println("after response"+list);
		    response.setRenderParameter("Action", "Confirm");
			request.setAttribute("empList",list);
		
			
	}
	private static EidikoEmpPortletSessionBean getSessionBean(PortletRequest request) {
		PortletSession session = request.getPortletSession();
		if( session == null )
			return null;
		EidikoEmpPortletSessionBean sessionBean = (EidikoEmpPortletSessionBean)session.getAttribute(SESSION_BEAN);
		if( sessionBean == null ) {
			sessionBean = new EidikoEmpPortletSessionBean();
			session.setAttribute(SESSION_BEAN,sessionBean);
		}
		return sessionBean;
	}

	
	public void serveResource(ResourceRequest request, ResourceResponse response) throws PortletException, java.io.IOException {
		String resourceID = request.getResourceID();
		String action=request.getParameter("action");
		//String res=null;
		System.out.println("action "+action+" and empId ");
		
	if("postEmplyeeTimeline".equals(action)){
			Employee e=new Employee();
			
			//System.out.println("eid :: "+request.getParameter("id1")+" employeeID: "+request.getParameter("employeeId"));
			e.setCategoryId(Long.parseLong(request.getParameter("categoryId")));
			e.setSubCategoryId(Long.parseLong(request.getParameter("subCategoryId")));
			e.setSkillId(Long.parseLong(request.getParameter("skillId")));
			
			e.setStartDate(convertDateFormat(request.getParameter("startDate")));
			e.setEndDate(convertDateFormat(request.getParameter("endDate")));
			//e.setStartDate("startDate");//(convertDateFormat(request.getParameter("startDate")));
			e.setRemarks(request.getParameter("remarks"));
			e.setId(Long.parseLong(request.getParameter("id1")));
			e.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
			
			Client c=new Client();
			String responseCode = c.callPostRestService(e, "");
			
			response.setProperty("data","responseCode");
			
			
			
		}
//		response.setContentType("text/json");
//	      PrintWriter pw = res.getWriter();;
//	      pw.write(res);
//	      pw.close();
	}

	
	  public Date convertDateFormat(String date){
		   Date d=null;
		   try{
			  
			   d=new SimpleDateFormat("dd-MM-yyyy").parse(date);
			   
		   }catch(Exception e){
			   e.printStackTrace();
		   }
		   return d;
		   
	   }


	private static String getJspFilePath(RenderRequest request, String jspFile) {
		String markup = request.getProperty("wps.markup");
		if( markup == null )
			markup = getMarkup(request.getResponseContentType());
		return JSP_FOLDER + markup + "/" + jspFile + "." + getJspExtension(markup);
	}

	
	private static String getMarkup(String contentType) {
		if( "text/vnd.wap.wml".equals(contentType) )
			return "wml";
        else
            return "html";
	}

	
	private static String getJspExtension(String markupName) {
		return "jsp";
	}

}
