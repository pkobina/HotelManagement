<%-- 
    Document   : fonction-edit
    Created on : 10 sept. 2016, 11:09:20
    Author     : PAUL
--%>

<%@ include file="/includes/header.jsp" %>
    

    <div class="center_content">  
    
    
    
    <div class="left_content">
    
    
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h3>User help desk</h3>
                <img src="<c:url value='/themes/css/images/info.png'/>" alt="Info" title="" class="sidebar_icon_right" />
                <p>
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                </p>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>
            
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h4>Important notice</h4>
                <img src="<c:url value='/themes/css/images/notice.png'/>" alt="" title="Notice" class="sidebar_icon_right" />
                <p>
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                </p>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>
            
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h5>Download photos</h5>
                <img src="<c:url value='/themes/css/images/photo.png'/>" alt="" title="" class="sidebar_icon_right" />
                <p>
Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.
                </p>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>  
            
            <div class="sidebar_box">
                <div class="sidebar_box_top"></div>
                <div class="sidebar_box_content">
                <h3>To do List</h3>
                <img src="<c:url value='/themes/css/images/info.png'/>" alt="" title="" class="sidebar_icon_right" />
                <ul>
                <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</li>
                 <li>Lorem ipsum dolor sit ametconsectetur <strong>adipisicing</strong> elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.</li>
                  <li>Lorem ipsum dolor sit amet, consectetur <a href="#">adipisicing</a> elit.</li>
                   <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</li>
                    <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</li>
                     <li>Lorem ipsum dolor sit amet, consectetur adipisicing elit.</li>
                </ul>                
                </div>
                <div class="sidebar_box_bottom"></div>
            </div>
              
    
    </div>  <!--end of left content --> 

    <div class="right_content">
        
    <center><h1>Enregistrement des fonctions médicales</h1> 

        <form:form commandName="employee" method="POST" modelAttribute="employee"> 
            <fieldset style="width: 200px">
                <legend>Personnel</legend>
                <table>
                    <tr>
                        <td><form:label path="name">Nom: </form:label></td>
                        <td><form:input path="name" size="20"/>
                            <label class="compulsory">*</label>
                            <form:errors path="name" cssClass="error"/></td>   
                    </tr>
                    <tr>
                        <td><label for="sexe">Sexe: </label> </td>
                        <td><form:select path="sexe" size="8">
                                <form:option value="" label="-sexe-"/>
                                <form:option value="M" label="M"/>
                                <form:option value="F" label="F"/>
                            </form:select>
                            <label class="compulsory">*</label>
                            <form:errors path="sexe" cssClass="error"/></td>
                    </tr>
                    <tr>
                        <td><form:label path="phone">Telephone: </form:label></td>
                        <td><form:input path="phone" size="15"/>
                            <label class="compulsory">*</label>
                            <form:errors path="phone" cssClass="error"/></td>   
                    </tr>
                    <tr>
                        <td><form:label path="email">Email: </form:label></td>
                        <td><form:input path="email" size="25"/>
                            <label class="compulsory">*</label>
                            <form:errors path="email" cssClass="error"/></td>   
                    </tr>
                    <tr>
                        <td>    
                            <form:label path="role">Fonction: </form:label>
                            </td>
                            <td>
                            <form:select path="fonction">
                                <form:option label="-fonctions-" value="-1"></form:option>
                                <form:options items="${fonction}" itemValue="id" itemLabel="name"/>
                            </form:select>
                        </td>
                    </tr>
                    <tr>
                        <td><form:label path="address">Adresse: </form:label></td>
                        <td><form:textarea path="address" cols="15" rows="3"/><form:errors path="address" cssClass="error"/></td>
                    </tr>
                    <td>&nbsp;</td><td>&nbsp;</td>
                    <tr> 
                        <td colspan="2"><center><input type="Submit" value="Valider"/></center></td>
                    </tr> 
                </table>      
            </fieldset>           
        </form:form></center>

    </div>  <!--end of right content --> 
          
                    
  </div>   <!--end of center content --> 

<%@ include file="/includes/footer.jsp" %>
