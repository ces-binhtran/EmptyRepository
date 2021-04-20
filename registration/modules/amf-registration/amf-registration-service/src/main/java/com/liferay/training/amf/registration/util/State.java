package com.liferay.training.amf.registration.util;

import com.liferay.portal.kernel.util.HashCode;
import com.liferay.portal.kernel.util.HashCodeFactoryUtil;
import com.liferay.portal.kernel.util.StringUtil;

public class State {
    public State(String id, String name) {
        _id = id;
        _name = name;
    }

    public int compareTo(Object obj) {
        State state = (State)obj;

        if ((getId() != null) && (state.getId() != null)) {
            return StringUtil.toLowerCase(getId()).compareTo(
                    StringUtil.toLowerCase(state.getId()));
        }
        else if ((getName() != null) && (state.getName() != null)) {
            return StringUtil.toLowerCase(getName()).compareTo(
                    StringUtil.toLowerCase(state.getName()));
        }
        else {
            return -1;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof State)) {
            return false;
        }

        State state = (State)obj;

        if ((getId() != null) && (state.getId() != null)) {
            return StringUtil.equalsIgnoreCase(getId(), state.getId());
        }
        else if ((getName() != null) && (state.getName() != null)) {
            return StringUtil.equalsIgnoreCase(getName(), state.getName());
        }
        else {
            return false;
        }
    }

    public String getId() {
        return _id;
    }

    public String getName() {
        return _name;
    }

    @Override
    public int hashCode() {
        HashCode hashCode = HashCodeFactoryUtil.getHashCode();

        hashCode.append(_id);
        hashCode.append(_name);

        return hashCode.toHashCode();
    }

    private final String _id;
    private final String _name;
}
