<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />
<!-- Framework Bootstrap -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<!-- Biblioteca JavaScript -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<!-- JS externo-->
<script src="./js/scripts.js"></script>
<!-- CSS Externo -->
<link rel="stylesheet" href="./css/style.css">
<!-- Fivecon -->
<link rel="shortcut icon" href="../img/logo-age.png" type="image/x-icon" />
<title>Alteração do Reserva ${reserva.idReserva}</title>
</head>
<body class="container-fluid bd-navbar">
	<main class="bd-navbar">
		<!-- Navbar -->
		<header class="container-fluid navbar navbar-expand-lg bd-navbar">
			<nav class="container-xxl bd-gutter flex-wrap flex-lg-nowrap">
				<!-- Logo navbar -->
				<a class="navbar-brand mx-auto" href="index.html"> <img
					class="d-block d-none d-lg-flex" id="navbarLogo"
					src="./img/logo-age.png" alt="agencia">
				</a>
				<!-- Botão mobile -->
				<div class="d-flex">
					<button class="navbar-toggler border-0 d-lg-none order-3"
						type="button" data-bs-toggle="offcanvas"
						data-bs-target="#bdNavbar" aria-controls="bdNavbar"
						aria-label="Toggle navigation">
						<img id="togglerLogo" src="./img/logo-age.png" fill="currentColor">
					</button>
				</div>
				<!-- Menu mobile -->
				<div class="offcanvas-lg offcanvas-end flex-grow-1" tabindex="-1"
					id="bdNavbar" aria-labelledby="bdNavbarOffcanvasLabel"
					data-bs-scroll="true" aria-modal="true">
					<!-- Cabeçalho do menu -->
					<div class="offcanvas-header px-4 pb-0">
						<h5 class="offcanvas-title text-white" id="bdNavbarOffcanvasLabel"></h5>
						<button class="btn-close btn-close-white" type="button"
							data-bs-dismiss="offcanvas" aria-label="Close"
							data-bs-target="#bdNavbar"></button>
					</div>
					<!-- Opções do menu -->
					<div class="offcanvas-body p-5 pt-0 p-lg-0">
						<hr class="d-lg-none text-white-50">
						<!-- Primeira parte da navbar -->
						<ul class="navbar-nav flex-row flex-wrap bd-navbar-nav ms-md-auto">
							<!-- Home -->
							<li class="nav-item col-6 col-lg-auto"><a class="nav-link"
								aria-current="true" href="./index.html"
								style="padding-right: 15px;"> <img src="./img/home.png"
									width="30px">Home
							</a></li>
							<!-- Destinos -->
							<li class="nav-item col-6 col-lg-auto"><a class="nav-link"
								href="./html/destino.html" style="padding-right: 15px;"> <img
									src="./img/destino.png" width="30px">Destinos
							</a></li>
							<!-- Cadastro Destino-->
							<li class="nav-item col-6 col-lg-auto"><a class="nav-link"
								href="./html/cadastroDestino.html" style="padding-right: 15px;">
									<img src="./img/cadastro-destino.png" width="30px">Cadastro
									Destino
							</a></li>
							<!-- Promoção -->
							<li class="nav-item col-6 col-lg-auto"><a class="nav-link"
								href="./html/promocao.html" style="padding-right: 15px;"> <img
									src="./img/promocao.png" width="30px">Promoções<a></li>
							<!-- Cadastro -->
							<li class="nav-item col-6 col-lg-auto"><a class="nav-link"
								href="./html/cadastre.html" style="padding-right: 15px;"> <img
									src="./img/usuario.png" width="30px">Cadastro
							</a></li>
						</ul>
						<hr class="d-lg-none text-white-50">
						<!-- Segunda parte da navbar -->
						<ul class="navbar-nav flex-row flex-wrap ms-md-auto">
							<li class="nav-item col-6 col-lg-auto">
								<!-- instagran --> <a class="nav-link"
								href="https://www.instagram.com/" target="_blank" rel="noopener">
									<img src="./img/insta.png" width="40px" height="40">
							</a>
							</li>
							<li class="nav-item col-6 col-lg-auto">
								<!-- Linkedin --> <a class="nav-link"
								href="https://www.linkedin.com/in/squad037/" target="_blank"
								rel="noopener"> <img src="./img/linkedi.png" width="40px"
									height="40">
							</a>
							</li>
							<li class="nav-item py-2 py-lg-1 col-12 col-lg-auto">
								<div class="vr d-none d-lg-flex h-100 mx-lg-2 text-white"></div>
								<hr class="d-lg-none my-2 text-white-50">
							</li>
							<div class="nav-item col-12 col-lg-auto">
								<!-- Botões de Login -->
								<a class="btn btn-primary" role="button"
									href="./views/login.jsp">Entrar</a>
							</div>
						</ul>
					</div>
				</div>
			</nav>
		</header>
		<!-- CORPO -->
	<div class="container">
		<h3>Alteração do Reserva ${reserva.idReserva} </h3>		
		<form action="./atualizar-reserva" class="form-control bd-navbar">
			<input type="hidden" name="idReserva" value="${reserva.idReserva}">
			<p>Forma de pagamento:</p>
			<p>
				<input type="text"  name="pagamento" value="${reserva.pagamento}">
			</p>
			<p>Quantidade Reservada:</p>
			<p>
				<input type="text"  name="quantReservada" value="${reserva.quantReservada}">
			</p>
			<p>Preço Total:</p>
			<p>
				<input type="text" name="precoTotal" value="${reserva.precoTotal}">
			</p>
			<p>Status Pedido:</p>
			<p>
				<input type="text"  name="statusPedido" value="${reserva.statusPedido}">
			</p>
			<button type="submit" class="btn btn-success">Atualizar</button>
		</form>
	</div>
	<!-- RODAPÉ -->
		<div class="container-fluid">
			<footer class="py-6 my-4">
				<ul class="nav justify-content-center border-bottom navbar navbar-expand-lg">
					<li class="nav-item">
					<a href="./index.html" class="nav-link px-2 text-body-color">Inicio</a>
					</li>
							<li class="nav-item"><a class="nav-link active"
								href="./html/loja.html" target="_blank"
								style="padding-left: 50px; padding-right: 50px;"> <img
									src="./img/loja.png" width="30px"> Encontre uma loja
							</a></li>
							<li class="nav-item"><span class="nav-link active"
								style="padding-left: 50px; padding-right: 50px;"> <img
									src="./img/tel.png" width="30px"> Central de atendimento:
									(xx) xxxxx-xxxx | Televendas:(xx) xxxx-xxxx
							</span></li>
							<li class="nav-item"><a class="nav-link active"
								href="./html/ajuda.html" style="padding-left: 50px;"> <img
									src="./img/ajuda.png" width="30px"> Precisa de ajuda?
							</a></li>
						</ul>
						<p class="text-center">© Copyright 2023 Todos os direitos
							reservados, Agencia R.R.R</p>
						<p>
							<a href="#" id="float-end">Voltar ao início</a>
						</p>
					</footer>
				</div>
</main>
</body>

</html>