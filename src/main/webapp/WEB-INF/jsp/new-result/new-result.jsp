<%@ page import="java.util.Objects" %>
<%@ page import="static java.lang.Boolean.parseBoolean" %>
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
    <div class="loader" style="display: none;"></div>

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

            <div id="empty-file-error" class="alert alert-danger hidden">
                O arquivo está vazio
            </div>

            <div id="empty-email-error" class="alert alert-danger hidden">
                O email é obrigatório
            </div>

            <div id="empty-name-error" class="alert alert-danger hidden">
                O nome é obrigatório
            </div>

			<form role="form" action="result-upload" method="POST"
				enctype="multipart/form-data" onsubmit="return validateForm()">
                    <div class="form-group">
					<label for="exampleInputEmail1">Endereço de Email</label>
					<input id="email-address"
						type="email" class="form-control" id="exampleInputEmail1"
						placeholder="Enter email" name="email">
				</div>
				<div class="form-group">
					<label for="exampleInputName">Nome do Teste</label>
					<input id="name"
						type="text" class="form-control" id="exampleInputName"
						placeholder="Enter name" name="name">
				</div>
				<div class="form-group">
					<label for="exampleInputFile">Arquivo</label>
					<input id="upload-file" type="file"
						name="inputFile" id="exampleInputFile">
					<p class="help-block">Arquivo XML do resultado de testes de
						mutantes</p>
				</div>
				<button id="upload" type="submit" class="btn btn-default">Enviar</button>
			</form>
		</div>

	</div>
	<!-- /.container -->

    <script type="application/javascript">
        function validateForm() {
            var valid = true;

            if (!$('#upload-file').val()) {
                $('#empty-file-error').removeClass("hidden");
                valid = false;
            } else {
                $('#empty-file-error').addClass("hidden");
            }

            if (!$('#email-address').val()) {
                $('#empty-email-error').removeClass("hidden");
                valid = false;
            } else {
                $('#empty-email-error').addClass("hidden");
            }

            if (!$('#name').val()) {
                $('#empty-name-error').removeClass("hidden");
                valid = false;
            } else {
                $('#empty-name-error').addClass("hidden");
            }

            if (valid) {
                $(".loader").fadeIn("fast");
            }

            return valid;
        }
    </script>

</body>

</html>