package com.meli.ipcontextinfo.command;

/**
 *
 * @author VAL13448
 * @param <T> the Value to be return by the execute command
 */
public interface Command<T> {
    
    /**
     *
     * @return T 
     * 
     */
    T execute();
    
}
