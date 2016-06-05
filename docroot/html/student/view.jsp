<%@page contentType="text/html;charset=utf-8"%>
<%@ include file="/html/common/init.jsp"%>
<portlet:renderURL var="viewURL" />
<aui:nav-bar>
	<aui:nav>
		<portlet:renderURL var="addStudentURL">
			<portlet:param name="mvcPath" value="/html/student/edit_student.jsp" />
		</portlet:renderURL>
		<aui:nav-item href="<%=addStudentURL%>" iconCssClass="icon-plus"
			label="add-student" />
	</aui:nav>
</aui:nav-bar>
<liferay-ui:search-container
	emptyResultsMessage="no-students-were-found" delta="5">
	<liferay-ui:search-container-results results="${students }"
		total="${studentsCount }">
	</liferay-ui:search-container-results>
	<liferay-ui:search-container-row className="Student" modelVar="student"
		keyProperty="studentId">
		<liferay-ui:search-container-column-text property="name" name="student-name"/>
		<liferay-ui:search-container-column-text property="no" name="student-no"/>
		<liferay-ui:search-container-column-text name="gender">
			<liferay-ui:message key="${student.gender}" />
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="create-date">
			<%=DateUtil.getDate(student.getCreateDate(),
								"yyyy-MM-dd HH:mm:ss", locale, timeZone)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text name="modified-date">
			<%=DateUtil.getDate(student.getModifiedDate(),
								"yyyy-MM-dd HH:mm:ss", locale, timeZone)%>
		</liferay-ui:search-container-column-text>
		<liferay-ui:search-container-column-text>
			<liferay-ui:icon-menu>
				<portlet:renderURL var="editStudentURL">
					<portlet:param name="mvcPath"
						value="/html/student/edit_student.jsp" />
					<portlet:param name="studentId" value="${student.getStudentId()}" />
				</portlet:renderURL>
				<liferay-ui:icon image="edit" url="${editStudentURL}" />
				<portlet:actionURL var="deleteStudentURL" name="deleteStudent">
					<portlet:param name="studentId" value="${student.studentId}" />
					<portlet:param name="redirect" value="${viewURL}" />
				</portlet:actionURL>
				<liferay-ui:icon image="delete" url="${deleteStudentURL}" />
			</liferay-ui:icon-menu>
		</liferay-ui:search-container-column-text>
	</liferay-ui:search-container-row>
	<liferay-ui:search-iterator />
</liferay-ui:search-container>


