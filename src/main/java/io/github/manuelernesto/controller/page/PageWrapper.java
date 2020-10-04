package io.github.manuelernesto.controller.page;

import org.springframework.data.domain.Page;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PageWrapper<T> {

    private Page<T> page;
    private UriComponentsBuilder uriBuilder;

    public PageWrapper(Page<T> page, HttpServletRequest httpServletRequest) {
        super();
        this.page = page;
        this.uriBuilder = ServletUriComponentsBuilder.fromRequest(httpServletRequest);
    }

    public List<T> getContent() {
        return page.getContent();
    }

    public int getCurrent() {
        return page.getNumber();
    }

    public boolean isEmpty() {
        return page.getContent().isEmpty();
    }

    public int getNumber() {
        return page.getNumber();
    }

    public int getTotalPages() {
        return page.getTotalPages();
    }

    public boolean isLast() {
        return page.isLast();
    }

    public boolean isFirst() {
        return page.isFirst();
    }

    public String urlToPage(int page) {
        return uriBuilder.replaceQueryParam("page", page)
                .build(true)
                .encode()
                .toUriString();
    }

    public String orderUrl(String field) {
        UriComponentsBuilder uriBuilderOrder = UriComponentsBuilder
                .fromUriString(uriBuilder.build(true).encode().toUriString());

        return uriBuilderOrder.replaceQueryParam("sort", field).build(true).encode().toUriString();
    }

}















