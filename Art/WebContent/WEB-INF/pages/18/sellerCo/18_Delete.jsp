<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<form action="<c:url value="/18/cDelete.ctrl"/>">
  <div class="form-row" style="text-align: center;">
    <div class="form-group">
      <label for="id">請輸入欲刪除之課程編號</label>
      <input type="text" class="form-control" id="coId" name="coId">
    </div>
  </div>
 
  <button type="submit" class="btn btn-primary">送出</button>
</form>