
<html>
<head>
<title>Spring MVC Tutorial by Crunchify - Hello World Spring MVC
	Example</title>
<style type="text/css">
body {
	background-image: url('https://cdn.crunchify.com/bg.png');
}
</style>
</head>
<body>
	<div id="loginForm" class="col-md-3">
		<div class="panel panel-default">
			<div class="panel-heading">
				<strong class="">Login</strong>

			</div>
			<div class="panel-body">
				<form name='loginForm' modelAttribute="login"
					action="<c:url value='/j_spring_security_check' />" method='POST'>
					<table>
						<tr>
							<div class="form-group" style="margin-bottom: 10px;">
								<td><label for="username" style="margin: 0px 0px 0px 2px;">Username</label>
								</td>
								<td><input type="text" class="form-control" id="username"
									name="username" placeholder="Enter username"
									required="required"></td>
							</div>
						</tr>
						<tr>
							<div class="form-group" style="margin-bottom: 10px;">
								<td><label for="password" style="margin: 0px 0px 0px 2px;">Password</label>
								</td>
								<td><input type="password" class="form-control"
									id="password" name="password" placeholder="Enter password"
									required="required"> <input type="hidden"
									name="${_csrf.parameterName}" value="${_csrf.token}" /></td>
							</div>
						</tr>
					</table>
					<c:if test="${not empty error}">
						<div class="error" style="color: #a94442; text-align: center;">${error}</div>
					</c:if>
					<c:if test="${not empty msg}">
						<div class="msg" style="color: #a94442; text-align: center;">${msg}</div>
					</c:if>

					<div style="padding: 1px; margin-top: 10px;">
						<button type="submit" class="btn btn-primary btn-lg"
							style="width: 100%;">Sign in</button>
					</div>
				</form>
			</div>
		</div>
		<div
			style="border: 3px solid green; background: white; height: 140px;">
			Here will be second area ; Here will be second area; Here will be
			second area to be added ; Here will be second area to be added Here
			will be third area to be added</div>
	</div>
</body>