package io.github.manuelernesto.thymeleaf.processor;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.model.IModel;
import org.thymeleaf.model.IModelFactory;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractElementTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

public class MessageElementTagProcessor extends AbstractElementTagProcessor {

    private static final String NAME_TAG = "message";
    private static final int PRECEDENCE = 1000;

    public MessageElementTagProcessor(String dialectPrefix) {
        super(
                TemplateMode.HTML,
                dialectPrefix,
                NAME_TAG,
                true,
                null,
                false,
                PRECEDENCE
        );
    }


    @Override
    protected void doProcess(
            ITemplateContext context,
            IProcessableElementTag tag,
            IElementTagStructureHandler structureHandler) {

        IModelFactory modelFactory = context.getModelFactory();
        IModel model = modelFactory.createModel();

        model.add(modelFactory.createStandaloneElementTag("th:block", "th:include", "fragments/MensagemSucesso"));
        model.add(modelFactory.createStandaloneElementTag("th:block", "th:include", "fragments/MensagensErroValidaco"));

        structureHandler.replaceWith(model, true);
    }
}
