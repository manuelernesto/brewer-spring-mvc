package io.github.manuelernesto.controller.page;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageWrapper<T> {

    private Page<T> page;

    public PageWrapper(Page<T> page) {
        super();
        this.page = page;
    }

//    public List<T> getConteudo() {
//        return page.getContent();
//    }

    public boolean isEmpty() {
        return page.getContent().isEmpty();
    }
}
