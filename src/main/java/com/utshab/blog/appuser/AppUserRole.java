package com.utshab.blog.appuser;

import com.google.common.collect.Sets;

import java.util.Set;

import static com.utshab.blog.appuser.AppUserPermission.*;

public enum AppUserRole {
    ADMIN(Sets.newHashSet(STUDENT_READ, STUDENT_WRITE, COURSE_READ, COURSE_WRITE)),
    STUDENT(Sets.newHashSet());

    private final Set<AppUserPermission> permissions;

    AppUserRole(Set<AppUserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<AppUserPermission> getPermissions() {
        return permissions;
    }
}
