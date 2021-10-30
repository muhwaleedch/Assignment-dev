<%@ tag language="java" pageEncoding="ISO-8859-1" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="text" required="true" %>
<%@ attribute name="display" required="true" %>

<div id="${id}" style="text-align: center; display: ${display}">
	<span> ${text} &nbsp;&nbsp; <i
      id="profile-progress" class="fas fa-sync fa-spin"></i>
	</span>
</div>