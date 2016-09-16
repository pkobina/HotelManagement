<%-- 
    Document   : fonction-list
    Created on : 13 sept. 2012, 16:19:38
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="display" uri="http://displaytag.sf.net" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
    <head> <title>Les fonctions médicales</title>
    </head>
    <body>
   <h3>Liste des fonctions médicales</h3>
    <a href="<c:url value="edit.htm?id=-1"/>" class="bt_green"><span class="bt_green_lft"></span><strong>Nouveau</strong><span class="bt_green_r"></span></a> 
    
    <table id="rounded-corner">
           <thead>
           <th scope="col" class="rounded">Fonctions</th>
           <th scope="col" class="rounded">Nombre de personnel</th>
           <th scope="col" class="rounded">Opérations</th>
           </thead>
       <tfoot>
            <tr>
        	<td colspan="3" class="rounded-foot-left"><em>${msg}</em></td>
            </tr>
       </tfoot>
        <tbody>
           <c:forEach var="f" items="${list}">
               <tr>
                   <c:url var="edit" value="edit.htm"><c:param name="id" value="${f.id}"/></c:url>
                   <c:url var="delete" value="delete.htm"><c:param name="id" value="${f.id}"/></c:url>
                   <td>${f.nom}</td>
                   <td>${f.getNumber()}</td>
                   <td>
                       <a href="<c:url value="${edit}"/>"><img src="<c:url value='/themes/css/images/user_edit.png'/>" alt="" title="Modifier" border="0" /></a>  
                       <a href="<c:url value="${delete}"/>" class="ask"><img src="<c:url value='/themes/css/images/trash.png'/>" alt="" title="Supprimer" border="0" /></a>  
                   </td>
               </tr>
           </c:forEach>
        </tbody>
        </table> 
    </body>
</html>
