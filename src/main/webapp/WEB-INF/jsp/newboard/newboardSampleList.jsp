<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/declare.jspf" %>
<%-- 
    JSP Name : jspName.jsp
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
<title>NewBoard Sample</title>
<script>
    function goView(id) {
        document.listForm.selectedId.value = id;
        document.listForm.action = "<c:url value='/cmm/newboard/selectItemById.do'/>";
        document.listForm.submit();
    }

    function goRegister() {
        document.listForm.action = "<c:url value='/cmm/newboard/insertItemForm.do'/>";
        document.listForm.method = "get";
        document.listForm.submit();
    }

    function goSearch() {
        document.listForm.action = "<c:url value='/cmm/newboard/selectItemList.do'/>";
        document.listForm.submit();
    }
    
    function jsPage(page) {
        document.listForm.currPage.value = page;
        document.listForm.action =  "<c:url value='/cmm/newboard/selectItemList.do'/>";
        document.listForm.submit();
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
                <form:form commandName="newBoardSampleVO" id="listForm" name="listForm"
                    method="post">
                    <h1 class="page-header">NewBoard Sample</h1>
                    <div class="panel-group">
                        <div class="panel-body" align="right">
                            <form:select path="searchCondition">
                                <form:option value="2" label="작성자" />
                                <form:option value="1" label="제목" />
                                <form:option value="0" label="분류" />
                            </form:select>
                            <form:input path="searchKeyword" />
                            <a href="javascript:goSearch();" class="btn btn-success"> 검색
                                <span class="glyphicon glyphicon-search"> </span>
                            </a> <a href="javascript:goRegister();" class="btn btn-primary">
                                등록 <span class="glyphicon glyphicon-pencil"> </span>
                            </a>
                        </div>
                    </div>
                    <input type="hidden" name="selectedId" />
                    <input type="hidden" name="currPage" value=""/>  
                    <div class="table-responsive">
                        <table class="table table-bordered table-hover" align="center">
                            <thead>
                                <tr class="info">
                                    <th class="col-md-1 text-center">번호</th>
                                    <th class="col-md-1 text-center">분류</th>
                                    <th class="col-md-7 text-center">제목</th>
                                    <th class="col-md-1 text-center">첨부파일</th>
                                    <th class="col-md-1 text-center">작성자</th>
                                    <th class="col-md-1 text-center">작성일</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:choose>
                                    <c:when test="${empty resultList}">
                                        <tr>
                                            <td colspan="6" align="center">검색된 결과가 없습니다.</td>
                                        </tr>
                                    </c:when>
                                    <c:otherwise>
                                        <c:forEach var="result" items="${resultList}"
                                            varStatus="status">
                                            <%-- <tr onclick="javascript:goView('${result.artId}')"> --%>
                                            <tr onclick="javascript:goView('${result.artId}')">
                                                <td class="text-center"><c:out value="${result.artId}" /></td>
                                                <td class="text-center"><c:out value="${result.artCategory}" /></td>
                                                <td class="text-left"><c:out value="${result.artSubject}" /></td>
                                                <td class="text-center">
                                                    <c:choose>
                                                        <c:when test="${result.attachYn == 'Y'}">
                                                            <span class="glyphicon glyphicon-paperclip" />                                              
                                                        </c:when>
                                                    </c:choose>
                                                </td>
                                                <td class="text-center"><c:out value="${result.regUser}" /></td>
                                                <td class="text-center"><c:out value="${result.regDate}" /></td>
                                            </tr>
                                        </c:forEach>

                                    </c:otherwise>
                                </c:choose>
                            </tbody>
                        </table>
                    </div>
                </form:form>
                <div align="center">
                    <able:pagination paginationInfo="${page}" type="image" jsFunction="jsPage"/>
                </div>
            </div>
        </div>
    </div>	
</body>
</html>






























