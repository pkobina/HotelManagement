<%-- 
    Document   : fonction-edit
    Created on : 10 sept. 2016, 11:09:20
    Author     : PAUL
--%>

<%@ include file="/includes/header.jsp" %>
    

    <div class="center_content">  
    
        <%@ include file="../includes/left-menu.jsp" %>
        <%@ include file="../includes/left-content.jsp" %>
        <!-- left content -->

    <div class="right_content">
        
    <center><h1>Enregistrement des fonctions hotelieres</h1> 

        <form:form method="POST" modelAttribute="roomtype"> 
            <fieldset style="width: 200px">
                <legend>Fonctions</legend>
                <table>
                    <tr>
                        <td><form:label path="nameType">Nom: </form:label></td>
                        <td><form:input path="nameType" size="20"/>
                            <label class="compulsory">*</label>
                            <form:errors path="nameType" cssClass="error"/></td>   
                    </tr>
                    <tr>
                        <td><form:label path="priceType">Prix/Tarif: </form:label></td>
                        <td><form:input path="priceType" size="20"/>
                            <label class="compulsory">*</label>
                            <form:errors path="priceType" cssClass="error"/></td>   
                    </tr>
                    <tr>
                        <td><form:label path="descType">Description: </form:label></td>
                        <td><form:textarea path="descType" cols="15" rows="3"/><form:errors path="descType" cssClass="error"/></td>
                    </tr>
                    <tr>
                    <td>&nbsp;</td><td>&nbsp;</td>
                    </tr>
                    <tr> 
                        <td colspan="2"><center><input type="Submit" value="Valider"/></center></td>
                    </tr> 
                </table>      
            </fieldset>           
        </form:form></center>

    </div>  <!--end of right content --> 
          
                    
  </div>   <!--end of center content --> 

<%@ include file="/includes/footer.jsp" %>
