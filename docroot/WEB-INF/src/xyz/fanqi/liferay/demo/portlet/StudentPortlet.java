package xyz.fanqi.liferay.demo.portlet;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import xyz.fanqi.liferay.demo.model.Student;
import xyz.fanqi.liferay.demo.service.StudentLocalServiceUtil;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class StudentPortlet
 */
public class StudentPortlet extends MVCPortlet {

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		try {
			String keywords = ParamUtil.getString(renderRequest, "keywords");
			int delta = ParamUtil.getInteger(renderRequest, "delta", 5);
			int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = delta * (cur - 1);
			int end = delta * cur;
			List<Student> students = StudentLocalServiceUtil.findByNameAndNo(
					"%" + keywords + "%", "%" + keywords + "%", start, end);
			int studentsCount = StudentLocalServiceUtil.countByNameAndNo("%"
					+ keywords + "%", "%" + keywords + "%");
			renderRequest.setAttribute("students", students);
			renderRequest.setAttribute("studentsCount", studentsCount);
			renderRequest.setAttribute("keywords", keywords);
		} catch (SystemException e) {
			e.printStackTrace();
		}
		super.doView(renderRequest, renderResponse);
	}

	public void editStudent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, SystemException, PortalException, ParseException,
			InterruptedException {

		long studentId = ParamUtil.getLong(actionRequest, "studentId");
		String name = ParamUtil.getString(actionRequest, "name");
		String no = ParamUtil.getString(actionRequest, "no");
		String gender = ParamUtil.getString(actionRequest, "gender");
		Student student = null;
		Date now = new Date();
		if (studentId == 0) {
			studentId = CounterLocalServiceUtil.increment("student", 1);
			student = StudentLocalServiceUtil.createStudent(studentId);
			Long companyId = PortalUtil.getCompanyId(actionRequest);
			Long groupId = PortalUtil.getScopeGroupId(actionRequest);
			student.setCompanyId(companyId);
			student.setGroupId(groupId);
			student.setCreateDate(now);
		} else {
			student = StudentLocalServiceUtil.getStudent(studentId);
		}

		User user = PortalUtil.getUser(actionRequest);
		if (Validator.isNotNull(user)) {
			student.setUserId(user.getUserId());
			student.setUserName(user.getFullName());
		}

		student.setNo(no);
		student.setName(name);
		student.setGender(gender);
		student.setModifiedDate(now);

		StudentLocalServiceUtil.updateStudent(student);
	}

	public void deleteStudent(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {
		long studentId = ParamUtil.getLong(actionRequest, "studentId");
		StudentLocalServiceUtil.deleteStudent(studentId);
	}
}
