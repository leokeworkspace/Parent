<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="zh-TW" id="ci18n">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Childhood Login</title>

    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resource/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resource/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Timeline CSS -->
    <link href="${pageContext.request.contextPath}/resource/dist/css/timeline.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resource/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="${pageContext.request.contextPath}/resource/bower_components/morrisjs/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resource/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<div class="layout-container">
	<!-- Body Page -->
	<tiles:insertAttribute name="body" />
</div>
<!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resource/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resource/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resource/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${pageContext.request.contextPath}/resource/bower_components/raphael/raphael-min.js"></script>
    <script src="${pageContext.request.contextPath}/resource/bower_components/morrisjs/morris.min.js"></script>
    <script src="${pageContext.request.contextPath}/resource/js/morris-data.js"></script>

    <!-- Custom Theme JavaScript -->
    <script src="${pageContext.request.contextPath}/resource/dist/js/sb-admin-2.js"></script>
    
    <!-- i18next -->
    <script src="${pageContext.request.contextPath}/resource/bower_components/i18next-xhr-backend/i18nextXHRBackend.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/i18next/2.0.22/i18next.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-i18next/0.0.14/i18next-jquery.min.js" ></script>
	<script>
      var lang = navigator.languages ? navigator.languages[0] : (navigator.language || navigator.userLanguage);
   		lang = lang.split("-")[0];
   		console.log("lang:"+lang);
      i18next.use(i18nextXHRBackend).init({
        lng: lang,
        fallbackLng: 'en',
        backend : {
            loadPath: '${pageContext.request.contextPath}/locales/{{lng}}/translation.json'
        }
      }, function(err, t) {
        i18nextJquery.init(i18next, $);
        $('#ci18n').localize();
      });
    </script>
</html>