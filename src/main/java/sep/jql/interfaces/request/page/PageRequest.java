package sep.jql.interfaces.request.page;

import sep.jql.interfaces.request.Request;

public interface PageRequest extends Request {

    Integer getOffset();

    Integer getRowCount();

}
