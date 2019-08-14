<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/declare.jspf" %>
<%-- 
    JSP Name : boardSampleDetailView.jsp
    Description : 설명을 기술합니다.
    author hojin
    since 2019. 8. 13.
    version 1.0
    Modification Information
       since          author              description
    ===========    =============    ===========================
    2019. 8. 13.     hojin     	최초 생성
--%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>NewBoard Sample Detail</title>
<script>
    $(document).ready(function() {
        $('#cmtRegUser').val('');
        $('#cmtContent').val('');
    });
    
    function goList() {
        document.detailForm.action = "<c:url value='/cmm/newboard/selectItemList.do'/>";
        document.detailForm.submit();

    }

    function goModify() {
        document.detailForm.action = "<c:url value='/cmm/newboard/updateItemForm.do'/>";
        document.detailForm.submit();
    }
    
    function goDelete() {
        if (confirm('삭제 하시겠습니까?')) {
            document.detailForm.action = "<c:url value='/cmm/newboard/deleteItem.do'/>";
            document.detailForm.submit();
        } else {
            return false;
        }
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
            <c:set var="menuId" value="4" />
            <%@include file="../include/menu.jsp"%>
            <!--  왼쪽 메뉴 끝 -->

            <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
                <h1 class="page-header">조회</h1>
                <form:form commandName="newBoardSampleVO" id="detailForm"
                    name="detailForm">
                    <form:input type="hidden" path="artId" name="artId"/>
                    <input type="hidden" name="selectedCmtId" />
                    <div class="table-responsive">
                        <table class="table table-bordered" align="center">
                            <tr>
                                <td class="col-md-1 text-center active">분류</td>
                                <td class="col-md-11">
                                    <form:input path="artCategory" class="form-control" type="text" readonly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-md-1 text-center active">제목</td>
                                <td class="col-md-11">
                                    <form:input path="artSubject" class="form-control" type="text" readonly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-md-1 text-center active">내용</td>
                                <td class="col-md-11">
                                    <form:textarea path="artContent" class="form-control" type="text" rows="10" readonly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-md-1 text-center active">작성자</td>
                                <td class="col-md-11">
                                    <form:input path="regUser" class="form-control" type="text" readonly="true"/>
                                </td>
                            </tr>
                            <tr>
                                <td class="col-md-1 text-center active">첨부파일</td>
                                <td class="col-md-11">
                                    <table>
                                        <c:forEach var="fileVO" items="${fileList}">
                                            <tr>
                                                <td>${fileVO.originalFileName}&nbsp;</td>
                                                <td><a
                                                    href='<c:url value="/cmm/newboard/fileDownload.do?fileId=${fileVO.fileId}"/>'>
                                                        <span class="glyphicon glyphicon-download-alt"></span>
                                                </a></td>
                                            </tr>
                                        </c:forEach>
                                    </table>
                                </td>
                            </tr>
                        </table>
                    </div>
                    <div class="panel-group">
                        <div class="panel-body" align="right">
                            <a href="javascript:goList();" class="btn btn-primary"> 목록 <span
                                class="glyphicon glyphicon-home"> </span>
                            </a> <a
                                href="javascript:goModify('<c:out value="${result.artId}"/>');"
                                class="btn btn-success"> 수정 <span
                                class="glyphicon glyphicon-floppy-saved"> </span>
                            </a>
                            <a href="javascript:goDelete('<c:out value="${result.artId}"/>')" class="btn btn-danger">
                                삭제 <span class="glyphicon glyphicon-trash"></span>
                            </a>
                        </div>
                    </div>
                </form:form>
            </div>
        </div>
    </div>	
</body>
</html>












































