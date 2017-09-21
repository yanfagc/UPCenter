package org.hanzhdy.manager.executor.download;

/**
 * Created by H.CAAHN on 2017/7/12.
 */
public abstract class ExcelColumn<T> {
    private int width;

    private String name;

    public ExcelColumn(int width, String name) {
        this.width = width;
        this.name = name;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public abstract String getValue(T data);
}
