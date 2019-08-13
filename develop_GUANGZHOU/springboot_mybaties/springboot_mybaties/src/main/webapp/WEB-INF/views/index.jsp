<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
   <style type="text/css">
      .imgBox{
          width: 120px;
          height: 120px;
          border: 1px solid gray;
          border-radius:100%;
      }
   
   </style>
</head>
<body>
    <form action="${pageContext.request.contextPath}/fileUpload.do" method="post" enctype="multipart/form-data">
        <label>上传图片</label>
        <input type="file" name="file"/>
        <input type="submit" value="上传"/>
    </form>
    <p>图片:</p>
    <img  class="imgBox" src="${filename}" />
</body>
</html>