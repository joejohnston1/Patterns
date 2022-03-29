package com.jjohnston.structural.decorator;

/**
 * The base decorator class follows the same interface as the
 * other components. The primary purpose of this class is to
 * define the wrapping interface for all concrete decorators.
 * The default implementation of the wrapping code might include
 * a field for storing a wrapped component and the means to
 * initialize it.
 */
public class DataSourceDecorator implements DataSource {

    private DataSource wrappee;

    public DataSourceDecorator(DataSource wrappee) {
        this.wrappee = wrappee;
    }

    /**
     * The base decorator simply delegates all work to the
     * wrapped component. Extra behaviors can be added in
     * concrete decorators.
     *
     * @param data
     */
    @Override
    public void writeData(String data) {
        wrappee.writeData(data);
    }

    /**
     * Concrete decorators may call the parent implementation of
     * the operation instead of calling the wrapped object
     * directly. This approach simplifies extension of decorator
     * classes.
     * @return
     */
    @Override
    public String readData() {
        return wrappee.readData();
    }
}
