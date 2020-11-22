<%@include file="header.jsp" %>   
this is content of student manager</br>
<h3> ${message}</h3>
     <table >
         <tr>
             <th>username</th>
             <th>password</th>
             <th>email</th>
             <th>role</th>
             <th>class</th>
             <th>chuc nang</th>
         </tr>
              <c:forEach items="${users}" var="lists">
         <tr>
         <form action="" method="post">
             <td><input readonly type="text" name="username" value="${lists.username}"/></td>
             <td><input type="password" name="password" value="${lists.password}"/></td>
             <td><input type="text" name="email" value="${lists.email}"/></td>
             <td><input readonly type="text" name="role_name" value="${lists.role_name}"/></td>
             <td><input readonly typen="text" name="class_name" value="${lists.class_name}"/></td>
             <td><input type="submit" name="submit" value="edit"></td>
         </form>
         </tr>
                                    
                </c:forEach>
     </table>

<%@include file="footer.jsp" %>