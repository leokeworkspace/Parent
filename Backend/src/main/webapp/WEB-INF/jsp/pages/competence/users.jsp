<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en" id="ci18n">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
	<!-- Timeline CSS -->
     <!-- The jQuery library is a prerequisite for all jqSuite products -->
     <!-- jQuery -->
	<script type="text/ecmascript" src="${pageContext.request.contextPath}/resource/bower_components/jquery/dist/jquery.min.js"></script> 
	<script src="${pageContext.request.contextPath}/resource/bower_components/jquery/dist/jquery.min.js"></script>
    <!-- We support more than 40 localizations -->
    <script src="${pageContext.request.contextPath}/resource/bower_components/jqGrid/js/i18n/grid.locale-tw.js"></script>
    <!-- This is the Javascript file of jqGrid -->   
    <script type="text/ecmascript" src="${pageContext.request.contextPath}/resource/bower_components/jqGrid/js/jquery.jqGrid.min.js"></script>
    <!-- This is the localization file of the grid controlling messages, labels, etc.
    <!-- A link to a jQuery UI ThemeRoller theme, more than 22 built-in and many more custom -->
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resource/bower_components/jqGrid/css/bootstrap.min.css"> 
    <!-- The link to the CSS that the grid needs -->
    <link rel="stylesheet" type="text/css" media="screen" href="${pageContext.request.contextPath}/resource/bower_components/jqGrid/css/ui.jqgrid-bootstrap.css" />
	<script>
		$.jgrid.defaults.width = 780;
	</script>

    <title data-i18n="title.title">Childhood</title>


</head>

<body>

    <div id="page-wrapper">
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header" data-i18n="title.title"></h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div style="margin-left:20px">
			    <table id="jqGrid"></table>
			    <div id="jqGridPager"></div>
			</div>
            <!-- /.row -->
            
        </div>
        <!-- /#page-wrapper -->

</body>


<!-- jqGrid setup -->
<script>
var mydata = [
              {id:"1",invdate:"2010-05-24",name:"test",note:"note",tax:"10.00",total:"2111.00"} ,
              {id:"2",invdate:"2010-05-25",name:"test2",note:"note2",tax:"20.00",total:"320.00"},
              {id:"3",invdate:"2007-09-01",name:"test3",note:"note3",tax:"30.00",total:"430.00"},
              {id:"4",invdate:"2007-10-04",name:"test",note:"note",tax:"10.00",total:"210.00"},
              {id:"5",invdate:"2007-10-05",name:"test2",note:"note2",tax:"20.00",total:"320.00"},
              {id:"6",invdate:"2007-09-06",name:"test3",note:"note3",tax:"30.00",total:"430.00"},
              {id:"7",invdate:"2007-10-04",name:"test",note:"note",tax:"10.00",total:"210.00"},
              {id:"8",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"21.00",total:"320.00"},
              {id:"9",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
              {id:"11",invdate:"2007-10-01",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
              {id:"12",invdate:"2007-10-02",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
              {id:"13",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
              {id:"14",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
              {id:"15",invdate:"2007-10-05",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
              {id:"16",invdate:"2007-09-06",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
              {id:"17",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
              {id:"18",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
              {id:"19",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
              {id:"21",invdate:"2007-10-01",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
              {id:"22",invdate:"2007-10-02",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
              {id:"23",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
              {id:"24",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
              {id:"25",invdate:"2007-10-05",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
              {id:"26",invdate:"2007-09-06",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"},
              {id:"27",invdate:"2007-10-04",name:"test",note:"note",amount:"200.00",tax:"10.00",total:"210.00"},
              {id:"28",invdate:"2007-10-03",name:"test2",note:"note2",amount:"300.00",tax:"20.00",total:"320.00"},
              {id:"29",invdate:"2007-09-01",name:"test3",note:"note3",amount:"400.00",tax:"30.00",total:"430.00"}
          ];
$("#jqGrid").jqGrid({
	data: mydata,
    datatype: "local",
	styleUI : 'Bootstrap',
	height: 400,
	rowNum: 10,
	rowList: [10,20,30],
    colNames:['Inv No','Date', 'Client', 'Amount','Tax','Total','Notes'],
    colModel:[
        {name:'id',index:'id', editable: true, width:60, sorttype:"int",search:true},
        {name:'invdate',index:'invdate', editable: true, width:90, sorttype:"date", formatter:"date"},
        {name:'name',index:'name', editable: true, width:100},
        {name:'amount',index:'amount', editable: true, width:80, align:"right",sorttype:"float", formatter:"number"},
        {name:'tax',index:'tax', editable: true, width:80, align:"right",sorttype:"float"},
        {name:'total',index:'total', editable: true, width:80,align:"right",sorttype:"float"},
        {name:'note',index:'note', editable: true, width:100, sortable:false}
    ],
	viewrecords: true,
	pager: "#jqGridPager",
    viewrecords: true,
    add: true,
    edit: true,
    addtext: 'Add',
    edittext: 'Edit',
    caption: "Data",
    hidegrid:false
});



//Setup buttons
jQuery("#jqGrid").jqGrid('navGrid','#jqGridPager',
	    {edit:true,add:true,del:true,search:true},
	    {height:400,reloadAfterSubmit:true}
);

$("#jqGrid").jqGrid('setGridWidth', $("#content").width(), true);



    </script>
    

	
</html>
