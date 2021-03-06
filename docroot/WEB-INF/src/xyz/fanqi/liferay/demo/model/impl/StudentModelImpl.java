/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package xyz.fanqi.liferay.demo.model.impl;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSON;
import com.liferay.portal.kernel.util.DateUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.impl.BaseModelImpl;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;

import com.liferay.portlet.expando.model.ExpandoBridge;
import com.liferay.portlet.expando.util.ExpandoBridgeFactoryUtil;

import xyz.fanqi.liferay.demo.model.Student;
import xyz.fanqi.liferay.demo.model.StudentModel;
import xyz.fanqi.liferay.demo.model.StudentSoap;

import java.io.Serializable;

import java.sql.Types;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * The base model implementation for the Student service. Represents a row in the &quot;CURD_Student&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This implementation and its corresponding interface {@link xyz.fanqi.liferay.demo.model.StudentModel} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link StudentImpl}.
 * </p>
 *
 * @author fanqi
 * @see StudentImpl
 * @see xyz.fanqi.liferay.demo.model.Student
 * @see xyz.fanqi.liferay.demo.model.StudentModel
 * @generated
 */
@JSON(strict = true)
public class StudentModelImpl extends BaseModelImpl<Student>
	implements StudentModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. All methods that expect a student model instance should use the {@link xyz.fanqi.liferay.demo.model.Student} interface instead.
	 */
	public static final String TABLE_NAME = "CURD_Student";
	public static final Object[][] TABLE_COLUMNS = {
			{ "studentId", Types.BIGINT },
			{ "groupId", Types.BIGINT },
			{ "companyId", Types.BIGINT },
			{ "userId", Types.BIGINT },
			{ "userName", Types.VARCHAR },
			{ "createDate", Types.TIMESTAMP },
			{ "modifiedDate", Types.TIMESTAMP },
			{ "name", Types.VARCHAR },
			{ "no", Types.VARCHAR },
			{ "gender", Types.VARCHAR }
		};
	public static final String TABLE_SQL_CREATE = "create table CURD_Student (studentId LONG not null primary key,groupId LONG,companyId LONG,userId LONG,userName VARCHAR(75) null,createDate DATE null,modifiedDate DATE null,name VARCHAR(75) null,no VARCHAR(75) null,gender VARCHAR(75) null)";
	public static final String TABLE_SQL_DROP = "drop table CURD_Student";
	public static final String ORDER_BY_JPQL = " ORDER BY student.createDate ASC";
	public static final String ORDER_BY_SQL = " ORDER BY CURD_Student.createDate ASC";
	public static final String DATA_SOURCE = "liferayDataSource";
	public static final String SESSION_FACTORY = "liferaySessionFactory";
	public static final String TX_MANAGER = "liferayTransactionManager";
	public static final boolean ENTITY_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.entity.cache.enabled.xyz.fanqi.liferay.demo.model.Student"),
			true);
	public static final boolean FINDER_CACHE_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.finder.cache.enabled.xyz.fanqi.liferay.demo.model.Student"),
			true);
	public static final boolean COLUMN_BITMASK_ENABLED = GetterUtil.getBoolean(com.liferay.util.service.ServiceProps.get(
				"value.object.column.bitmask.enabled.xyz.fanqi.liferay.demo.model.Student"),
			true);
	public static long NAME_COLUMN_BITMASK = 1L;
	public static long NO_COLUMN_BITMASK = 2L;
	public static long CREATEDATE_COLUMN_BITMASK = 4L;

	/**
	 * Converts the soap model instance into a normal model instance.
	 *
	 * @param soapModel the soap model instance to convert
	 * @return the normal model instance
	 */
	public static Student toModel(StudentSoap soapModel) {
		if (soapModel == null) {
			return null;
		}

		Student model = new StudentImpl();

		model.setStudentId(soapModel.getStudentId());
		model.setGroupId(soapModel.getGroupId());
		model.setCompanyId(soapModel.getCompanyId());
		model.setUserId(soapModel.getUserId());
		model.setUserName(soapModel.getUserName());
		model.setCreateDate(soapModel.getCreateDate());
		model.setModifiedDate(soapModel.getModifiedDate());
		model.setName(soapModel.getName());
		model.setNo(soapModel.getNo());
		model.setGender(soapModel.getGender());

		return model;
	}

	/**
	 * Converts the soap model instances into normal model instances.
	 *
	 * @param soapModels the soap model instances to convert
	 * @return the normal model instances
	 */
	public static List<Student> toModels(StudentSoap[] soapModels) {
		if (soapModels == null) {
			return null;
		}

		List<Student> models = new ArrayList<Student>(soapModels.length);

		for (StudentSoap soapModel : soapModels) {
			models.add(toModel(soapModel));
		}

		return models;
	}

	public static final long LOCK_EXPIRATION_TIME = GetterUtil.getLong(com.liferay.util.service.ServiceProps.get(
				"lock.expiration.time.xyz.fanqi.liferay.demo.model.Student"));

	public StudentModelImpl() {
	}

	@Override
	public long getPrimaryKey() {
		return _studentId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStudentId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _studentId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Class<?> getModelClass() {
		return Student.class;
	}

	@Override
	public String getModelClassName() {
		return Student.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("studentId", getStudentId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("name", getName());
		attributes.put("no", getNo());
		attributes.put("gender", getGender());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long studentId = (Long)attributes.get("studentId");

		if (studentId != null) {
			setStudentId(studentId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		String name = (String)attributes.get("name");

		if (name != null) {
			setName(name);
		}

		String no = (String)attributes.get("no");

		if (no != null) {
			setNo(no);
		}

		String gender = (String)attributes.get("gender");

		if (gender != null) {
			setGender(gender);
		}
	}

	@JSON
	@Override
	public long getStudentId() {
		return _studentId;
	}

	@Override
	public void setStudentId(long studentId) {
		_studentId = studentId;
	}

	@JSON
	@Override
	public long getGroupId() {
		return _groupId;
	}

	@Override
	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	@JSON
	@Override
	public long getCompanyId() {
		return _companyId;
	}

	@Override
	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	@JSON
	@Override
	public long getUserId() {
		return _userId;
	}

	@Override
	public void setUserId(long userId) {
		_userId = userId;
	}

	@Override
	public String getUserUuid() throws SystemException {
		return PortalUtil.getUserValue(getUserId(), "uuid", _userUuid);
	}

	@Override
	public void setUserUuid(String userUuid) {
		_userUuid = userUuid;
	}

	@JSON
	@Override
	public String getUserName() {
		if (_userName == null) {
			return StringPool.BLANK;
		}
		else {
			return _userName;
		}
	}

	@Override
	public void setUserName(String userName) {
		_userName = userName;
	}

	@JSON
	@Override
	public Date getCreateDate() {
		return _createDate;
	}

	@Override
	public void setCreateDate(Date createDate) {
		_columnBitmask = -1L;

		_createDate = createDate;
	}

	@JSON
	@Override
	public Date getModifiedDate() {
		return _modifiedDate;
	}

	@Override
	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	@JSON
	@Override
	public String getName() {
		if (_name == null) {
			return StringPool.BLANK;
		}
		else {
			return _name;
		}
	}

	@Override
	public void setName(String name) {
		_columnBitmask |= NAME_COLUMN_BITMASK;

		if (_originalName == null) {
			_originalName = _name;
		}

		_name = name;
	}

	public String getOriginalName() {
		return GetterUtil.getString(_originalName);
	}

	@JSON
	@Override
	public String getNo() {
		if (_no == null) {
			return StringPool.BLANK;
		}
		else {
			return _no;
		}
	}

	@Override
	public void setNo(String no) {
		_columnBitmask |= NO_COLUMN_BITMASK;

		if (_originalNo == null) {
			_originalNo = _no;
		}

		_no = no;
	}

	public String getOriginalNo() {
		return GetterUtil.getString(_originalNo);
	}

	@JSON
	@Override
	public String getGender() {
		if (_gender == null) {
			return StringPool.BLANK;
		}
		else {
			return _gender;
		}
	}

	@Override
	public void setGender(String gender) {
		_gender = gender;
	}

	public long getColumnBitmask() {
		return _columnBitmask;
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return ExpandoBridgeFactoryUtil.getExpandoBridge(getCompanyId(),
			Student.class.getName(), getPrimaryKey());
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		ExpandoBridge expandoBridge = getExpandoBridge();

		expandoBridge.setAttributes(serviceContext);
	}

	@Override
	public Student toEscapedModel() {
		if (_escapedModel == null) {
			_escapedModel = (Student)ProxyUtil.newProxyInstance(_classLoader,
					_escapedModelInterfaces, new AutoEscapeBeanHandler(this));
		}

		return _escapedModel;
	}

	@Override
	public Object clone() {
		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setStudentId(getStudentId());
		studentImpl.setGroupId(getGroupId());
		studentImpl.setCompanyId(getCompanyId());
		studentImpl.setUserId(getUserId());
		studentImpl.setUserName(getUserName());
		studentImpl.setCreateDate(getCreateDate());
		studentImpl.setModifiedDate(getModifiedDate());
		studentImpl.setName(getName());
		studentImpl.setNo(getNo());
		studentImpl.setGender(getGender());

		studentImpl.resetOriginalValues();

		return studentImpl;
	}

	@Override
	public int compareTo(Student student) {
		int value = 0;

		value = DateUtil.compareTo(getCreateDate(), student.getCreateDate());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Student)) {
			return false;
		}

		Student student = (Student)obj;

		long primaryKey = student.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public void resetOriginalValues() {
		StudentModelImpl studentModelImpl = this;

		studentModelImpl._originalName = studentModelImpl._name;

		studentModelImpl._originalNo = studentModelImpl._no;

		studentModelImpl._columnBitmask = 0;
	}

	@Override
	public CacheModel<Student> toCacheModel() {
		StudentCacheModel studentCacheModel = new StudentCacheModel();

		studentCacheModel.studentId = getStudentId();

		studentCacheModel.groupId = getGroupId();

		studentCacheModel.companyId = getCompanyId();

		studentCacheModel.userId = getUserId();

		studentCacheModel.userName = getUserName();

		String userName = studentCacheModel.userName;

		if ((userName != null) && (userName.length() == 0)) {
			studentCacheModel.userName = null;
		}

		Date createDate = getCreateDate();

		if (createDate != null) {
			studentCacheModel.createDate = createDate.getTime();
		}
		else {
			studentCacheModel.createDate = Long.MIN_VALUE;
		}

		Date modifiedDate = getModifiedDate();

		if (modifiedDate != null) {
			studentCacheModel.modifiedDate = modifiedDate.getTime();
		}
		else {
			studentCacheModel.modifiedDate = Long.MIN_VALUE;
		}

		studentCacheModel.name = getName();

		String name = studentCacheModel.name;

		if ((name != null) && (name.length() == 0)) {
			studentCacheModel.name = null;
		}

		studentCacheModel.no = getNo();

		String no = studentCacheModel.no;

		if ((no != null) && (no.length() == 0)) {
			studentCacheModel.no = null;
		}

		studentCacheModel.gender = getGender();

		String gender = studentCacheModel.gender;

		if ((gender != null) && (gender.length() == 0)) {
			studentCacheModel.gender = null;
		}

		return studentCacheModel;
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{studentId=");
		sb.append(getStudentId());
		sb.append(", groupId=");
		sb.append(getGroupId());
		sb.append(", companyId=");
		sb.append(getCompanyId());
		sb.append(", userId=");
		sb.append(getUserId());
		sb.append(", userName=");
		sb.append(getUserName());
		sb.append(", createDate=");
		sb.append(getCreateDate());
		sb.append(", modifiedDate=");
		sb.append(getModifiedDate());
		sb.append(", name=");
		sb.append(getName());
		sb.append(", no=");
		sb.append(getNo());
		sb.append(", gender=");
		sb.append(getGender());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("xyz.fanqi.liferay.demo.model.Student");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>studentId</column-name><column-value><![CDATA[");
		sb.append(getStudentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>groupId</column-name><column-value><![CDATA[");
		sb.append(getGroupId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>companyId</column-name><column-value><![CDATA[");
		sb.append(getCompanyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userId</column-name><column-value><![CDATA[");
		sb.append(getUserId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>userName</column-name><column-value><![CDATA[");
		sb.append(getUserName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createDate</column-name><column-value><![CDATA[");
		sb.append(getCreateDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>modifiedDate</column-name><column-value><![CDATA[");
		sb.append(getModifiedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>name</column-name><column-value><![CDATA[");
		sb.append(getName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>no</column-name><column-value><![CDATA[");
		sb.append(getNo());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gender</column-name><column-value><![CDATA[");
		sb.append(getGender());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private static ClassLoader _classLoader = Student.class.getClassLoader();
	private static Class<?>[] _escapedModelInterfaces = new Class[] {
			Student.class
		};
	private long _studentId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userUuid;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private String _name;
	private String _originalName;
	private String _no;
	private String _originalNo;
	private String _gender;
	private long _columnBitmask;
	private Student _escapedModel;
}