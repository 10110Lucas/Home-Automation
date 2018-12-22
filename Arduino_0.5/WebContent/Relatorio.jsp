<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="pt-br">
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <link rel="shortcut icon" href="imagens/favicon.png" type="image/x-icon">
	<title>Projeto Integrado</title>
	
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
		integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
		crossorigin="anonymous">
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
		integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
		integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
		crossorigin="anonymous"></script>
	
	<!-- Bootstrap -->
	<link href="Bootstrap/css/bootstrap.min.css" rel="stylesheet">
	<link href="estilo.css" rel="stylesheet">
	
	<link href="style.css" rel="stylesheet">
	
	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
	<!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

	<article>
		<header>
			<form action="Relatorio.do" method="get">
				<div class="cabecalho">
					<div class="container">
						<div id="cabecalhoPt2" class="row">
							<div class="col-md-2">
								<a href="index.jsp">
									<img src="imagens/automacao-residencial.jpg">
								</a>
							</div>
							<div id="cabecalhoPt3" class="col-md-3"> </div>
              				<div id="cabecalhoPt4" class="col-md-4">
								<a href="index.jsp">Início</a>
								<a href="Portifolio.html">Portfólio</a>
								<a href="#">Serviços</a>
								<a href="/Arduino_0.4/Relatorio.do?acao=Listar">Relatório</a>
								<!-- <button type="submit" name="acao" value="Listar">Relatório</button> -->
							</div>
							<div id="foneCabecalho" class="col-md-2">
								<p class="contato">
									<img src="imagens/img-01.png"> (11) 99592-8763
								</p>
							</div>
						</div>
					</div>
				</div>
			</form>
		</header>
	</article>

	<div class="container">
		<div class="row">

			<div class="col-md-12">
				<div class="realatorio">

					<table class="table table-hover">
						<thead>
							<tr class="cabecalhoTabela">
								<th id="tb2" scope="col">iD</th>
								<th id="tb3" scope="col">Dia</th>
								<th id="tb4" scope="col">Luminosidade média</th>
								<th id="tb5" scope="col">Potencia (W)</th>
								<th id="tb6" scope="col">Tempo (m/s)</th>
							</tr>
						</thead>
						<c:forEach var="conteudo" items="${ conteudo }">
							<tbody>
								<tr>
									<th id="tb02" scope="row">${ conteudo.id }</th>
									<th id="tb03">${ conteudo.data }</th>
									<th id="tb04">${ conteudo.luminosidade }</th>
									<th id="tb05">${ conteudo.potencia }</th>
									<th id="tb06">${ conteudo.tempoDeUso }</th>
								</tr>
							</tbody>
						</c:forEach>
					</table>

				</div>
			</div>

		</div>
	</div>


	<article class="articleRodape">
		<footer>
			<div class="rodape">

				<div class="row">
					<div class="col-md-3">
						<img src="imagens/automacao-residencial.jpg">
					</div>
					<div class="col-md-2">
						<p class="pRodape">COMPANY</p>
						<ul class="ulRodape">
							<li>Sobre</li>
							<li>Empregos</li>
							<li>Nofivdades</li>
						</ul>
					</div>
					<div class="col-md-2">
						<p class="pRodape">COMUNIDADES</p>
						<ul class="ulRodape">
							<li>Desenvolvedores</li>
							<li>Marcas</li>
							<li>Parceiros</li>
						</ul>
					</div>
					<div class="col-md-2">
						<p class="pRodape">LINKS UTEIS</p>
						<ul class="ulRodape">
							<li>Ajuda</li>
							<li>Player da Web</li>
						</ul>
					</div>
					<div class="col-md-3">
						<img src="imagens/img-07.png"> <img
							src="imagens/img-08.png"> <img src="imagens/img-09.png">
						<img src="imagens/img-10.png"> <img
							src="imagens/img-11.png">
					</div>
				</div>

			</div>
		</footer>
	</article>


</body>
</html>