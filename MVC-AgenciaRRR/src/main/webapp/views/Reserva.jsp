<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="jstl"%>
<!doctype html>
<html lang="pt-BR">
<head>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<!-- Framework Bootstrap -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9"
	crossorigin="anonymous">
<!-- Biblioteca JavaScript -->
<script	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm"
	crossorigin="anonymous"></script>
<!-- JS externo-->
<script src="./js/scripts.js"></script>
<!-- CSS Externo -->
<link rel="stylesheet" href="./css/style.css">
<!-- Fivecon -->
<link rel="shortcut icon" href="../img/logo-age.png" type="image/x-icon" />
<title>Agencia R.R.R | Cadastro Reserva</title>
</head>
<body>
	<main>
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
		<!-- inicio-->
		<div class="container bd-navbar">
			<div class="row justify-content-center bd-navbar">
				<div class="card">
					<div class="card-header">
						<h5 class="text-center">Reserva Cadastradas</h5>
					</div>					
					<form action="./inserir-reserva" class="form-control bd-navbar">
							<div class="form-group mb-3">
								<label for="cliente" class="form-label"> Cliente </label> 
									<select	id="cliente" name="cliente" class="form-control">
										<option value="DEFAULT">Escolha o cliente</option>
										<jstl:forEach items="${listaClientes}" var="c">
											<option value="${c.idCliente}">${c.nomeCliente}</option>
										</jstl:forEach>
									</select>
							</div>
							<div class="form-group mb-3">
								<label for="destino" class="form-label"> Destino </label> 
								<select id="destino" name="destino" class="form-control">
									<option value="DEFAULT">Escolha o Destino</option>
										<jstl:forEach items="${listaDestinos}" var="d">
											<option value="${d.idDestino}">${d.nomeDestino}</option>
										</jstl:forEach>
								</select>
							</div>
							<div class="mb-3">
								<label for="quantReservada" class="form-label">Quantidade Reservada</label> 
								<input type="text" class="form-control" id="quantReservada" name="quantReservada" required>
							</div>
							<div class="mb-3">
								<label for="precoTotal" class="form-label">Preço Total</label>
									<input type="text" class="form-control" id="tel" name="precoTotal" required>
							</div>
							<!-- radio input pagamento -->
							<div class="mb-3">
								<h3 class="card-title">Detalhes do Pagamento:</h3>
								<div class="col d-flex justify-content-center">
									<!-- Pix -->
									<div class="form-check">
										<input class="form-check-input" type="radio" id="pagamento"
										name="pagamento" value="Pix" style="margin-left: 10px;"> 
										<label class="form-check-label" for="pix" style="margin-left: 10px;"> Pix </label>
									</div>
										<!-- cartao -->
									<div class="form-check">
										<input class="form-check-input" type="radio" id="pagamento"
											name="pagamento" value="Cartão" style="margin-left: 10px;"> 
										<label class="form-check-label" for="cartao" style="margin-left: 10px;"> Cartão</label>
									</div>
								</div>
							</div>
							<!-- radio input statusPedido -->
							<div class="mb-3">
								<div class="col d-flex justify-content-center">
									<!-- disponivel -->
									<div class="form-check">
										<input class="form-check-input" type="radio" id="apro" name="statusPedido" value="Aprovado"
										style="margin-left: 10px;"> 
										<label class="form-check-label" for="Direto" style="margin-left: 10px;"> Aprovado </label>
									</div>
									<!-- indisponivel -->
									<div class="form-check">
										<input class="form-check-input" type="radio" id="repro" name="statusPedido" value="Reprovado"
										style="margin-left: 10px;"> 
										<label class="form-check-label" for="escala" style="margin-left: 10px;"> Reprovado </label>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!-- Botões de fim reserva -->
					<div class="nav-item col-12 col-lg-auto d-grid gap-2 h3 mb-3 fw-normal bd-navbar">
						<a role="button" href="./html/login.html">
							<button class="w-100 btn btn-lg btn-primary" type="submit"
								onclick="exibirAlertaReserva()">Concluir Reserva...</button>
						</a>
					</div>
				</form>				
				<!-- RODAPÉ -->
				<div class="container-fluid">
					<footer class="py-6 my-4">
						<ul class="nav justify-content-center border-bottom navbar navbar-expand-lg">
							<li class="nav-item"><a href="./index.html"
								class="nav-link px-2 text-body-color">Inicio</a></li>
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
		</div>
	</main>
</body>

</html>