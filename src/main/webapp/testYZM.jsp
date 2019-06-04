<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<title>Insert title here</title>
</head>
<body>
<script src="js/jquery.min.js"></script>
       <div>
            <img id="captchaImg" style="CURSOR: pointer" onclick="changeCaptcha()"
              title="看不清楚?请点击刷新验证码!" src="captchaServlet"
                  height="18" width="55">
         <a href="javascript:;"
           onClick="changeCaptcha()" style="color: #666;">看不清楚</a> <span id="code_span" style="color: red"></span>
  </div>
</body>
<script >
//更换验证码
function changeCaptcha() {
    $("#captchaImg").attr('src', 'captchaServlet?t=' + (new Date().getTime()));
}
</script>
</html>