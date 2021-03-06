<%-- 
    Document   : header
    Created on : Sep 10, 2016, 2:30:53 AM
    Author     : PAUL
--%>

<%@page import="org.hibernate.type.CalendarDateType"%>
<%@page import="sun.util.calendar.CalendarUtils"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>Hotel Management</title>
<link rel="stylesheet" type="text/css" href="<c:url value= '/themes/css/style.css'/>" />
<script type="text/javascript" src="<c:url value='/themes/js/jquery.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/themes/js/ddaccordion.js'/>"></script>
<script type="text/javascript">
ddaccordion.init({
	headerclass: "submenuheader", //Shared CSS class name of headers group
	contentclass: "submenu", //Shared CSS class name of contents group
	revealtype: "click", //Reveal content when user clicks or onmouseover the header? Valid value: "click", "clickgo", or "mouseover"
	mouseoverdelay: 200, //if revealtype="mouseover", set delay in milliseconds before header expands onMouseover
	collapseprev: true, //Collapse previous content (so only one open at any time)? true/false 
	defaultexpanded: [], //index of content(s) open by default [index1, index2, etc] [] denotes no content
	onemustopen: false, //Specify whether at least one header should be open always (so never all headers closed)
	animatedefault: false, //Should contents open by default be animated into view?
	persiststate: true, //persist state of opened contents within browser session?
	toggleclass: ["", ""], //Two CSS classes to be applied to the header when it's collapsed and expanded, respectively ["class1", "class2"]
	togglehtml: ["suffix", "<img src='/themes/css/images/plus.gif' class='statusicon' />", "<img src='/themes/css/images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
	animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
	oninit:function(headers, expandedindices){ //custom code to run when headers have initalized
		//do nothing
	},
	onopenclose:function(header, index, state, isuseractivated){ //custom code to run whenever a header is opened or closed
		//do nothing
	}
})
</script>
<script src="<c:url value='/themes/js/jquery.jclock-1.2.0.js.txt'/>" type="text/javascript"></script>
<script type="text/javascript" src="<c:url value='/themes/js/jconfirmaction.jquery.js'/>"></script>
<script type="text/javascript">
	
	$(document).ready(function() {
		$('.ask').jConfirmAction();
	});
	
</script>
<script type="text/javascript">
$(function($) {
    $('.jclock').jclock();
});
</script>

<script language="javascript" type="text/javascript" src="<c:url value='/themes/js/niceforms.js'/>"></script>
<link rel="stylesheet" type="text/css" media="all" href="<c:url value='/themes/css/niceforms-default.css'/>" />

</head>
<body>
<div id="main_container">

	<div class="header">
            <div class="logo"><a href="#"><img src="<c:url value='/themes/css/images/logo.gif'/>" alt="Logo" title="" border="0" /></a></div>
    
    <div class="right_header">Bienvenue sur Hotel Management | <a href="login.htm" class="logout">Se connecter</a></div>
    <div class="jclock"></div>
    </div>
    
    <div class="main_content">
    
                    <div class="menu">
                        <ul>
                        <li><a class="current" href="welcome.htm">Accueil</a></li>
                        <li><a href="#">Galerie</a></li>
                        <li><a href="#">Reservation</a></li>
                        <li><a href="#">Contact</a></li>
                        </ul>
                    </div> 
