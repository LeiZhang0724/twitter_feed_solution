<%-- 
    Document   : index
    Created on : 04/02/2014, 3:46:08 PM
    Author     : pdelir
--%>

<%@page import="java.io.InputStreamReader"%>
<%@page import="org.codehaus.jettison.json.JSONArray"%>
<%@page import="org.codehaus.jettison.json.JSONObject"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TwitterAPI.TwitterCaller"%>
<%-- <%@page import="TwitterAPI.Googletest2"%> --%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>




<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>Twitter Sample Solution</h1>
        <table border="1">
            <tr>
                <td>Created At</td>
                <td>Created User</td>
                <td>Text</td>
              <%--   <td>Google</td> --%>
            </tr>


            <%
                String query = "Monash University";
                //String query = "ieee conference";
                try{
                    TwitterCaller myTwitterCaller = new TwitterCaller();
                     //Googletest2 cs = new Googletest2();
                    


                 JSONObject jsonObject = new JSONObject(myTwitterCaller.TwitterResponse(query));
                if (jsonObject==null) System.out.println("jsonobj is null");
                JSONArray tweets = jsonObject.getJSONArray("statuses");
                if (tweets==null) System.out.println("tweets is null");
                JSONObject tweet;
                 StringBuilder buf = new StringBuilder();

                
               
              for (int i = 0; i < tweets.length(); i++) {
                    tweet = tweets.getJSONObject(i);
            %>
            <tr>
                <td><%=tweet.getString("created_at")%></td>

                <%

                    JSONObject userObject = new JSONObject(tweet.getString("user"));
                    String userName = userObject.getString("name");
                    //String description = cs.getGoogleSearch("Paris");
                %>
                <td><%=userName%></td>              
                <td><%=tweet.getString("text")%></td>
                 <%--  <td><%=description%></td> --%> 
            </tr>
            
            <%
                }
            }catch(Exception e){
                    System.out.println("error " + e.getMessage());
                }


            %>


        </table> 

    </body>
</html>
