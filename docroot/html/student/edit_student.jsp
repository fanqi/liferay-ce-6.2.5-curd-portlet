<%@ page contentType="text/html;charset=utf-8"%>
<%@ include file="/html/common/init.jsp"%>
<%
	Long studentId = ParamUtil.getLong(request, "studentId");
	String title = "add-student";
	Student student = null;
	if (studentId != 0) {
		title = "edit-student";
		student = StudentLocalServiceUtil.getStudent(studentId);
		pageContext.setAttribute("student", student);
	}
%>
<aui:model-context bean="${student}" model="<%=Student.class%>" />
<portlet:renderURL var="viewURL" />
<liferay-ui:header title="<%=title %>" backURL="${viewURL }" />
<portlet:actionURL var="editStudentURL" name="editStudent">
	<portlet:param name="redirect" value="${viewURL }" />
</portlet:actionURL>
<aui:form action="${editStudentURL}">
	<aui:fieldset>
		<aui:input name="studentId" type="hidden" />
		<aui:input name="name" required="true" />
		<aui:input name="no" label="student-no" required="true" />
		<aui:field-wrapper label="gender" required="true">
			<aui:input id="male" name="gender" type="radio" label="male"
				value="male" checked='${student.gender eq "male"}'>
				<aui:validator name="required" />
			</aui:input>
			<aui:input id="female" name="gender" type="radio" label="female"
				value="female" checked='${student.gender eq "female"}'>
				<aui:validator name="required" />
			</aui:input>
		</aui:field-wrapper>
	</aui:fieldset>
	<aui:button-row>
		<aui:button type="submit" />
		<aui:button type="cancel" href="${viewURL }" />
	</aui:button-row>
</aui:form>
