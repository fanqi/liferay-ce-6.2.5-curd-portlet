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

package xyz.fanqi.liferay.demo.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import xyz.fanqi.liferay.demo.model.Student;

import java.util.List;

/**
 * The persistence utility for the student service. This utility wraps {@link StudentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see StudentPersistence
 * @see StudentPersistenceImpl
 * @generated
 */
public class StudentUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(Student student) {
		getPersistence().clearCache(student);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Student> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Student> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Student> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Student update(Student student) throws SystemException {
		return getPersistence().update(student);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Student update(Student student, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(student, serviceContext);
	}

	/**
	* Returns all the students where name LIKE &#63;.
	*
	* @param name the name
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<xyz.fanqi.liferay.demo.model.Student> findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns a range of all the students where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link xyz.fanqi.liferay.demo.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<xyz.fanqi.liferay.demo.model.Student> findByName(
		java.lang.String name, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end);
	}

	/**
	* Returns an ordered range of all the students where name LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link xyz.fanqi.liferay.demo.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<xyz.fanqi.liferay.demo.model.Student> findByName(
		java.lang.String name, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByName(name, start, end, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student findByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			xyz.fanqi.liferay.demo.NoSuchStudentException {
		return getPersistence().findByName_First(name, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student fetchByName_First(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_First(name, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student findByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			xyz.fanqi.liferay.demo.NoSuchStudentException {
		return getPersistence().findByName_Last(name, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where name LIKE &#63;.
	*
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student fetchByName_Last(
		java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName_Last(name, orderByComparator);
	}

	/**
	* Returns the students before and after the current student in the ordered set where name LIKE &#63;.
	*
	* @param studentId the primary key of the current student
	* @param name the name
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student[] findByName_PrevAndNext(
		long studentId, java.lang.String name,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			xyz.fanqi.liferay.demo.NoSuchStudentException {
		return getPersistence()
				   .findByName_PrevAndNext(studentId, name, orderByComparator);
	}

	/**
	* Removes all the students where name LIKE &#63; from the database.
	*
	* @param name the name
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByName(name);
	}

	/**
	* Returns the number of students where name LIKE &#63;.
	*
	* @param name the name
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Returns all the students where name LIKE &#63; and no LIKE &#63;.
	*
	* @param name the name
	* @param no the no
	* @return the matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<xyz.fanqi.liferay.demo.model.Student> findByNameAndNo(
		java.lang.String name, java.lang.String no)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNameAndNo(name, no);
	}

	/**
	* Returns a range of all the students where name LIKE &#63; and no LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link xyz.fanqi.liferay.demo.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param no the no
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<xyz.fanqi.liferay.demo.model.Student> findByNameAndNo(
		java.lang.String name, java.lang.String no, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByNameAndNo(name, no, start, end);
	}

	/**
	* Returns an ordered range of all the students where name LIKE &#63; and no LIKE &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link xyz.fanqi.liferay.demo.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param name the name
	* @param no the no
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<xyz.fanqi.liferay.demo.model.Student> findByNameAndNo(
		java.lang.String name, java.lang.String no, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByNameAndNo(name, no, start, end, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where name LIKE &#63; and no LIKE &#63;.
	*
	* @param name the name
	* @param no the no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student
	* @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student findByNameAndNo_First(
		java.lang.String name, java.lang.String no,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			xyz.fanqi.liferay.demo.NoSuchStudentException {
		return getPersistence()
				   .findByNameAndNo_First(name, no, orderByComparator);
	}

	/**
	* Returns the first student in the ordered set where name LIKE &#63; and no LIKE &#63;.
	*
	* @param name the name
	* @param no the no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student fetchByNameAndNo_First(
		java.lang.String name, java.lang.String no,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndNo_First(name, no, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where name LIKE &#63; and no LIKE &#63;.
	*
	* @param name the name
	* @param no the no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student
	* @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student findByNameAndNo_Last(
		java.lang.String name, java.lang.String no,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			xyz.fanqi.liferay.demo.NoSuchStudentException {
		return getPersistence().findByNameAndNo_Last(name, no, orderByComparator);
	}

	/**
	* Returns the last student in the ordered set where name LIKE &#63; and no LIKE &#63;.
	*
	* @param name the name
	* @param no the no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching student, or <code>null</code> if a matching student could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student fetchByNameAndNo_Last(
		java.lang.String name, java.lang.String no,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByNameAndNo_Last(name, no, orderByComparator);
	}

	/**
	* Returns the students before and after the current student in the ordered set where name LIKE &#63; and no LIKE &#63;.
	*
	* @param studentId the primary key of the current student
	* @param name the name
	* @param no the no
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next student
	* @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student[] findByNameAndNo_PrevAndNext(
		long studentId, java.lang.String name, java.lang.String no,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			xyz.fanqi.liferay.demo.NoSuchStudentException {
		return getPersistence()
				   .findByNameAndNo_PrevAndNext(studentId, name, no,
			orderByComparator);
	}

	/**
	* Removes all the students where name LIKE &#63; and no LIKE &#63; from the database.
	*
	* @param name the name
	* @param no the no
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByNameAndNo(java.lang.String name,
		java.lang.String no)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByNameAndNo(name, no);
	}

	/**
	* Returns the number of students where name LIKE &#63; and no LIKE &#63;.
	*
	* @param name the name
	* @param no the no
	* @return the number of matching students
	* @throws SystemException if a system exception occurred
	*/
	public static int countByNameAndNo(java.lang.String name,
		java.lang.String no)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByNameAndNo(name, no);
	}

	/**
	* Caches the student in the entity cache if it is enabled.
	*
	* @param student the student
	*/
	public static void cacheResult(xyz.fanqi.liferay.demo.model.Student student) {
		getPersistence().cacheResult(student);
	}

	/**
	* Caches the students in the entity cache if it is enabled.
	*
	* @param students the students
	*/
	public static void cacheResult(
		java.util.List<xyz.fanqi.liferay.demo.model.Student> students) {
		getPersistence().cacheResult(students);
	}

	/**
	* Creates a new student with the primary key. Does not add the student to the database.
	*
	* @param studentId the primary key for the new student
	* @return the new student
	*/
	public static xyz.fanqi.liferay.demo.model.Student create(long studentId) {
		return getPersistence().create(studentId);
	}

	/**
	* Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param studentId the primary key of the student
	* @return the student that was removed
	* @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student remove(long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			xyz.fanqi.liferay.demo.NoSuchStudentException {
		return getPersistence().remove(studentId);
	}

	public static xyz.fanqi.liferay.demo.model.Student updateImpl(
		xyz.fanqi.liferay.demo.model.Student student)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(student);
	}

	/**
	* Returns the student with the primary key or throws a {@link xyz.fanqi.liferay.demo.NoSuchStudentException} if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student
	* @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student findByPrimaryKey(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			xyz.fanqi.liferay.demo.NoSuchStudentException {
		return getPersistence().findByPrimaryKey(studentId);
	}

	/**
	* Returns the student with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param studentId the primary key of the student
	* @return the student, or <code>null</code> if a student with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static xyz.fanqi.liferay.demo.model.Student fetchByPrimaryKey(
		long studentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(studentId);
	}

	/**
	* Returns all the students.
	*
	* @return the students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<xyz.fanqi.liferay.demo.model.Student> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link xyz.fanqi.liferay.demo.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @return the range of students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<xyz.fanqi.liferay.demo.model.Student> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the students.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link xyz.fanqi.liferay.demo.model.impl.StudentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of students
	* @param end the upper bound of the range of students (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of students
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<xyz.fanqi.liferay.demo.model.Student> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the students from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of students.
	*
	* @return the number of students
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static StudentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (StudentPersistence)PortletBeanLocatorUtil.locate(xyz.fanqi.liferay.demo.service.ClpSerializer.getServletContextName(),
					StudentPersistence.class.getName());

			ReferenceRegistry.registerReference(StudentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(StudentPersistence persistence) {
	}

	private static StudentPersistence _persistence;
}