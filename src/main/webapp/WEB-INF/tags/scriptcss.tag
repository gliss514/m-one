<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<head>
<title><spring:message code="caption.main" text="caption.main" /></title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="IE=edge">

<!-- mimity -->
<link href="themes/mimity/css/bootstrap.css" rel="stylesheet" type="text/css" />
<link href="themes/mimity/css/font-awesome.min.css" rel="stylesheet" type="text/css" />
<link href="themes/mimity/css/style.css" rel="stylesheet" type="text/css" />

<link href="projg/css/datepicker.css" rel="stylesheet">
<link href="projg/css/duallistbox.css" rel="stylesheet">
<link href="projg/css/slider.css" rel="stylesheet">
<link href="projg/css/switch.css" rel="stylesheet">
<link href="projg/css/image-picker.css" rel="stylesheet">
<link href="projg/css/projg.css" rel="stylesheet">

</head>

<jsp:doBody />

<script src="themes/mimity/js/jquery.js"></script>
<script src="projg/js/jquery.form.js"></script>
<script src="projg/js/projg.js" type="text/javascript"></script>
<script src="projg/js/fileinput.js" type="text/javascript"></script>
<script src="projg/js/datepicker.js" type="text/javascript"></script>
<script src="projg/js/duallistbox.js" type="text/javascript"></script>
<script src="projg/js/touchspin.js" type="text/javascript"></script>
<script src="projg/js/switch.js" type="text/javascript"></script>
<script src="projg/js/image-picker.js" type="text/javascript"></script>
<script src="themes/mimity/js/bootstrap.js"></script>
<script>
	$("#workspace").load("main.g");
</script>