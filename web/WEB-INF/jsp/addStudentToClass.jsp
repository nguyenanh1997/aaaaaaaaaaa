<%@include file="header.jsp" %>   
     this is content off add student into a class
     ${message}
     <form action="" method="post">
         
         <table>
             <tr>
                 <td>Danh sach Hoc sinh<br>
                    <c:forEach items="${listuser}" var="user">
                        <input type="checkbox" value="${user.username}">${user.username}</option>
                    </c:forEach></td>
                    <td>Danh Sach Lop Hoc<br>
                    <select name="class_name">
                    <c:forEach items="${listclass}" var="class">
                        <option value="${class.class_name}">${class.class_name}</option>
                    </c:forEach>
                    </select>
                </td>
             </tr>
         </table>
         <
            

         
         
         </select>
         
         
         <input type="submit" value="add"/>
   
     </form>
<%@include file="footer.jsp" %>