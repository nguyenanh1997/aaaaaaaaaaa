<%@include file="header.jsp" %>   
this is content of student manager</br>
<a href="addClass.htm" >Add Class</a><br>
<br><br>
<h3>${message}</h3>
     <table >
         <tr>
             <th>id</th>
             <th>Class name</th>

         </tr>
              <c:forEach items="${classList}" var="lists">
         <tr>
         <form action="classList.htm" method="post">
             <td><input readonly type="number" name="class_id" value="${lists.class_id}"/></td>
             <td><input type="text" name="class_name" value="${lists.class_name}"/></td>
             <td><input type="submit" name="submit" value="edit"><input type="submit" name="submit" value="delete"></td>
         </form>
         </tr>
                                    
                </c:forEach>
     </table>

<%@include file="footer.jsp" %>