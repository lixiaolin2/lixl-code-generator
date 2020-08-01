package io.renren.base;

import io.renren.utils.ControllerUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


/**
 * 分页返回值结构
 *
 * @param <T>
 */
public class PageData<T> {

    private long count;

    private List<T> data;

    private int pageNo = 1;

    private int limit = 20;

    public long getCount() {
        return count;
    }

    public List<T> getData() {
        return data;
    }

    public int getPageNo() {
        return pageNo;
    }

    public int getLimit() {
        return limit;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public PageData() {
        HttpServletRequest request = ControllerUtils.getRequest();
        if (request != null) {
            String no = request.getParameter("pageNo" );
            String limit = request.getParameter("limit" );
            if (no != null && !no.equals("" )) {
                this.pageNo = Integer.parseInt(no);
            }
            if (limit != null && !limit.equals("" )) {
                this.limit = Integer.parseInt(limit);
            }
        }
    }

    public PageData(Integer pageNo, Integer pageSize) {
        if (pageNo != null) {
            this.pageNo = pageNo;
        }
        if (pageSize != null) {
            this.limit = pageSize;
        }
    }

}
