package com.klauting.timormall.common.web.editor;

import com.klauting.timormall.common.utils.DateHelper;

import java.beans.PropertyEditorSupport;

/**
 * @author zhangxd
 */
public class DateEditor extends PropertyEditorSupport {

    @Override
    public void setAsText(String text) {
        setValue(DateHelper.parseDate(text));
    }

}
