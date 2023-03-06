<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<!DOCTYPE html>
<html lang="ko">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<title>협력업체</title>
	
	<jsp:include page="../common/common.jsp"></jsp:include>
	
	<c:if test="${not empty sessionScope}">
	<script src="${pageContext.request.contextPath}/resources/manager/company/js/companyList.js"></script>
	</c:if>
	
</head>

<body id="page-top" oncontextmenu='return false' onselectstart='return false' ondragstart='return false'>
	<c:if test="${empty sessionScope.ADMIN}">
		<jsp:include page="../common/emptySession.jsp"></jsp:include>		
	</c:if>

	<c:if test="${not empty sessionScope.ADMIN}">
	<!-- Page Wrapper -->
	<div id="wrapper">

		<!-- Sidebar -->
		<jsp:include page="../common/sidebar.jsp"></jsp:include>
		<!-- End of Sidebar -->

		<!-- Content Wrapper -->
		<div class="main-panel">
		<!-- Topbar -->
		<jsp:include page="../common/topbar.jsp"></jsp:include>
		<!-- End of Topbar -->

			<!-- Main Content -->
			<div class="content">

				<!-- Begin Page Content -->
				<div class="card">

					<!-- contents -->
					<div class="card shadow mb-4">

							<div class="card-body">
								<div id="dataTable_wrapper" class="dataTables_wrapper dt-bootstrap4">
								
								<input type="hidden" id="nowPage" name="nowPage" value="${nowPage}" readonly>
								
									<div class="row">
										<div class="col-sm-12">
											<table class="table tablesorter" id="dataTable" style="text-align: center;">
												<thead>
													<tr class="aptMemTableHeaderTr" style="color: powderblue;">
														<td rowspan='2' width="12%">회사명</td>
														<td rowspan='2' width="12%">전화</td>
														<td rowspan='2' width="12%">FAX</td>
														<td colspan='3' width="30%">담당자</td>
														<td rowspan='2' width="20%">주소</td>
														<td rowspan='2' width="8%">등록일</td>
														<td rowspan='2' width="6%">설치작업자</td>
													</tr>
													<tr class="aptMemTableHeaderTr">
														<td width="8%">이름</td>
														<td width="10%">휴대전화</td>
														<td width="12%">이메일</td>
													</tr>
												</thead>

												<tbody>
													<c:forEach items="${LIST_COMPANY}" var="LIST_COMPANY">
														<tr>
															<td width="12%">${LIST_COMPANY.company_name}</td>
															<td width="12%">${LIST_COMPANY.company_phone}</td>
															<td width="12%">${LIST_COMPANY.company_fax}</td>
															<td width="8%">${LIST_COMPANY.staff_name}</td>
															<td width="10%">${LIST_COMPANY.staff_phone}</td>
															<td width="12%">${LIST_COMPANY.staff_email}</td>
															<td width="20%">${LIST_COMPANY.company_address}</td>
															<td width="8%">${LIST_COMPANY.time_created}</td>
															<td width="6%">${LIST_COMPANY.count_worker}</td>
														</tr>
													</c:forEach>
												</tbody>

											</table>
										</div>
									</div>
									
									<!-- 페이징 -->
									<div class="row" style="margin-top: 20px;">
										<div class="col-sm-12 col-md-12">
											<div class="dataTables_paginate paging_simple_numbers"
												id="dataTable_paginate">
												<ul class="pagination">
												<c:if test="${PAGEUTIL.startPage eq 1}">
													<li class="paginate_button page-item previous" id="dataTable_previous">
														<a class="page-link">
															<
														</a>
													</li>
													</c:if>
													
													<c:if test="${PAGEUTIL.startPage ne 1}">
													<li class="paginate_button page-item previous" id="">
														<a href="../company/companyList?nowPage=${PAGEUTIL.startPage - 1 }" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">
															<
														</a>
													</li>			
													</c:if>

													<c:if test="${PAGEUTIL.totalCount eq 0}">
													<li class="paginate_button page-item" id="">
														<a href="../company/companyList?nowPage=1" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">
															1
														</a>
													</li>			
													</c:if>
													
													<c:if test="${PAGEUTIL.totalCount ne 0}">
													<!-- 	PAGE	[1][2][3] -->
													<c:forEach var="page" begin="${PAGEUTIL.startPage}" end="${PAGEUTIL.endPage}">
													<li class="paginate_button page-item" id="">
														<a href="../company/companyList?nowPage=${page}" aria-controls="dataTable" data-dt-idx="0" tabindex="0" class="page-link">
															${page}
														</a>
													</li>			
													</c:forEach>
													</c:if>
													
													<c:if test="${PAGEUTIL.endPage eq PAGEUTIL.totalPage}">
													<li class="paginate_button page-item next" id="dataTable_previous">
														<a class="page-link">
															>
														</a>
													</li>		
													</c:if>
													
													<c:if test="${PAGEUTIL.endPage ne PAGEUTIL.totalPage}">
													<li class="paginate_button page-item next" id="dataTable_previous">
														<a href="../company/companyList?nowPage=${PAGEUTIL.endPage+1}" class="page-link">
															>
														</a>
													</li>		
													</c:if>
												</ul>
											</div>
										</div>
									</div>
									<!-- 페이징 -->

								</div>
							</div>
						</div>

				</div>
				<!-- /.container-fluid -->

			</div>
			<!-- End of Main Content -->

			<!-- Footer -->

			<jsp:include page="../common/footer.jsp"></jsp:include>
			<!-- End of Footer -->

		</div>
		<!-- End of Content Wrapper -->

	</div>
	<!-- End of Page Wrapper -->

	<!-- Scroll to Top Button-->
	<!-- Logout Modal-->
	<%-- util.jsp : logout/scroll top.. --%>
	<jsp:include page="../common/logout.jsp"></jsp:include>
	</c:if>	


</body>

</html>