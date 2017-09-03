<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
	out.println(sdf.format(new Date()));
%>