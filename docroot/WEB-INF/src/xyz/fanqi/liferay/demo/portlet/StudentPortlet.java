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
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.Junction;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
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
			String keywords = ParamUtil
					.getString(renderRequest, "keywords", "");
			int delta = ParamUtil.getInteger(renderRequest, "delta", 5);
			int cur = ParamUtil.getInteger(renderRequest, "cur", 1);
			int start = delta * (cur - 1);
			int end = delta * cur;
			String orderByCol = ParamUtil.getString(renderRequest,
					"orderByCol", "");
			String orderByType = ParamUtil.getString(renderRequest,
					"orderByType", "");
			List<Student> students = StudentLocalServiceUtil.dynamicQuery(
					createDynamicQueryByKeywords("%" + keywords + "%",
							orderByCol, orderByType), start, end);
			int studentsCount = (int) StudentLocalServiceUtil
					.dynamicQueryCount(createDynamicQueryByKeywords("%"
							+ keywords + "%", orderByCol, orderByType));
			renderRequest.setAttribute("students", students);
			renderRequest.setAttribute("studentsCount", studentsCount);
			renderRequest.setAttribute("orderByCol", orderByCol);
			renderRequest.setAttribute("orderByType", orderByType);
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

	public void deleteStudents(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException,
			PortletException, PortalException, SystemException {
		String deleteStudentIds = ParamUtil.getString(actionRequest,
				"studentIds");
		String[] studentIds = deleteStudentIds.split(",");
		for (String studentId : studentIds) {
			StudentLocalServiceUtil.deleteStudent(Long.parseLong(studentId));
		}
	}

	public DynamicQuery createDynamicQueryByKeywords(String keywords,
			String orderByCol, String orderByType) {
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil
				.forClass(Student.class);
		Junction junction = RestrictionsFactoryUtil.disjunction();
		junction.add(PropertyFactoryUtil.forName("name").like(keywords));
		junction.add(PropertyFactoryUtil.forName("no").like(keywords));
		dynamicQuery.add(junction);
		if (!Validator.isBlank(orderByCol)) {
			if (orderByType.equals("asc")) {
				dynamicQuery.addOrder(OrderFactoryUtil.asc(orderByCol));
			} else if (orderByType.equals("desc")) {
				dynamicQuery.addOrder(OrderFactoryUtil.desc(orderByCol));
			}
		}
		return dynamicQuery;
	}
}
