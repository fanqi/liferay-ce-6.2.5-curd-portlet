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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.CharPool;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import xyz.fanqi.liferay.demo.NoSuchStudentException;
import xyz.fanqi.liferay.demo.model.Student;
import xyz.fanqi.liferay.demo.model.impl.StudentImpl;
import xyz.fanqi.liferay.demo.model.impl.StudentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the student service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author fanqi
 * @see StudentPersistence
 * @see StudentUtil
 * @generated
 */
public class StudentPersistenceImpl extends BasePersistenceImpl<Student>
	implements StudentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link StudentUtil} to access the student persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = StudentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByName",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME = new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns all the students where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findByName(String name) throws SystemException {
		return findByName(name, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findByName(String name, int start, int end)
		throws SystemException {
		return findByName(name, start, end, null);
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
	@Override
	public List<Student> findByName(String name, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAME;
		finderArgs = new Object[] { name, start, end, orderByComparator };

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if (!StringUtil.wildcardMatches(student.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Student findByName_First(String name,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByName_First(name, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the first student in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByName_First(String name,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findByName(name, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student findByName_Last(String name,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByName_Last(name, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
	}

	/**
	 * Returns the last student in the ordered set where name LIKE &#63;.
	 *
	 * @param name the name
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching student, or <code>null</code> if a matching student could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByName_Last(String name,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByName(name);

		if (count == 0) {
			return null;
		}

		List<Student> list = findByName(name, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student[] findByName_PrevAndNext(long studentId, String name,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByName_PrevAndNext(session, student, name,
					orderByComparator, true);

			array[1] = student;

			array[2] = getByName_PrevAndNext(session, student, name,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByName_PrevAndNext(Session session, Student student,
		String name, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAME_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAME_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAME_NAME_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where name LIKE &#63; from the database.
	 *
	 * @param name the name
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByName(String name) throws SystemException {
		for (Student student : findByName(name, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where name LIKE &#63;.
	 *
	 * @param name the name
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "student.name LIKE NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "student.name LIKE ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(student.name IS NULL OR student.name LIKE '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDNO =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, StudentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByNameAndNo",
			new String[] {
				String.class.getName(), String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMEANDNO =
		new FinderPath(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "countByNameAndNo",
			new String[] { String.class.getName(), String.class.getName() });

	/**
	 * Returns all the students where name LIKE &#63; and no LIKE &#63;.
	 *
	 * @param name the name
	 * @param no the no
	 * @return the matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findByNameAndNo(String name, String no)
		throws SystemException {
		return findByNameAndNo(name, no, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
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
	@Override
	public List<Student> findByNameAndNo(String name, String no, int start,
		int end) throws SystemException {
		return findByNameAndNo(name, no, start, end, null);
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
	@Override
	public List<Student> findByNameAndNo(String name, String no, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_NAMEANDNO;
		finderArgs = new Object[] { name, no, start, end, orderByComparator };

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Student student : list) {
				if (!StringUtil.wildcardMatches(student.getName(), name,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true) ||
						!StringUtil.wildcardMatches(student.getNo(), no,
							CharPool.UNDERLINE, CharPool.PERCENT,
							CharPool.BACK_SLASH, true)) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_STUDENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDNO_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDNO_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDNO_NAME_2);
			}

			boolean bindNo = false;

			if (no == null) {
				query.append(_FINDER_COLUMN_NAMEANDNO_NO_1);
			}
			else if (no.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDNO_NO_3);
			}
			else {
				bindNo = true;

				query.append(_FINDER_COLUMN_NAMEANDNO_NO_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(StudentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindNo) {
					qPos.add(no);
				}

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public Student findByNameAndNo_First(String name, String no,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByNameAndNo_First(name, no, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", no=");
		msg.append(no);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
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
	@Override
	public Student fetchByNameAndNo_First(String name, String no,
		OrderByComparator orderByComparator) throws SystemException {
		List<Student> list = findByNameAndNo(name, no, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student findByNameAndNo_Last(String name, String no,
		OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByNameAndNo_Last(name, no, orderByComparator);

		if (student != null) {
			return student;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("name=");
		msg.append(name);

		msg.append(", no=");
		msg.append(no);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchStudentException(msg.toString());
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
	@Override
	public Student fetchByNameAndNo_Last(String name, String no,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByNameAndNo(name, no);

		if (count == 0) {
			return null;
		}

		List<Student> list = findByNameAndNo(name, no, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public Student[] findByNameAndNo_PrevAndNext(long studentId, String name,
		String no, OrderByComparator orderByComparator)
		throws NoSuchStudentException, SystemException {
		Student student = findByPrimaryKey(studentId);

		Session session = null;

		try {
			session = openSession();

			Student[] array = new StudentImpl[3];

			array[0] = getByNameAndNo_PrevAndNext(session, student, name, no,
					orderByComparator, true);

			array[1] = student;

			array[2] = getByNameAndNo_PrevAndNext(session, student, name, no,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Student getByNameAndNo_PrevAndNext(Session session,
		Student student, String name, String no,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_STUDENT_WHERE);

		boolean bindName = false;

		if (name == null) {
			query.append(_FINDER_COLUMN_NAMEANDNO_NAME_1);
		}
		else if (name.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMEANDNO_NAME_3);
		}
		else {
			bindName = true;

			query.append(_FINDER_COLUMN_NAMEANDNO_NAME_2);
		}

		boolean bindNo = false;

		if (no == null) {
			query.append(_FINDER_COLUMN_NAMEANDNO_NO_1);
		}
		else if (no.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_NAMEANDNO_NO_3);
		}
		else {
			bindNo = true;

			query.append(_FINDER_COLUMN_NAMEANDNO_NO_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(StudentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindName) {
			qPos.add(name);
		}

		if (bindNo) {
			qPos.add(no);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(student);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Student> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the students where name LIKE &#63; and no LIKE &#63; from the database.
	 *
	 * @param name the name
	 * @param no the no
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByNameAndNo(String name, String no)
		throws SystemException {
		for (Student student : findByNameAndNo(name, no, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students where name LIKE &#63; and no LIKE &#63;.
	 *
	 * @param name the name
	 * @param no the no
	 * @return the number of matching students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByNameAndNo(String name, String no)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_WITH_PAGINATION_COUNT_BY_NAMEANDNO;

		Object[] finderArgs = new Object[] { name, no };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_STUDENT_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAMEANDNO_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDNO_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAMEANDNO_NAME_2);
			}

			boolean bindNo = false;

			if (no == null) {
				query.append(_FINDER_COLUMN_NAMEANDNO_NO_1);
			}
			else if (no.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAMEANDNO_NO_3);
			}
			else {
				bindNo = true;

				query.append(_FINDER_COLUMN_NAMEANDNO_NO_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				if (bindNo) {
					qPos.add(no);
				}

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_NAMEANDNO_NAME_1 = "student.name LIKE NULL AND ";
	private static final String _FINDER_COLUMN_NAMEANDNO_NAME_2 = "student.name LIKE ? AND ";
	private static final String _FINDER_COLUMN_NAMEANDNO_NAME_3 = "(student.name IS NULL OR student.name LIKE '') AND ";
	private static final String _FINDER_COLUMN_NAMEANDNO_NO_1 = "student.no LIKE NULL";
	private static final String _FINDER_COLUMN_NAMEANDNO_NO_2 = "student.no LIKE ?";
	private static final String _FINDER_COLUMN_NAMEANDNO_NO_3 = "(student.no IS NULL OR student.no LIKE '')";

	public StudentPersistenceImpl() {
		setModelClass(Student.class);
	}

	/**
	 * Caches the student in the entity cache if it is enabled.
	 *
	 * @param student the student
	 */
	@Override
	public void cacheResult(Student student) {
		EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey(), student);

		student.resetOriginalValues();
	}

	/**
	 * Caches the students in the entity cache if it is enabled.
	 *
	 * @param students the students
	 */
	@Override
	public void cacheResult(List<Student> students) {
		for (Student student : students) {
			if (EntityCacheUtil.getResult(
						StudentModelImpl.ENTITY_CACHE_ENABLED,
						StudentImpl.class, student.getPrimaryKey()) == null) {
				cacheResult(student);
			}
			else {
				student.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all students.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(StudentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(StudentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the student.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Student student) {
		EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Student> students) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Student student : students) {
			EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
				StudentImpl.class, student.getPrimaryKey());
		}
	}

	/**
	 * Creates a new student with the primary key. Does not add the student to the database.
	 *
	 * @param studentId the primary key for the new student
	 * @return the new student
	 */
	@Override
	public Student create(long studentId) {
		Student student = new StudentImpl();

		student.setNew(true);
		student.setPrimaryKey(studentId);

		return student;
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param studentId the primary key of the student
	 * @return the student that was removed
	 * @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student remove(long studentId)
		throws NoSuchStudentException, SystemException {
		return remove((Serializable)studentId);
	}

	/**
	 * Removes the student with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student that was removed
	 * @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student remove(Serializable primaryKey)
		throws NoSuchStudentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Student student = (Student)session.get(StudentImpl.class, primaryKey);

			if (student == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(student);
		}
		catch (NoSuchStudentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Student removeImpl(Student student) throws SystemException {
		student = toUnwrappedModel(student);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(student)) {
				student = (Student)session.get(StudentImpl.class,
						student.getPrimaryKeyObj());
			}

			if (student != null) {
				session.delete(student);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (student != null) {
			clearCache(student);
		}

		return student;
	}

	@Override
	public Student updateImpl(xyz.fanqi.liferay.demo.model.Student student)
		throws SystemException {
		student = toUnwrappedModel(student);

		boolean isNew = student.isNew();

		Session session = null;

		try {
			session = openSession();

			if (student.isNew()) {
				session.save(student);

				student.setNew(false);
			}
			else {
				session.merge(student);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !StudentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
			StudentImpl.class, student.getPrimaryKey(), student);

		return student;
	}

	protected Student toUnwrappedModel(Student student) {
		if (student instanceof StudentImpl) {
			return student;
		}

		StudentImpl studentImpl = new StudentImpl();

		studentImpl.setNew(student.isNew());
		studentImpl.setPrimaryKey(student.getPrimaryKey());

		studentImpl.setStudentId(student.getStudentId());
		studentImpl.setGroupId(student.getGroupId());
		studentImpl.setCompanyId(student.getCompanyId());
		studentImpl.setUserId(student.getUserId());
		studentImpl.setUserName(student.getUserName());
		studentImpl.setCreateDate(student.getCreateDate());
		studentImpl.setModifiedDate(student.getModifiedDate());
		studentImpl.setName(student.getName());
		studentImpl.setNo(student.getNo());
		studentImpl.setGender(student.getGender());

		return studentImpl;
	}

	/**
	 * Returns the student with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student
	 * @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student findByPrimaryKey(Serializable primaryKey)
		throws NoSuchStudentException, SystemException {
		Student student = fetchByPrimaryKey(primaryKey);

		if (student == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchStudentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return student;
	}

	/**
	 * Returns the student with the primary key or throws a {@link xyz.fanqi.liferay.demo.NoSuchStudentException} if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student
	 * @throws xyz.fanqi.liferay.demo.NoSuchStudentException if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student findByPrimaryKey(long studentId)
		throws NoSuchStudentException, SystemException {
		return findByPrimaryKey((Serializable)studentId);
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Student student = (Student)EntityCacheUtil.getResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
				StudentImpl.class, primaryKey);

		if (student == _nullStudent) {
			return null;
		}

		if (student == null) {
			Session session = null;

			try {
				session = openSession();

				student = (Student)session.get(StudentImpl.class, primaryKey);

				if (student != null) {
					cacheResult(student);
				}
				else {
					EntityCacheUtil.putResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
						StudentImpl.class, primaryKey, _nullStudent);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(StudentModelImpl.ENTITY_CACHE_ENABLED,
					StudentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return student;
	}

	/**
	 * Returns the student with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param studentId the primary key of the student
	 * @return the student, or <code>null</code> if a student with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Student fetchByPrimaryKey(long studentId) throws SystemException {
		return fetchByPrimaryKey((Serializable)studentId);
	}

	/**
	 * Returns all the students.
	 *
	 * @return the students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Student> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<Student> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<Student> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Student> list = (List<Student>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_STUDENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_STUDENT;

				if (pagination) {
					sql = sql.concat(StudentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Student>(list);
				}
				else {
					list = (List<Student>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the students from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Student student : findAll()) {
			remove(student);
		}
	}

	/**
	 * Returns the number of students.
	 *
	 * @return the number of students
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_STUDENT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the student persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.xyz.fanqi.liferay.demo.model.Student")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Student>> listenersList = new ArrayList<ModelListener<Student>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Student>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(StudentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_STUDENT = "SELECT student FROM Student student";
	private static final String _SQL_SELECT_STUDENT_WHERE = "SELECT student FROM Student student WHERE ";
	private static final String _SQL_COUNT_STUDENT = "SELECT COUNT(student) FROM Student student";
	private static final String _SQL_COUNT_STUDENT_WHERE = "SELECT COUNT(student) FROM Student student WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "student.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Student exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Student exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(StudentPersistenceImpl.class);
	private static Student _nullStudent = new StudentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Student> toCacheModel() {
				return _nullStudentCacheModel;
			}
		};

	private static CacheModel<Student> _nullStudentCacheModel = new CacheModel<Student>() {
			@Override
			public Student toEntityModel() {
				return _nullStudent;
			}
		};
}