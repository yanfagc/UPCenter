package org.hanzhdy.manager.settings.engine.utils;

import java.util.List;

import org.hanzhdy.manager.settings.engine.attribute.FieldAttribute;

/**
 * @description 排序工具（目前用于排序表单项）
 * @author H.CAAHN
 * @createtime 2017年6月14日 下午9:36:59
 */
public class SortableUtils {
    public static void sort(List<FieldAttribute> attrList, int max) {
        if (attrList == null || attrList.isEmpty()) {
            return;
        }
        
        int cur = 0;
        for (int i = 0, s = attrList.size(); i < s; i++) {
            FieldAttribute attr = attrList.get(i);
            if (cur == 0 || cur + attr.getColspan() <= max) {
                cur += attr.getColspan();
                if (cur == max) {
                    cur = 0;
                }
                continue;
            }
            
            boolean exists = false;
            for (int j = i + 1; j < s; j++) {
                FieldAttribute trymove = attrList.get(j);
                if (cur + trymove.getColspan() <= max) {
                    for (int k = j; k > i; k--) {
                        attrList.set(k, attrList.get(k - 1));
                    }
                    exists = true;
                    attrList.set(i, trymove);
                    cur += trymove.getColspan();
                    break;
                }
            }
            
            if (!exists || cur == max) {
                cur = 0;
            }
        }
    }
}
