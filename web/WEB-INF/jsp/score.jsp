<%@include file="header.jsp" %>   
this is content of score</br>
<h3> ${message}</h3>
     <table >
         <tr>
             <th>score</th>
             <th>class name</th>

         </tr>
              <c:forEach items="${scores}" var="lists">
         <tr>
             <td><input readonly type="text" name="score" value="${lists.score}"/></td>
             <td><input readonly type="text" name="class_name" value="${lists.class_name}"/></td>


         </tr>
                                    
                </c:forEach>
     </table>

<%@include file="footer.jsp" %>