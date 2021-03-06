<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,br.unicamp.ic.mc437.g1.entity.Result"
	%>
<%@ page import="br.unicamp.ic.mc437.g1.entity.TestResult" %>
<%
SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta name="viewport" content="user-scalable=no, initial-scale=1, maximum-scale=1, minimum-scale=1, width=device-width, height=device-height, target-densitydpi=device-dpi" />

<link rel='stylesheet'
	href='<%=org.webjars.AssetLocator
					.getWebJarPath("css/bootstrap.min.css")%>'>
<!-- <link rel='stylesheet'
	href='<%=org.webjars.AssetLocator
					.getWebJarPath("css/bootstrap-theme.min.css")%>'> -->
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/css/index.css'>
<script type='text/javascript'
	src='<%=org.webjars.AssetLocator.getWebJarPath("jquery.min.js")%>'></script>
<script type='text/javascript'
	src='<%=org.webjars.AssetLocator
					.getWebJarPath("js/bootstrap.min.js")%>'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mutant Spotlight</title>


    <script type="text/javascript">
        $(window).load(function() {
            $(".loader").fadeOut("fast");
        })
    </script>
</head>

<body>
    <div class="loader"></div>

	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="./">Mutant Spotlight</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="./">Home</a></li>
					<li><a href="./new-result">Novo Resultado</a></li>
					<li class="active"><a
						href="<%=request.getContextPath()%>/result-list">Resultados
							Enviados</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">

		<div class="new-result-form">
			<div class="page-header">
				<h1>Resultados :</h1>
			</div>
		</div>
		
		<div >
			<form action="result-list">
			<table width="100%">
				<tr>
					<td align="right">
						<input type="text" class="form-control" placeholder="Busca" id="criteria" name="criteria" value="<%=request.getAttribute("criteria") %>" autofocus />
					</td>
					<td style="width: 100px" align="right"> <input type="submit" class="btn btn-default" id="search" value="Filtrar"/> </td>
				</tr>
			</table>
			</form>
		</div>

		<table class="table table-striped" id="result_table">
			<thead>
				<tr>
					<th>ID</<th>
					<th>Nome</th>
					<th>Usuário</th>
					<th>Data</th>
				</tr>
			</thead>
			<tbody>
				<%
					List<TestResult> results = (List<TestResult>)request.getAttribute("results");
					for (TestResult r : results) {
				%>
				<tr id="result<%= r.getId() %>">
					<td style="width:25px;"><%= r.getId() %></td>
					<td><a href="<%=request.getContextPath()%>/result/<%=r.getId()%>"><%= r.getName() %></a></td>
					<td><a href="<%=request.getContextPath()%>/result/<%=r.getId()%>"><%= r.getEmail() %></a></td>
					<td><a href="<%=request.getContextPath()%>/result/<%=r.getId()%>"><%= dateFormat.format(r.getDate()) %></a></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>

	</div>
	<!-- /.container -->

</body>

</html>