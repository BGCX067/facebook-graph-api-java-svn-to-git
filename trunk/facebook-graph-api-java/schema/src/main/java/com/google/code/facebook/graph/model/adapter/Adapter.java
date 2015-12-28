/*
 * 
 */
package com.google.code.facebook.graph.model.adapter;

/**
 * The Interface Adapter.
 */
public interface Adapter<Adaptee> {

    /**
     * Adapt from.
     * 
     * @param adaptee the adaptee
     */
    public void adaptFrom(Adaptee adaptee);

    /**
     * Adapt to.
     * 
     * @return the adaptee
     */
    public Adaptee adaptTo();
}
