<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
					<li class="active"><a
						href="<%=request.getContextPath()%>/new-result">Novo Resultado</a></li>
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
				<h1>Novo Resultado</h1>
			</div>

			<form role="form" action="result-upload" method="POST"
				enctype="multipart/form-data">
				<div class="form-group">
					<label for="exampleInputEmail1">Email address</label>
					<input id="email-address"
						type="email" class="form-control" id="exampleInputEmail1"
						placeholder="Enter email" name="email">
				</div>
				<div class="form-group">
					<label for="exampleInputFile">File input</label>
					<input id="upload-file" type="file"
						name="inputFile" id="exampleInputFile">
					<p class="help-block">Arquivo XML do resultado de testes de
						mutantes</p>
				</div>
				<button id="upload" type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>

	</div>
	<!-- /.container -->

</body>

</html>