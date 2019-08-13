<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ include file="/WEB-INF/jsp/include/declare.jspf" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    
    <title>Sample Dashboard</title>
    
    <style>
        /* Base structure */
		
		/* Move down content because we have a fixed navbar that is 50px tall */
		body {
		  padding-top: 50px;
		}		
		
		/* Global add-ons */		
		.sub-header {
		  padding-bottom: 10px;
		  border-bottom: 1px solid #eee;
		}
		
		/*
		 * Top navigation
		 * Hide default border to remove 1px line.
		 */
		.navbar-fixed-top {
		  border: 0;
		}
		
		/* Sidebar */
		
		/* Hide for mobile, show later */
		.sidebar {
		  display: none;
		}
		@media (min-width: 768px) {
		  .sidebar {
		    position: fixed;
		    top: 51px;
		    bottom: 0;
		    left: 0;
		    z-index: 1000;
		    display: block;
		    padding: 20px;
		    overflow-x: hidden;
		    overflow-y: auto; /* Scrollable contents if viewport is shorter than content. */
		    background-color: #f5f5f5;
		    border-right: 1px solid #eee;
		  }
		}
		
		/* Sidebar navigation */
		.nav-sidebar {
		  margin-right: -21px; /* 20px padding + 1px border */
		  margin-bottom: 20px;
		  margin-left: -20px;
		}
		.nav-sidebar > li > a {
		  padding-right: 20px;
		  padding-left: 20px;
		}
		.nav-sidebar > .active > a,
		.nav-sidebar > .active > a:hover,
		.nav-sidebar > .active > a:focus {
		  color: #fff;
		  background-color: #428bca;
		}		
		
		/* Main content */		
		.main {
		  padding: 20px;
		}
		@media (min-width: 768px) {
		  .main {
		    padding-right: 40px;
		    padding-left: 40px;
		  }
		}
		.main .page-header {
		  margin-top: 0;
		}		
		
		/* Placeholder dashboard ideas  */		
		.placeholders {
		  margin-bottom: 30px;
		  text-align: center;
		}
		.placeholders h4 {
		  margin-bottom: 0;
		}
		.placeholder {
		  margin-bottom: 20px;
		}
		.placeholder img {
		  display: inline-block;
		  border-radius: 50%;
		}
    
    </style>
</head>
<body>
    <!-- 상단 메뉴 시작 -->
    <%@include file="include/nav.jsp" %>
    <!-- 상단 메뉴 끝 -->

    <div class="container-fluid">
      <div class="row">
        <!--  왼쪽 메뉴 시작 -->
        <c:set var="menuId" value="1"/>
        <%@include file="include/menu.jsp" %>
        <!--  왼쪽 메뉴 끝 -->
        
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h2 class="sub-header">Sample List</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>#</th>
                  <th>Sample Title</th>
                  <th>Description</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                  <td>1</td>
                  <td>Basic Sample</td>
                  <td>기본 CRUD 샘플 (SAMPLE 테이블의 목록 조회/등록/수정/삭제)</td>
                </tr>
                <tr>
                  <td>2</td>
                  <td>Board</td>
                  <td>게시판 샘플 (SAMPLE 테이블을 데이타로 목록조회/등록/수정/삭제 및 페이징, 파일업/다운로드)</td>
                </tr>                
              </tbody>
            </table>
          </div>
        </div>
      </div>
    </div>

</body>
</html>