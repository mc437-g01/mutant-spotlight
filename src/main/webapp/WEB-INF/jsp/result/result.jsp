<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,br.unicamp.ic.mc437.g1.entity.TestResult,br.unicamp.ic.mc437.g1.entity.TestOutput,
	br.unicamp.ic.mc437.g1.entity.TestSetResult,br.unicamp.ic.mc437.g1.entity.TestCaseResult,
	br.unicamp.ic.mc437.g1.entity.Mutant,br.unicamp.ic.mc437.g1.entity.MutantImplementation"%>
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
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/syntax_highlight/styles/default.css">
<script
	src="<%=request.getContextPath()%>/syntax_highlight/highlight.pack.js"></script>
<script>
	hljs.initHighlightingOnLoad();
</script>
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
					Resultados de Test Case
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

				<p>
					<b>Cod:</b>
					<%=set.getCod()%></p>
				<p>
					<b>Identifier:</b>
					<%=set.getIdentifier()%></p>
				<p>
					<b>Path:</b>
					<%=set.getPath()%></p>
				<br />
				<%
					List<TestCaseResult> cases = set.getTestCaseResults();
						for (TestCaseResult testCase : cases) {
				%>

				<div class="panel panel-default">
					<div class="panel-heading">
						Test Case
						<%=testCase.getId()%>:
					</div>
					<div class="panel-body">
						<p>
							<b>Path:</b>
							<%=testCase.getPath()%></p>
						<p>
							<b>Key:</b>
							<%=testCase.getTestCaseKey()%></p>
					</div>
					<table class="table table-hover">
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
								<td style="width: 25px;"><%=output.getId()%></td>
								<td><%=output.getMutantKey()%></td>
								<td><%=output.getDead() ? "Sim" : "Não"%></td>
								<td><%=output.getDeathIndex()%></td>
								<td><%=output.getEvalFailed()%></td>
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
			</div>
		</div>

		<%
			}
		%>

		<h3>Mutants:</h3>

		<%
			List<Mutant> mutants = res.getMutants();
			for (Mutant mutant : mutants) {
		%>
		<div class="panel panel-default">
			<div class="panel-heading">
				Mutante
				<%=mutant.getName()%>:
			</div>
			<div class="panel-body">
				<p>
					<b>Context ID:</b>
					<%=mutant.getContextId()%></p>
				<p>
					<b>Build Flag:</b>
					<%=mutant.getBuildFlag()%></p>
				<p>
					<b>Conv Flag:</b>
					<%=mutant.getConvFlag()%></p>
				<p>
					<b>Ignore Error:</b>
					<%=mutant.getIgnoreErrors()%></p>
				<p><b>Implementações:</b></p>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Implementação</th>
							<th>Is Mutant?</th>
						</tr>
					</thead>
					<tbody>
						<%
							List<MutantImplementation> implementations = mutant
										.getImplementatios();
								for (MutantImplementation implementation : implementations) {
						%>
						<tr>
							<td><%=implementation.getId()%></td>
							<td><a href="#" data-toggle="modal"
								data-target="#myModal<%=implementation.getId()%>">Visualizar</a></td>
							<td><%=implementation.getIsMutant()%></td>

						</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<%
					for (MutantImplementation implementation : implementations) {
				%>
				<div class="modal fade" id="myModal<%=implementation.getId()%>"
					tabindex="-1" role="dialog"
					aria-labelledby="myModalLabel<%=implementation.getId()%>"
					aria-hidden="true">
					<div class="modal-dialog">
						<div class="modal-content">
							<div class="modal-header">
								<button type="button" class="close" data-dismiss="modal">
									<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
								</button>
								<h4 class="modal-title"
									id="myModalLabel<%=implementation.getId()%>">Implementação:</h4>
							</div>
							<div class="modal-body">
								<pre>
									<code><%=implementation.getContent()%></code>
								</pre>
							</div>
							<div class="modal-footer">
								<button type="button" class="btn btn-default"
									data-dismiss="modal">Close</button>
							</div>
						</div>
					</div>
				</div>
				<%
					}
				%>
			</div>
		</div>

		<%
			}
		%>


	</div>
	<!-- /.container -->

</body>

</html>