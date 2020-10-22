package io.github.manuelernesto.controller.page;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.web.util.UriComponentsBuilder;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public class PageWrapper<T> {

    private final Page<T> page;
    private final UriComponentsBuilder uriBuilder;

    public PageWrapper(Page<T> page, HttpServletRequest httpServletRequest) {
        super();
        this.page = page;
        String httpUrl = httpServletRequest.getRequestURL().append(
                httpServletRequest.getQueryString() != null ? "?" + httpServletRequest.getQueryString() : ""
        ).toString().replaceAll("\\+", "%20");
        this.uriBuilder = UriComponentsBuilder.fromHttpUrl(httpUrl);
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


        String valueSorted = String.format("%s,%s", field, invertOrder(field));

        return uriBuilderOrder.replaceQueryParam("sort", valueSorted).build(true).encode().toUriString();
    }

    private String invertOrder(String field) {
        String direction = "asc";

        Order order = page.getSort() != null ? page.getSort().getOrderFor(field) : null;
        if (order != null)
            direction = Sort.Direction.ASC.equals(order.getDirection()) ? "desc" : "asc";

        return direction;
    }

    public boolean descendent(String field) {
        return invertOrder(field).equals("asc");
    }

    public boolean ordered(String field) {
        Order order = page.getSort() != null ? page.getSort().getOrderFor(field) : null;

        if (order == null)
            return false;


        return page.getSort().getOrderFor(field) != null ? true : false;
    }
}










































