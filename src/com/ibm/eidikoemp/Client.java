package com.ibm.eidikoemp;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Client {
	
	@SuppressWarnings("rawtypes")
	public  static String  baseURL1= "http://192.168.3.62:8080/EmployeeTimeline/rest/addTimeline";
	private List list;
	//public  static String  postURL= "http://192.168.3.62:8080/EmployeeTimeline/rest/addTimeline";
	public List<Employee> callGetRestService(String baseURL,String employeeId )
	{		 
		 String  response = null;
		 @SuppressWarnings("unused")
		 int httpStatusCode = 0;
     
		 try 
		  {				  
			ObjectMapper mapperObj = new ObjectMapper();			
			mapperObj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);		 
		    HttpClient httpclient = new HttpClient();	
		    httpclient.getParams().setSoTimeout(600000000);
		    httpclient.getParams().setConnectionManagerTimeout(30000000); 
		    System.out.println("URL is"+baseURL);
		    System.out.println("Base url "+baseURL+"/"+employeeId);
		    GetMethod get = new GetMethod(baseURL+"/"+employeeId);		   
		    get.setRequestHeader("Content-Type","application/json; charset=UTF-8");
		    get.setRequestHeader("Accept","application/json; charset=UTF-8");
		    httpStatusCode = httpclient.executeMethod(get);	
		    byte[] bytes = get.getResponseBody();
			response = new String(bytes, "UTF-8");
			System.out.println("Response GET "+response);
		    list = mapperObj.readValue(response,new TypeReference<ArrayList<Employee>>() {});
			System.out.println(list);	
			System.out.println("Response GET "+response);
			
		  }	    	
		  catch (NullPointerException nullEx)
		  {
			  nullEx.printStackTrace(); 
		  }
		 catch (Exception e) 
		 {
			 System.out.print(e);
		 }
		 		 		 
		 return list;
		 		 
	}
	public static String callPostRestService(Employee e,String request)
	 {		 
		 String  response = null;
		 int httpStatusCode = 0;
		 PostResponse res=null;
		 try 
		  {				  			
			 	//System.out.println("serviceEndPointURL::"+serviceEndPointURL);
			 	System.out.println("Request ::"+request);	
			 	HttpClient httpclient = new HttpClient();	
			    httpclient.getParams().setSoTimeout(600000000);
			    httpclient.getParams().setConnectionManagerTimeout(30000000); 
			    
			    PostMethod post = new PostMethod(baseURL1);		   
			    try 
				  {				  
					 	ObjectMapper mapperObj = new ObjectMapper();			
						mapperObj.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);						
						 request = mapperObj.writeValueAsString(e);	
						System.out.println("Validate and Ca;culate Req"+request);
				  }catch (Exception e1) 
					 {
						 System.out.print(e);
					 }		 	    
			   
			    post.setRequestHeader("Content-Type","application/json; charset=UTF-8");
			    post.setRequestHeader("Accept","application/json; charset=UTF-8");
			    post.setRequestBody(request);
			    
			    httpStatusCode = httpclient.executeMethod(post);			 		   		    		        
			 
			    byte[] bytes = post.getResponseBody();
				response = new String(bytes, "UTF-8");
				
				
				
			    System.out.println("Response::"+response);						    	
		  }	    	
		  catch (NullPointerException nullEx)
		  {
			  nullEx.printStackTrace(); System.out.print(nullEx);
		  }
		 catch (Exception e2) 
		 {
			 System.out.print(e2);
		 }
		 		 		 
		 return response;		 		 
	 }
	
	
	
}
		
