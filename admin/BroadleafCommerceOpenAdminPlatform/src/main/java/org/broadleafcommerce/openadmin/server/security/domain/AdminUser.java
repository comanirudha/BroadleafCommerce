/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.broadleafcommerce.openadmin.server.security.domain;

import org.broadleafcommerce.openadmin.server.domain.SandBox;

import java.io.Serializable;
import java.util.Set;

/**
 * 
 * @author jfischer
 *
 */
public interface AdminUser extends Serializable {
    public Long getId();
    public String getName();
    public void setName(String name);
    public String getLogin();
    public void setLogin(String login);
    public String getPassword();
    public void setPassword(String password);
    public String getEmail();
    public void setEmail(String email);
    public Set<AdminRole> getAllRoles();
    public void setAllRoles(Set<AdminRole> allRoles);
    public String getUnencodedPassword();
    public void setUnencodedPassword(String unencodedPassword);

    /**
     * The current sandbox associated with this user.
     * This is primarily intended to be used by the BLC-CMS workflow
     * processes.
     *
     * @return
     */
    public SandBox getCurrentSandbox();

    /**
     * Sets the user's current sandbox.    This is typically called by the
     * BLC-CMS engine in order to switch the default workspace for the user.
     *
     * @param sandbox
     */
    public void setCurrentSandbox(SandBox sandbox);
}