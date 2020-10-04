package io.github.manuelernesto.thymeleaf;


import io.github.manuelernesto.thymeleaf.processor.ClassForErrorAttributeTagProcessor;
import io.github.manuelernesto.thymeleaf.processor.MessageElementTagProcessor;
import io.github.manuelernesto.thymeleaf.processor.OrderElementTagProcessor;
import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

import java.util.HashSet;
import java.util.Set;

public class BrewerDialect extends AbstractProcessorDialect {


    public BrewerDialect() {
        super(
                "ME Brewer",
                "brewer",
                StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<>();
        processors.add(new ClassForErrorAttributeTagProcessor(dialectPrefix));
        processors.add(new MessageElementTagProcessor(dialectPrefix));
        processors.add(new OrderElementTagProcessor(dialectPrefix));
        return processors;
    }
}










