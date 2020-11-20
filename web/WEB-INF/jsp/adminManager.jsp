<%@include file="header.jsp" %>   
this is content of student manager</br>
     <a href="addUser.htm" >Add student</a> 
     <table >
         <tr>
             <th>id</th>
             <th>username</th>
             <th>password</th>
             <th>email</th>
             <th>role</th>
             <th>chuc nang</th>
         </tr>
              <c:forEach items="${users}" var="lists">
         <tr>
         <form action="" method="post">
             <td><input readonly type="number" name="id" value="${lists.id}"/></td>
             <td><input readonly type="text" name="username" value="${lists.username}"/></td>
             <td><input readonly type="password" name="password" value="${lists.password}"/></td>
             <td><input readonly type="text" name="email" value="${lists.email}"/></td>
             <td>
                <select name="role_name">
                    <option selected value="${lists.role_name}">${lists.role_name}</option>
                    <c:forEach items="${listrole}" var="role">
                        <option value="${role.role_name}">${role.role_name}</option>
                    </c:forEach>
                </select>
             </td>
           
             <td><input type="submit" name="submit" value="edit"><input type="submit" name="submit" value="delete"></td>
         </form>
         </tr>
                                    
                </c:forEach>
     </table>

<%@include file="footer.jsp" %>