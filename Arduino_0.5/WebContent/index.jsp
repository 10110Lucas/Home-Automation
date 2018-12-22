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
								<a href="/Arduino_0.5/Relatorio.do?acao=Listar">Relatório</a>
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
			</header>
		</article>
	
		<a href="#"> <img class="img-principal" src="imagens/img-02.jpg">
		</a>
	
		<div class="container">
	
			<div class="principal-01">
				<div class="row">
	
					<div class="col-md-6">
						<h1 id="h1titulo">Automação residencial</h1>
						<p>
							Hoje o conceito de Automação Residencial está mudado. Conforto,
							segurança, praticidade, lazer, tranquilidade e economia.<br />
							<br /> Estes são alguns benefícios que a automação residencial
							inteligente traz para auxiliar você e sua família.<br />
							<br /> *Com a tecnologia atual não é necessário obras ou reformas
							para implantar a automação residencial.<br />
							<br />
						</p>
					</div>
					<div class="col-md-6">
						<h1>Serviços</h1>
						<ul class="ulServicos">
							<li>Automação de Iluminação</li>
							<li>Automação de Ar Condicionado</li>
							<li>Automação de Cortina</li>
							<li>Automação de Irrigação</li>
							<li>Projeto de Automação</li>
							<li>Som Ambiente</li>
							<li>Home Theater / Sala de Cinema</li>
							<li>Câmeras de Segurança</li>
							<li>Infraestrutura de Wi-Fi</li>
							<li>Casa Inteligente</li>
						</ul>
					</div>
	
				</div>
			</div>
	
		</div>
		<img id="img-principal2" src="imagens/img-07.jpg">
		<div class="container">
	
			<div class="row">
				<div class="col-md-3 principal-02">
					<p>
						A empresa realizou um trabalho em nosso espaço em março. Empresa
						organizada, limpa, tem um ótimo valor e um atendimento nota 10.<br />
					</p>
					<h3>Lucas Do Vale</h3>
				</div>
				<div class="col-md-3 principal-03">
					<p>
						Tive um ótimo atendimento pré e pós compra. Estou muito satisfeito
						com o projeto realizado em minha casa.<br />
						<br />
					</p>
					<h3>Natália Moura</h3>
				</div>
				<div class="col-md-3 principal-04">
					<p>
						Criatividade na habilidade de encontrar soluções para obstáculos, 
						tanto que consigo gerenciar melhor meus gastos com energia.<br />
					</p>
					<h3>Lucas De Souza</h3>
				</div>
			</div>
			
			<div class="row">
				<div class="col-md-3 principal-05">
					<p>
						Atendimento diferenciado o qual mudou meu conceito em relação a
						automação residencial.<br />
					</p>
					<h3>Gustavo Vicente</h3>
				</div>
				<div class="col-md-3 principal-06">
					<p>
						Tecnologia de última geração via Wi-Fi ao nosso alcance por um
						preço totalmente acessível. <br />
					</p>
					<h3>Luiz Henrique</h3>
				</div>
				<div class="col-md-3 principal-07">
					<p>
						Trazem a tecnologia de automação aliada ao bom atendimento e
						execução.<br />
					</p>
					<h3 id="gr">Gustavo Rod.</h3>
				</div>
			</div>
	
			<div class="principal-08">
				<div class="row">
					<div class="col-md-3 ">
						<img class="imagens" src="imagens/img-03.jpg">
					</div>
					<div class="col-md-3 imagens">
						<img class="imagens" src="imagens/img-04.jpg">
					</div>
					<div class="col-md-3 imagens">
						<img class="imagens" src="imagens/img-05.jpg">
					</div>
					<div class="col-md-3 imagens">
						<img class="imagens" src="imagens/img-06.jpg">
					</div>
				</div>
			</div>
	
			<div class="principal-09">
				<div class="row">
					<div class="col-md-6">
						<h1>Automação comercial</h1>
						<p>
							Os benefícios da Automação Comercial adequado a empresas, estão
							além da redução de custos, com projetos de design único, garantia
							de funcionalidade, suporte técnico, maior eficiência energética,
							segurança e praticidade. <br />
							<br /> *Com a tecnologia atual não é necessário obras ou reformas
							para implantar a automação comercial.
						</p>
					</div>
					<div class="col-md-6">
						<h1>Serviços</h1>
						<ul class="ulServicos">
							<li>Automação de Sala de Reunião</li>
							<li>Automação de Ar Condicionado</li>
							<li>Automação de Iluminação</li>
							<li>Projetos de Automação</li>
							<li>Controle de Acesso</li>
							<li>Sistemas de Projeção</li>
							<li>Som Ambiente</li>
							<li>Câmeras de Segurança</li>
							<li>Infraestrutura de Wi-Fi</li>
							<li>Monitoramento Remoto</li>
						</ul>
					</div>
				</div>
			</div>
	
			<div class="principal-10">
				<div class="row">
					<div class="col-md-12">
						<h1>Automação residencial</h1>
						<p>magine controlar o ar condicionado, a televisão, as luzes, a
							cortina ou mesmo a irrigação do jardim com alguns cliques no
							smartphone ou iPad. Além de agilizar o dia a dia, proporcionam
							economia de energia, sofisticação e valorização a qualquer projeto
							arquitetônico.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>Segurança residencial</h1>
						<p>Acesse as câmeras da casa no celular, tablet ou notebook,
							onde poderá observar cada área externa da residência. Também
							fornecemos monitoramento 24h, portanto proteger o seu patrimônio
							ficou igualmente fácil e prático.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>Automação comercial</h1>
						<p>Toda ação de um funcionário dentro de uma empresa impacta,
							diretamente, nos custos operacionais do negócio. Além disso,
							quando recebemos nossos clientes em um espaço tecnologicamente
							moderno e inteligente, nossa imagem é ainda mais impactante.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>Segurança para empresa</h1>
						<p>Acesse as câmeras da empresa no celular, tablet ou notebook,
							onde poderá observar cada área da empresa. Também fornecemos
							monitoramento 24h, portanto proteger o seu patrimônio ficou ainda
							mais fácil e prático.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>O que é automação residencial?</h1>
						<p>Automação residencial é o uso da tecnologia com o objetivo
							de simplificar e tornar automáticas algumas tarefas habituais onde
							em uma casa convencional ficaria a cargo de seus moradores.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>Acesso com iphone</h1>
						<p>Com a Automação Residencial, você pode simplesmente
							controlar tudo em casa, ambiente por ambiente, utilizando o
							aplicativo com qualquer dispositivo móvel, em qualquer lugar.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12"></div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>Automação de iluminação</h1>
						<p>Tenha em mãos o controle sobre a iluminação de qualquer
							ambiente com seu iPhone. A automação de Iluminação inteligente,
							pode reduzir em até 30% o consumo de energia em uma casa.</p>
					</div>
				</div>
	
			</div>
	
			<div class="principal-11">
				<div class="row">
					<div class="col-md-12">
						<h1>Cenário inteligente</h1>
						<p>Nossos sistemas são bem intuitivos e práticos. Criando um
							cenário inteligente para cada ambiente, garantindo o máximo de
							conforto e bem-estar. Possuímos soluções para integração em
							qualquer momento da obra ou até mesmo para casas prontas,
							escolhendo a solução exata para a necessidade do projeto.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>Casa inteligente</h1>
						<p>Casa inteligente é um espaço residencial ou de escritórios
							onde encontramos soluções integradas baseadas nas tecnologias de
							informação, de modo a oferecer uma infraestrutura avançada que
							permita a quem nela habita usufruir de uma vasta gama de
							aplicações e serviços.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1></h1>
						<p></p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>Controle automático</h1>
						<p>A Casa Inteligente controla automaticamente a temperatura,
							liga a iluminação, toca música, abre ou fecha portas e janelas,
							dispara alarmes e envia mensagens ao morador se alguém aparecer,
							tudo isso apenas usando o Smartphone, um Tablet, Ipad ou o próprio
							computador como controle remoto.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>Automação residencial brasil</h1>
						<p>Deixamos sua casa ou empresa inteligente. Automação em todos
							os ambientes com o melhor custo-benefício do mercado. Solicite seu
							orçamento.</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>A internet das coisas</h1>
						<p>
							"É um termo popular onde abrange todo e qualquer objeto com algum
							processamento eletrônico, os chamados “objetos inteligentes”.<br />
							Já são muitos os objetos conectados, tais como geladeiras, forno
							de microondas, home theater, óculos, carros e elevadores. <br />
							Com a constatação cada vez maior da usabilidade desta rede,
							grandes empresas vem tomando a iniciativa para unificar a internet
							das coisas.
						</p>
					</div>
				</div>
				<div class="row">
					<div class="col-md-12">
						<h1>Benefícios</h1>
						<p>
							A casa do futuro deverá ser cada mais responsiva e flexível. Entre
							os inúmeros benefícios, estão também a comodidade, a
							interatividade e a economia de custos e de energia. <br /> As
							aplicações em cada uma dessas áreas estão progressivamente
							diversificadas, apresentando sistemas de automação crescentemente
							abrangentes. <br /> Um dos setores que mais se desenvolve é o da
							segurança, apresentando alarmes sofisticados, sistemas de
							monitoramento por controle à distância, circuitos fechados de tv e
							controles de acesso e o controle da iluminação.
						</p>
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