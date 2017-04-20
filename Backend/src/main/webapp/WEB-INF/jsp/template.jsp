<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<tiles:importAttribute name="javascripts"/>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>SB Admin 2 - Bootstrap Admin Theme</title>
	<!-- Guriddo jqGrid JavaScript 5.1.0 http://www.trirand.com/blog/?p=1484 -->
	<!-- demo http://www.guriddo.net/demo/bootstrap/ -->
    <!-- Bootstrap Core CSS -->
    <link href="${pageContext.request.contextPath}/resource/bower_components/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- MetisMenu CSS -->
    <link href="${pageContext.request.contextPath}/resource/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="${pageContext.request.contextPath}/resource/dist/css/sb-admin-2.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="${pageContext.request.contextPath}/resource/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-default navbar-static-top" role="navigation" style="margin-bottom: 0">
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="${pageContext.request.contextPath}/index">Childhood 後台</a>
            </div>
            <!-- /.navbar-header -->

            <ul class="nav navbar-top-links navbar-right">
                
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li class="divider"></li>
                        <li><a href="logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->

            <div class="navbar-default sidebar" role="navigation">
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">
                        
                        <c:forEach items="${sessionScope.menuList}" var="varView">
                        	<c:forEach items="${varView.value}" var="varMenu" varStatus="loop">
							     	<c:if test="${varMenu.value.type==0}">
							     		
							     		<c:if test="${fn:length(varView.value) == 1}">
							     			<li>
							     				<a href="${pageContext.request.contextPath}/${varMenu.value.viewUrl}"><i class="${varMenu.value.viewIcon}"></i> ${varMenu.value.pageName}</a>		
							     			</li>					     		
							    		</c:if>
							    		<c:if test="${fn:length(varView.value) > 1}">
							    			<li>
							    			<a href="#"><i class="fa fa-wrench fa-fw"></i> ${varMenu.value.pageName}<span class="fa arrow"></span></a>
                            				<ul class="nav nav-second-level">
                            				<c:forEach items="${varView.value}" var="varMenu2" varStatus="loop">
                            					<c:if test="${varMenu2.value.type!=0}">
										     		<li>
							                        	<!-- <a href="panels-wells.html">Panels and Wells</a> -->
							                        	<a href="${pageContext.request.contextPath}/${varMenu2.value.viewUrl}"><i class="${varMenu2.value.viewIcon}"></i> ${varMenu2.value.pageName}</a>	
							                        </li>							                       					     		
										    	</c:if>
                            				</c:forEach>
                            				</ul>
                            				</li>
							    		</c:if>							    		
							    	</c:if>
                        	</c:forEach>
						</c:forEach>
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

        <!-- Page Content -->

        <tiles:insertAttribute name="body" />
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="${pageContext.request.contextPath}/resource/bower_components/jquery/dist/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="${pageContext.request.contextPath}/resource/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>

    <!-- Metis Menu Plugin JavaScript -->
    <script src="${pageContext.request.contextPath}/resource/bower_components/metisMenu/dist/metisMenu.min.js"></script>

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
</body>

</html>
