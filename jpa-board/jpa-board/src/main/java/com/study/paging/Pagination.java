package com.study.paging;

import lombok.Getter;

@Getter
public class Pagination {
	
	private int totalRecordCount;
	private int totalPageCount;
	private int startPage;
	private int endPage;
	private int limitStart;
	private boolean existPrevPage;
	private boolean existNextPage;
	
	public Pagination(int totalRecordCount, CommonParams params) {
		if (totalRecordCount > 0) {
			this.totalRecordCount = totalRecordCount;
			this.calculation(params);
		}
	}
	
	private void calculation(CommonParams params) {
		
		totalPageCount = ((totalRecordCount - 1) / params.getRecordPerPage()) + 1;
		
		if (params.getPage() > totalPageCount) {
            params.setPage(totalPageCount);
        }

        startPage = ((params.getPage() - 1) / params.getPageSize()) * params.getPageSize() + 1;

        endPage = startPage + params.getPageSize() - 1;

        if (endPage > totalPageCount) {
            endPage = totalPageCount;
        }

        limitStart = (params.getPage() - 1) * params.getRecordPerPage();

        existPrevPage = startPage != 1;

        existNextPage = (endPage * params.getRecordPerPage()) < totalRecordCount;
		
	}

}
