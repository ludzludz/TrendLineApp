<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@include file='css/stylesTabMyAll.css'%>
<%@include file='css/stylesCompanyInfo.css'%>
<%@include file='css/stylesListOfCompanies.css'%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Title</title>
</head>

<body bgcolor="#77dd77">

	<%--<form method="POST">
    <input type="text" name="a" value="${a}"/>
    +
    <input type="text" name="b" value="${b}"/>
    = ${result} <br>
    <input type="submit">
</form>--%>

	<table align="center">
		<tr>
			<td><div class="tabs">
					<input id="tab1" type="radio" name="tabs" checked> <label
						for="tab1" title="All">All</label> <input id="tab2" type="radio"
						name="tabs"> <label for="tab2" title="My">My</label>
					<section id="content1">
						<p>
						<form method="POST">
							<input type="text" name="search" value="${search}" /> <input
								type="submit" value="Search">
						</form>
						</p>
					</section>
					<section id="content2">
						<p>
						<form method="POST">
							<input type="text" name="search" value="${search}" /> <input
								type="submit" value="Search">
						</form>
						</p>
					</section>
				</div></td>
			<td>Main page</td>
		</tr>
		<tr>
			<td><div class="tabList">
					<input id="tab111" type="radio" name="tabList" checked> <label
						for="tab111" title="Name">Name</label> <input id="tab222"
						type="radio" name="tabList"> <label for="tab222"
						title="Income">Income</label>
					<section id="content111">
						List of companies:<br>
						<c:forEach var="company" items="${companyList}">
							<c:out value="${company}" default="none" />
							<br>
						</c:forEach>
					</section>
					<section id="content222">Sort by income</section>
				</div></td>
			<td><div class="tab">
					<input id="tab33" type="radio" name="tab" checked> <label
						for="tab33" title="Basic Data">Basic Data</label> <input
						id="tab44" type="radio" name="tab"> <label for="tab44"
						title="Charts">Charts</label> <input id="tab55" type="radio"
						name="tab"> <label for="tab55" title="Quotations">Quotations</label>
					<section id="content33">Basic Data</section>
					<section id="content44">
						<p>Charts</p>
					</section>
					<section id="content55">
						<p>Quotations</p>
					</section>
				</div></td>
		</tr>
	</table>

	<form action="calc/aa" method="post">
  <input name="say" value="Hi">
  <input name="to" value="Mom">
  <button>Send my greetings</button>
</form>
	${aaa}
</body>
</html>