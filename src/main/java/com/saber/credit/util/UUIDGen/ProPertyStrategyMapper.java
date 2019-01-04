package com.saber.credit.util.UUIDGen;

public class ProPertyStrategyMapper {

    private String propertyName;
    private IdGenerator generator;

    public ProPertyStrategyMapper(String propertyName, IdGenerator generator) {
        super();
        this.propertyName = propertyName;
        this.setGenerator(generator);
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public IdGenerator getGenerator() {
        return generator;
    }

    public void setGenerator(IdGenerator generator) {
        this.generator = generator;
    }

}