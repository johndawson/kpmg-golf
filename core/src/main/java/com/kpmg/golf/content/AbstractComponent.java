package com.kpmg.golf.content;

@Component
public abstract class AbstractComponent {
    protected final ComponentContext context;

    public AbstractComponent(ComponentContext context) {
        this.context = context;
    }
}
