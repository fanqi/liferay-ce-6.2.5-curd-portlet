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

package xyz.fanqi.liferay.demo.service.impl;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;

import xyz.fanqi.liferay.demo.model.Student;
import xyz.fanqi.liferay.demo.service.base.StudentLocalServiceBaseImpl;

/**
 * The implementation of the student local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link xyz.fanqi.liferay.demo.service.StudentLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author fanqi
 * @see xyz.fanqi.liferay.demo.service.base.StudentLocalServiceBaseImpl
 * @see xyz.fanqi.liferay.demo.service.StudentLocalServiceUtil
 */
public class StudentLocalServiceImpl extends StudentLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 * 
	 * Never reference this interface directly. Always use {@link
	 * xyz.fanqi.liferay.demo.service.StudentLocalServiceUtil} to access the
	 * student local service.
	 */
	public List<Student> findByName(String name, int start, int end)
			throws SystemException {
		return studentPersistence.findByName(name, start, end);
	}

	public int countByName(String name) throws SystemException {
		return studentPersistence.countByName(name);
	}

	public List<Student> findByNameAndNo(String name, String no, int start,
			int end) throws SystemException {
		return studentPersistence.findByNameAndNo(name, no, start, end);
	}

	public int countByNameAndNo(String name, String no) throws SystemException {
		return studentPersistence.countByNameAndNo(name, no);
	}

}