<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,br.unicamp.ic.mc437.g1.entity.TestResult,br.unicamp.ic.mc437.g1.entity.TestOutput,
	br.unicamp.ic.mc437.g1.entity.TestSetResult,br.unicamp.ic.mc437.g1.entity.TestCaseResult"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/<%=org.webjars.AssetLocator
					.getWebJarPath("css/bootstrap.min.css")%>'>
<!-- <link rel='stylesheet'
	href='<%=request.getContextPath()%>/<%=org.webjars.AssetLocator
					.getWebJarPath("css/bootstrap-theme.min.css")%>'> -->
<link rel='stylesheet'
	href='<%=request.getContextPath()%>/css/index.css'>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/<%=org.webjars.AssetLocator.getWebJarPath("jquery.min.js")%>'></script>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/<%=org.webjars.AssetLocator
					.getWebJarPath("js/bootstrap.min.js")%>'></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Mutant Spotlight</title>
</head>

<body>
	<div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target=".navbar-collapse">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="<%=request.getContextPath()%>/">Mutant
					Spotlight</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li><a href="<%=request.getContextPath()%>/">Home</a></li>
					<li><a href="<%=request.getContextPath()%>/new-result">Novo
							Resultado</a></li>
					<li><a href="<%=request.getContextPath()%>/result-list">Resultados
							Enviados</a></li>
				</ul>
			</div>
			<!--/.nav-collapse -->
		</div>
	</div>

	<div class="container">

		<div class="new-result-form">
			<div class="page-header">
				<h1>
					Resultados do Test Case
					<%=request.getAttribute("id")%>:
				</h1>
			</div>
		</div>

		<%
			TestResult res = (TestResult) request.getAttribute("result");
			List<TestSetResult> sets = res.getTestSetResults();
			for (TestSetResult set : sets) {
		%>

		<div class="panel panel-default">
			<div class="panel-heading">
				Set
				<%=set.getId()%>:
			</div>
			<div class="panel-body">
				
				<%
					List<TestCaseResult> cases = set.getTestCaseResults();
						for (TestCaseResult testCase : cases) {
				%>
				
				<div class="panel panel-default">
					<div class="panel-heading">
						Test Case
						<%=testCase.getId()%>:
					</div>
					<table class="table">
					<thead>
						<tr>
							<th>#</th>
							<th>Chave</th>
							<th>Morto?</th>
							<th>Índice</th>
							<th>Eval Falhou?</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<TestOutput> outputs = testCase.getTestOutputs();
									for (TestOutput output : outputs) {
						%>
						<tr>
							<td style="width:25px;"><%=output.getId()%></td>
							<td><%=output.getMutantKey()%></td>
							<td><%=output.getDead()? "Sim" : "Não"%></td>
							<td><%=output.getDeathIndex()%></td>
							<td><%=output.getEvalFailed() %></td>
						</tr>
						<%
							}
						%>
					</tbody>
					</table>
				</div>
				<%
					}
				%>
				
			</table>
			</div>
		</div>

		<%
			}
		%>


	</div>
	<!-- /.container -->

</body>

</html>