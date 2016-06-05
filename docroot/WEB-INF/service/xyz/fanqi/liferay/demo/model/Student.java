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

package xyz.fanqi.liferay.demo.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Student service. Represents a row in the &quot;CURD_Student&quot; database table, with each column mapped to a property of this class.
 *
 * @author fanqi
 * @see StudentModel
 * @see xyz.fanqi.liferay.demo.model.impl.StudentImpl
 * @see xyz.fanqi.liferay.demo.model.impl.StudentModelImpl
 * @generated
 */
public interface Student extends StudentModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link xyz.fanqi.liferay.demo.model.impl.StudentImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
}