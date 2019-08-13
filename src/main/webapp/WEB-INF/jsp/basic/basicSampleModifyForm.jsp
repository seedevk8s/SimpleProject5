<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/declare.jspf" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Basic Sample</title>


<script>
	function goList() {
		document.detailForm.action = "<c:url value='/cmm/basic/selectItemList.do'/>";
		document.detailForm.submit();

	}

	function goUpdate() {
		document.detailForm.action = "<c:url value='/cmm/basic/updateItem.do'/>";
		document.detailForm.submit();
	}

	function goRefresh() {
		document.detailForm.reset();
	}
</script>
</head>
<body>
	<!-- 상단 메뉴 시작 
	<c:out value="${menuId }" />-->
	<%@include file="../include/nav.jsp"%>
	<!-- 상단 메뉴 끝 -->

	<div class="container-fluid">
		<div class="row">

			<!--  왼쪽 메뉴 시작 -->
			<c:set var="menuId" value="2" />
			<%@include file="../include/menu.jsp"%>
			<!--  왼쪽 메뉴 끝 -->

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<h1 class="page-header">수정</h1>
				<form:form commandName="basicSampleVO" id="detailForm"
					name="detailForm" class="form-horizontal" role="form">
					<form:input type="hidden" path="seq"/>
					<div class="form-group">
						<label class="col-sm-1 control-label">분류 <font
							class="text-danger">*</font></label>
						<div class="col-sm-2">
							<form:select path="category" class="form-control">
								<form:option value="전체공지" label="전체공지" />
								<form:option value="부분공지" label="부분공지" />
							</form:select>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">제목 <font
							class="text-danger">*</font></label>
						<div class="col-sm-5">
							<form:input path="title" class="form-control" type="text" />
							<form:errors path="title" />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">내용 <font
							class="text-danger">*</font></label>
						<div class="col-sm-5">
							<form:textarea path="description" rows="5" cols="60"
								class="form-control" type="text" />
							<form:errors path="description" />	
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-1 control-label">작성자 <font
							class="text-danger"></font></label>
						<div class="col-sm-2">
							<form:input path="regUser" class="form-control" type="text" readonly="true" />
							<form:errors path="regUser" />	
						</div>
					</div>
				</form:form>
				<div class="panel-group">
					<div class="panel-body" align="right">
						<a href="javascript:goList();" class="btn btn-primary"> 목록 <span
							class="glyphicon glyphicon-home"> </span>
						</a> <a href="javascript:goUpdate();" class="btn btn-success"> 
							수정 <span class="glyphicon glyphicon-floppy-saved"> </span>
						</a> 
						<!-- <a href="javascript:goRefresh();" class="btn btn-warning">
							재설정 <span class="glyphicon glyphicon-refresh"> </span>
						</a> -->
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>