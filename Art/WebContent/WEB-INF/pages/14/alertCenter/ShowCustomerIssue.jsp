<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>使用者申訴表單</title>
</head>
<body>
<div class="card text-center">
  <div class="card-header">
    使用者申訴表單
  </div>
  <div class="card-body">
    <h4 class="card-title">主旨：${alert.issue }</h4>
    <h5 class="card-title">會員編號：${alert.memberId }</h5>
    <h5 class="card-title">會員姓名：${alert.memberName }</h5>
    <h4>申訴內容：</h4>
    <p class="card-text">${alert.description}</p>
    <a href="<c:url value='/14/AlertsDispatcher?issue=${alert.issue}&issueId=${alert.issueId}'/>" class="btn btn-primary">前往處理</a>
    <a href="<c:url value='/14/showAltartCenterCRUD'/>" class="btn btn-primary">返回申訴通知中心</a>
  </div>
  <div class="card-footer text-muted">
    申訴時間：${alert.time}
  </div>
</div>
</body>
</html>