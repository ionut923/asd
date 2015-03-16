	package com.pages;



	import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
	 



	import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
	 
	public class HTTP_Request {
	 
	 //private final String USER_AGENT = "Mozilla/5.0";//
	 private final String USER_AGENT = "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-US) AppleWebKit/534.20 (KHTML, like Gecko) Chrome/11.0.672.2 Safari/534.20";
	 
	 public static void main(String[] args) throws Exception {
	 
	  HTTP_Request http = new HTTP_Request();
	 
	  System.out.println("Testing 1 - Send Http GET request");
	  http.sendGet();
	 
	  System.out.println("\nTesting 2 - Send Http POST request");
	  http.sendPost();
	 
	 }
	 
	 // HTTP GET request
	 private void sendGet() throws Exception {
	 
	  String url = "http://www.google.com/search?q=developer";
	  
	  HttpClient client = new DefaultHttpClient();
	  HttpGet request = new HttpGet(url);
	 
	  // add request header
	  request.addHeader("User-Agent", USER_AGENT);
	 
	  HttpResponse response = client.execute(request);
	 
	  System.out.println("\nSending 'GET' request to URL : " + url);
	  System.out.println("Response Code : " + 
	                       response.getStatusLine().getStatusCode());
	 
	  BufferedReader rd = new BufferedReader(
	                       new InputStreamReader(response.getEntity().getContent()));
	 
	  StringBuffer result = new StringBuffer();
	  String line = "";
	  while ((line = rd.readLine()) != null) {
	   result.append(line);
	  }
	 
	  System.out.println(result.toString());
	  
	  String link = result.toString();
	  
	  int index = link.indexOf("<h3 class=\"r\">");
	  link = link.substring(index+23);
	  
	  index = link.indexOf("\"");
	  link = link.substring(0, index);
	  
	  System.out.println(link);
	  WebDriver webDriver1=new FirefoxDriver();
	  webDriver1.get(link);   //imi deschide driverul
	 }

	 // HTTP POST request
	 private void sendPost() throws Exception {
	 
	  String url = "http://altoromutual.com/bank/login.aspx";
	  HttpClient client = new DefaultHttpClient();
	  HttpPost post = new HttpPost(url);
	 
	  // add header
	  post.setHeader("User-Agent", USER_AGENT);
	  post.setHeader("Cookie", "ASP.NET_SessionId=1tjj0iy1ajs2cfnucavxeu45; amSessionId=233934325717");
	  
	  List<NameValuePair> urlParameters = new ArrayList<NameValuePair>();
	  urlParameters.add(new BasicNameValuePair("uid", "admin"));
	  urlParameters.add(new BasicNameValuePair("passw", "admin"));
	  urlParameters.add(new BasicNameValuePair("btnSubmit", "Login"));

	  post.setEntity(new UrlEncodedFormEntity(urlParameters));
	 
	  HttpResponse response = client.execute(post);
	  System.out.println("\nSending 'POST' request to URL : " + url);
	  System.out.println("Post parameters : " + post.getEntity());
	  System.out.println("Response Code : " + 
	                                    response.getStatusLine().getStatusCode());
	 
	  BufferedReader rd = new BufferedReader(
	                        new InputStreamReader(response.getEntity().getContent()));
	 
	  StringBuffer result = new StringBuffer();
	  String line = "";
	  while ((line = rd.readLine()) != null) {
	   result.append(line);
	  }
	 
	  System.out.println(result.toString());
	 
	 }

	
	
}
