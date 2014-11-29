<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="java.util.List,br.unicamp.ic.mc437.g1.entity.TestResult,br.unicamp.ic.mc437.g1.entity.TestOutput,
	br.unicamp.ic.mc437.g1.entity.TestSetResult,br.unicamp.ic.mc437.g1.entity.TestCaseResult,
	br.unicamp.ic.mc437.g1.entity.Mutant,br.unicamp.ic.mc437.g1.entity.MutantImplementation,
	br.unicamp.ic.mc437.g1.entity.ResultModel,br.unicamp.ic.mc437.g1.entity.TestCase,
	br.unicamp.ic.mc437.g1.entity.TestCaseEntry,
	static br.unicamp.ic.mc437.g1.util.FormatUtils.*"%>
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
<link rel='stylesheet' type="text/css"
	href='<%=request.getContextPath()%>/css/graph.css'>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/<%=org.webjars.AssetLocator.getWebJarPath("jquery.min.js")%>'></script>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/<%=org.webjars.AssetLocator.getWebJarPath("less.js")%>'></script>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/<%=org.webjars.AssetLocator
					.getWebJarPath("js/bootstrap.min.js")%>'></script>
<link rel="stylesheet"
	href="<%=request.getContextPath()%>/syntax_highlight/styles/default.css">
<script
	src="<%=request.getContextPath()%>/syntax_highlight/highlight.pack.js"></script>

<%--<script>
	if (window.navigator.userAgent != "JBehave")
		hljs.initHighlightingOnLoad();
</script>--%>
<script type='text/javascript'
	src='<%=request.getContextPath()%>/javascript/highcharts.js'>
	
</script>


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

		<%
        TestResult res = (TestResult) request.getAttribute("result");
        %>

		<div class="new-result-form">
			<div class="page-header">
				<div class="row">
					<div class="col-md-8">
						<h1>
							Resultados do Teste
							<%=((TestResult) request.getAttribute("result")).getName()%>:
						</h1>
					</div>
					<div class="col-md-4">
						<!-- <div id="test_final_result"></div> -->
						<div id="graph-score-final" class="radial-progress" data-progress="<%= res.getScore() %>">
							<div class="circle">
								<div class="mask full">
									<div class="fill"></div>
								</div>
								<div class="mask half">
									<div class="fill"></div>
									<div class="fill fix"></div>
								</div>
								<div class="shadow"></div>
							</div>
							<div class="inset">
								<div class="percentage"></div>
							</div>
						</div>
					</div>

				</div>

				<div style="display: none;" id="test_result_score"
					score="<%=res.getScore()%>"></div>
			</div>
		</div>

		<%
			List<TestSetResult> sets = res.getTestSetResults();
			int countSet = 0;
			for (TestSetResult set : sets) {
		%>

		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default">
					<div class="panel-heading">
						<div class="row">
							<div class="col-md-8">
								Conjunto de Testes
								<%=set.getCod()%>:
							</div>
						</div>
					</div>
                    <div style="display: none;" id="test_set_score"
                         test_set_id='<%=set.getCod()%>'
                         score="<%=set.getScore()%>"></div>
                    <div style="display: none;" id="test_set_score<%=countSet%>"
                         test_set_id='<%=set.getCod()%>'
                         score="<%=set.getScore()%>"></div>
					<div class="panel-body">
						<div>
						<b>Score:</b>
							<div id="graph-score-set-<%= countSet++ %>" class="radial-progress-small"
								data-progress="<%= set.getScore() %>">
								<div class="circle">
									<div class="mask full">
										<div class="fill"></div>
									</div>
									<div class="mask half">
										<div class="fill"></div>
										<div class="fill fix"></div>
									</div>
									<div class="shadow"></div>
								</div>
								<div class="inset">
									<div class="percentage"></div>
								</div>
							</div>
						</div>
						<%
					List<TestCaseResult> cases = set.getTestCaseResults();
						for (TestCaseResult testCase : cases) {
				%>

						<div class="panel panel-default">
							<div class="panel-heading">
								<div class="row">
									<div class="col-md-8">
										Caso de Teste
										<%=getIdFromKey(testCase.getTestCaseKey())%>:
									</div>

								</div>

							</div>
							<table class="table table-hover">
								<thead>
									<tr>
										<th>Operador de Mutação</th>
										<th>Índice</th>
										<th>Morto?</th>
										<th>Índice de Morte</th>
										<th>Compilou?</th>
									</tr>
								</thead>
								<tbody>
									<%
								List<TestOutput> outputs = testCase.getTestOutputs();
										for (TestOutput output : outputs) {
							%>
									<tr>
										<td><%=getMutantOperatorName(output.getMutantKey())%></td>
										<td><%=getMutantOperatorIndex(output.getMutantKey())%></td>
										<td><%=yesNo(output.getDead())%></td>
										<td><%=output.getDead() ? output.getDeathIndex() : "-"%></td>
										<td><%=yesNo(!output.getEvalFailed())%></td>
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
			</div>
		</div>

		<%
			}
		%>

		<h3>Mutantes:</h3>

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
					<b>Operador de Mutação:</b>
					<%=getMutantOperator(mutant.getPath())%></p>
				<p>
					<b>ID de Contexto:</b>
					<%=mutant.getContextId()%></p>
				<p>
					<b>Flag de Build:</b>
					<%=mutant.getBuildFlag()%></p>
				<p>
					<b>Conv Flag:</b>
					<%=mutant.getConvFlag()%></p>
				<p>
					<b>Ignorar Erro:</b>
					<%=yesNo(mutant.getIgnoreErrors())%></p>
				<p>
					<b>Implementações:</b>
				</p>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Implementação</th>
							<th>Mutante?</th>
						</tr>
					</thead>
					<tbody>
						<%
							int impCount = 1;
							List<MutantImplementation> implementations = mutant
										.getImplementatios();
								for (MutantImplementation implementation : implementations) {
						%>
						<tr>
							<td><%=impCount++%></td>
							<td><a href="#" <%--onclick="hljs.highlightBlock($('#myModal<%=implementation.getId()%> pre code')[0]);"--%> data-toggle="modal"
								data-target="#myModal<%=implementation.getId()%>">Visualizar</a></td>
							<td><%=yesNo(implementation.getIsMutant())%></td>

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
					<div class="modal-dialog modal-lg">
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

		<h3>Modelos do Resultado:</h3>

		<%
			List<ResultModel> models = res.getResultModels();
			for (ResultModel model : models) {
		%>
		<div class="panel panel-default">
			<div class="panel-heading">
				Modelo
				<%=model.getName()%>:
			</div>
			<div class="panel-body">

				<p>
					<b>Implementações:</b>
				</p>
				<table class="table table-hover">
					<thead>
						<tr>
							<th>#</th>
							<th>Implementação</th>
							<th>Mutante?</th>
						</tr>
					</thead>
					<tbody>
						<%
							int impCount = 1;
							List<MutantImplementation> implementations = model.getImplementatios();
							for (MutantImplementation implementation : implementations) {
						%>
						<tr>
							<td><%=impCount++%></td>
							<td><a href="#" data-toggle="modal" <%--onclick="hljs.highlightBlock($('#myModal<%=implementation.getId()%> pre code')[0]);"--%>
								data-target="#myModal<%=implementation.getId()%>">Visualizar</a></td>
							<td><%=yesNo(implementation.getIsMutant())%></td>

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
					<div class="modal-dialog modal-lg">
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

		<h3>Casos de Teste:</h3>

		<%
			List<TestCase> testCases = res.getTestCases();
			for (TestCase testCase : testCases) {
				%>
		<div class="panel panel-default">
			<div class="panel-heading">Casos de Teste</div>
			<div class="panel-body">
				<table class="table table-hover">
					<thead>
						<tr>
							<th>Conjunto</th>
							<th>Caso de Teste</th>
							<th>Nome</th>
							<!-- <th>Content</th> -->
						</tr>
					</thead>
					<tbody>
						<%
								List<TestCaseEntry> entries = testCase.getTestCaseEntries();
								for (TestCaseEntry entry : entries) {
							%>
						<tr>
							<td><%= getIdFromKey(entry.getKey()) %></td>
							<td><%= getSetFromKey(entry.getKey()) %></td>
							<td><%= entry.getTestCaseEntryValue().getName() %></td>
							<!-- <td><%= entry.getTestCaseEntryValue().toString()%></td> -->
						</tr>
						<%
								}
							%>
					</tbody>
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