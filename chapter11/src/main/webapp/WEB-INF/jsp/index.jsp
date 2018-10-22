<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <title>Title</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
单个文件上传：<br/>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input name="file" type="file">
    <input value="提交上传" type="submit">
</form>

<table>
    <tr>
        <td>
            ${msg}
            ${fileDir}
        </td>
    <tr>
        <td>

            图片： <img src="${fileDir}" name="图片">
        </td>
    </tr>
</table>
</body>