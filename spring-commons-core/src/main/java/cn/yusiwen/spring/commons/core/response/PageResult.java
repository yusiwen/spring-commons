package cn.yusiwen.spring.commons.core.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

/**
 * Generic paginated response wrapper.
 *
 * @param <T> the type of data in the current page
 */
@Data
@AllArgsConstructor
public class PageResult<T> {

    /** Current page number (1-indexed). */
    private Integer pageNo = 1;

    /** Number of items per page. */
    private Integer pageSize = 20;

    /** Total number of pages. */
    private Integer totalPage = 0;

    /** Total number of records across all pages. */
    private Integer totalRows = 0;

    /** The list of items in the current page. */
    private List<T> rows;
}
