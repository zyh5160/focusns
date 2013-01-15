/*
 * Copyright (C) 2011-2013 FocusSNS.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301  USA
 */

package org.focusns.service.core.impl;

import org.focusns.dao.core.ProjectRoleDao;
import org.focusns.model.core.ProjectRole;
import org.focusns.service.core.ProjectRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ProjectRoleServiceImpl implements ProjectRoleService {

    @Autowired
    private ProjectRoleDao projectRoleDao;

    @Override
    public ProjectRole getProjectRole(long roleId) {
        return projectRoleDao.select(roleId);
    }

    @Override
    public void createProjectRole(ProjectRole role) {
        this.projectRoleDao.insert(role);
    }

    @Override
    public void modifyProjectRole(ProjectRole role) {
        this.projectRoleDao.update(role);
    }

    @Override
    public void removeProjectRole(ProjectRole role) {
        this.projectRoleDao.delete(role.getId());
    }

    @Override
    public void authorizeAuthority(long projectId, long roleId, long authorityId) {
        this.projectRoleDao.insertAuthority(projectId, roleId, authorityId);
    }

    @Override
    public void deauthorizeAuthority(long projectId, long roleId, long authorityId) {
        this.projectRoleDao.deleteAuthority(projectId, roleId, authorityId);
    }
}
