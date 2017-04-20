<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="zh-TW" id="ci18n">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Childhood Login</title>
</head>

<body>

    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading" >
                        
                        <img src="resource/img/logo.png" alt="Mountain View" style="display:block; margin:auto;width:75%;">

                    </div>
                    <div class="panel-body">
                        <form role="form" id="loginfrom" action="loginUser" method="post">
                            <fieldset>
                                <div class="form-group">
                                	<h3 class="panel-title"  data-i18n="login.account">帳號:</h3><br/>
                                    	<input class="form-control" name="account" type="text" >
                                </div>
                                <div class="form-group">
                                	<h4 class="panel-title"  data-i18n="login.pw">密碼:</h4><br/>
                                    	<input class="form-control" name="password" type="password" value="">
                                </div>
                            	<button class="btn btn-lg btn-success btn-block" type="submit" data-i18n="login.login"></button>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    

</body>
   
	
</html>
