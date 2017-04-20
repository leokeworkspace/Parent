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

$("#jqGrid").jqGrid({
	url:'${pageContext.request.contextPath}/competence/actionQuery',
	editurl:'${pageContext.request.contextPath}/competence/actionEdit',
    datatype: "JSON",
    mtype: "POST",
	styleUI : 'Bootstrap',
	height: 400,
	rowNum: 2,
	rowList: [2,5,10],
    colNames:['功能編號','功能名稱', '順序','功能類型','圖示','連結位置', '開啟'],
    colModel:[
        {name:'pageId',index:'page_id', editable: false, width:60, sorttype:"int"},
        {name:'pageName',index:'page_name', editable: true, width:90 },
        {name:'sort',index:'sort', editable: true, width:80, align:"right",sorttype:"int"},
        {name:'type',index:'type', editable: true, width:80,  
        	formatter:formatterStatus,  
        	editable: true,
            edittype: 'select',
            //formatter: 'select',
            editoptions: { dataUrl: "/competence/actionEdit" }, },
        {name:'viewIcon',index:'view_icon', editable: true, width:90 },
        {name:'viewUrl',index:'view_url', editable: true, width:180 },
        {name:'pageSwitch',index:'page_switch', editable: true, width:40}
    ],
	viewrecords: true,
	pager: "#jqGridPager",
    viewrecords: true,
    add: true,
    edit: true,
    addtext: 'Add',
    edittext: 'Edit',
    caption: "功能列表",
    hidegrid:false,
    ajaxGridOptions: { contentType: 'application/json; charset=utf-8' },
    serializeGridData: function (postData) {
    	console.log(" postData "+postData);
    	//參數新增JSON格式
        return JSON.stringify(postData);
    },
    loadComplete: function(data) {//取得額外傳送的value
    	//var nowUsrgrp = data.nowUsrgrp;
    	//console.log("out:"+data.nowUsrgrp);
    	//var ids = jQuery("#grid").jqGrid("getDataIDs");
		    	
    }

});



//Setup buttons
jQuery("#jqGrid").jqGrid('navGrid','#jqGridPager',
	    {edit:true,add:true,del:true,search:true},
	    {edit : {
			addCaption: "Add Record",
			editCaption: "Edit Record",
			bSubmit: "Submit",
			bCancel: "Cancel",
			bClose: "Close",
			saveData: "Data has been changed! Save changes?",
			bYes : "Yes",
			bNo : "No",
			bExit : "Cancel"}},
	    {height:400,reloadAfterSubmit:true}
);

$("#jqGrid").jqGrid('setGridWidth', $("#content").width(), true);

//變更顯示文字部分
function formatterStatus(cellvalue){
	//發票狀態(0：未上傳； 1：已上傳； 2：作廢； 3：作廢已上傳)
	var valueStatus ="";
	switch(cellvalue){
		case 0:
			valueStatus ="目錄";
			break;
		default:
			valueStatus ="功能";
			break;
	}
  return valueStatus;
}


    </script>
    

	
</html>
