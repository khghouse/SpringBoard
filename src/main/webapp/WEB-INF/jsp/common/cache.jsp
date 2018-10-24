<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	// HTTP 각 버전에서 지원하는 헤더, 값을 'no-cache'로 지정하면 캐시에 저장하지 않는다.
	response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	
	response.setDateHeader("Expires", 0); // Proxies.
%>