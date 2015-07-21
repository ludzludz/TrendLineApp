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
			<td><h2>${name}</h2></td>
		</tr>
		<tr>
			<td><div class="tabList">
					<input id="tab111" type="radio" name="tabList" checked> <label
						for="tab111" title="Name">Name</label> <input id="tab222"
						type="radio" name="tabList"> <label for="tab222"
						title="Income">Income</label>
					<section id="content111">
						List of companies:<br>
						<c:forEach items="${companies}" var="company">
							${company.name} ${company.shortcut}<br>
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
					<section id="content33">
						<br> Name: ${name} <br> Price: ${price} <br>
						Change: ${change} <br> Peg: ${peg} <br> Dividend:
						${dividend} <br>
					</section>
					<section id="content44">
						<p>Charts</p>
					</section>
					<section id="content55">
						<p>Quotations</p>
					</section>
				</div></td>
		</tr>
	</table>
</body>
</html>