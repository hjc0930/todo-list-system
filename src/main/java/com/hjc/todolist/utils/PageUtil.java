package com.hjc.todolist.utils;

import lombok.Data;
import java.util.LinkedHashMap;

@Data
public class PageUtil extends LinkedHashMap<String, Object> {
    private int page;
    private int pageSize;
    private int limit;

    public PageUtil(int page, int pageSize) {
        this.page = page;
        this.pageSize = pageSize;
        this.limit = (page - 1) * pageSize;

        this.put("page", page);
        this.put("pageSize", pageSize);
        this.put("limit", limit);
    }
}
