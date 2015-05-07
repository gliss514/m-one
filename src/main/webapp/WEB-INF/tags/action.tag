<%@ attribute name="url" required="false" type="java.lang.String"%>
<%@ attribute name="icon" required="false" type="java.lang.String"%>
<%@ attribute name="tooltip" required="false" type="java.lang.String"%>

<a href="#" onClick="load('${url}');" class="glyphicon glyphicon-${icon}" title="${tooltip}"></a>