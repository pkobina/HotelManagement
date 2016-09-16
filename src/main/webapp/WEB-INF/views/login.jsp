<%-- 
    Document   : login
    Created on : Sep 11, 2016, 12:23:06 AM
    Author     : PAUL
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title>Hotel Management | Login</title>
        <link rel="stylesheet" type="text/css" href="<c:url value='/themes/css/style.css'/>" />
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
                togglehtml: ["suffix", "<img src='${pageContext.request.contextPath}/themes/css/images/plus.gif' class='statusicon' />", "<img src='${pageContext.request.contextPath}/themes/css/images/minus.gif' class='statusicon' />"], //Additional HTML added to the header when it's collapsed and expanded, respectively  ["position", "html1", "html2"] (see docs)
                animatespeed: "fast", //speed of animation: integer in milliseconds (ie: 200), or keywords "fast", "normal", or "slow"
                oninit: function(headers, expandedindices) { //custom code to run when headers have initalized
                    //do nothing
                },
                onopenclose: function(header, index, state, isuseractivated) { //custom code to run whenever a header is opened or closed
                    //do nothing
                }
            })
        </script>

        <script type="text/javascript" src="<c:url value='/themes/js/jconfirmaction.jquery.js'/>"></script>
        <script type="text/javascript">

            $(document).ready(function() {
                $('.ask').jConfirmAction();
            });

        </script>

        <script language="javascript" type="text/javascript" src="<c:url value='/themes/js/niceforms.js'/>"></script>
        <link rel="stylesheet" type="text/css" media="all" href="<c:url value='/themes/css/niceforms-default.css'/>" />

    </head>
    <body>
        <div id="main_container">

            <div class="header_login">
                <div class="logo"><a href="#"><img src="<c:url value='/themes/css/images/logo.gif'/>" alt="Logo" title="" border="0" /></a></div>

            </div>


            <div class="login_form">

                <h3>AUTHENTIFICATION</h3>


                <form action="" method="post" class="niceform">

                    <fieldset>
                        <dl>
                            <dt><label for="email">Nom d'utilisateur:</label></dt>
                            <dd><input type="text" name="" id="" size="54"/></dd>
                        </dl>
                        <dl>
                            <dt><label for="password">Mot de Passe:</label></dt>
                            <dd><input type="text" name="" id="" size="54"/></dd>
                        </dl>

                        <dl>
                            <dt><label></label></dt>

                        </dl>

                        <dl class="submit">
                            <input type="submit" name="submit" id="submit" value="Connexion" />
                        </dl>

                    </fieldset>

                </form>
            </div>  



            <div class="footer_login">

                <div class="left_footer_login">HOTEL MANAGEMENT | Developped by <a href="http://www.ifi.edu.vn">P20 Students</a></div>
                <div class="right_footer_login"><a href="http://www.ifi.edu.vn"><img src="<c:url value='/themes/css/images/indeziner_logo.gif'/>" alt="" title="" border="0" /></a></div>

            </div>

        </div>		
    </body>
</html>
