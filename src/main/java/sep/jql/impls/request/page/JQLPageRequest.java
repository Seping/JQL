package sep.jql.impls.request.page;

import sep.jql.interfaces.request.page.PageRequest;

public class JQLPageRequest implements PageRequest {

    private Integer offset;
    private Integer rowCount;

    private JQLPageRequest(Integer offset, Integer rowCount) {
        this.offset = offset;
        this.rowCount = rowCount;
    }

    public static JQLPageRequest of(Integer offset, Integer rowCount) {
        return new JQLPageRequest(offset, rowCount);
    }

    @Override
    public Integer getOffset() {
        return offset;
    }

    @Override
    public Integer getRowCount() {
        return rowCount;
    }
}
