
<html>
<head>
<title>Spring MVC Tutorial by Crunchify - Hello World Spring MVC
	Example</title>
</head>
<body>
	<div id="loginForm" class="col-md-3">

		<div class="panel-body">
			<form name='loginForm' modelAttribute="login" action="login"
				method='POST'>


				<div class="form-group" style="margin-bottom: 10px;">
					<label for="username" style="margin: 0px 0px 0px 2px;">Username</label>

					<input type="text" class="form-control" id="username"
						name="username" placeholder="Enter username" required="required">
				</div>
				<div class="form-group" style="margin-bottom: 10px;">
					<label for="password" style="margin: 0px 0px 0px 2px;">Password</label>

					<input type="password" class="form-control" id="password"
						name="password" placeholder="Enter password" required="required">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
						<br><br>
                    <input type="checkbox" name="remember-me" />Remember Me

				</div>

				<div style="padding: 1px; margin-top: 10px;">
					<button type="submit" class="btn btn-primary btn-lg"
						style="width: 100%;">Sign in</button>
				</div>
			</form>
		</div>
	</div>
</body>