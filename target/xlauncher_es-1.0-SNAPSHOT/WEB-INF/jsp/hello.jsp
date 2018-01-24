<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/1/10 0010
  Time: 13:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Hello Hello</title>
</head>
<body>
    <h2>Message :${message} ${name} ${age}</h2>
    <input type="button" name="back" onclick="javascript:history.back(-1);"value="返回"/>
    <br><br>
    <script language="javascript">
        for (j=1;j<=9;j++){
            for (i=1;i<=j;i++){
                document.write(i+"*"+j+"="+i*j+" ")
                if (i==2 && j<=4){
                    document.write(" ")}}

            document.write("<br>")
        }
    </script>
</body>

</html>
