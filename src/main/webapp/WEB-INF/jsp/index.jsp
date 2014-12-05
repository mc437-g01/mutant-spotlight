<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
				<a class="navbar-brand" href="#">Mutant Spotlight</a>
			</div>
			<div class="collapse navbar-collapse">
				<ul class="nav navbar-nav">
					<li class="active"><a href="<%=request.getContextPath()%>/">Home</a></li>
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

		<div class="home-lead">
			<h1>Mutant Spotlight</h1>
			<br>
			<p class="lead">
				Faça o upload do resultados do seu teste de mutações.<br> <br>
				<a href="<%=request.getContextPath()%>/new-result">
					<button type="button" class="btn btn-default btn-lg">
						Registrar novo resultado</button>
				</a>

			</p>
		</div>

	</div>
	<!-- /.container -->

</body>

</html>