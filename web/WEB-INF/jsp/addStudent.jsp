<%@include file="header.jsp" %>   
     this is content off add student
     ${message}
     <form action="" method="post">
         Username<input type="text" name="username" value="username"/>
         Password<input type="password" value="" name="password" placeholder="password"/>
         Email<input type="text" value="" placeholder="email" name="email"/>
         Role<select name="role_name">
         <c:forEach items="${listrole}" var="role">
             <option value="${role.role_name}">${role.role_name}</option>
         </c:forEach>
         </select>
         
         Class <select name="class_name">
         <c:forEach items="${listclass}" var="class">
             <option value="${class.class_name}">${class.class_name}</option>
         </c:forEach>
         </select>
         
         
         <input type="submit" value="Create"/>
   
     </form>
<%@include file="footer.jsp" %>