package com.engine.struct;

/**
 * @auther yest
 * @date 2023/3/9 07:30
 */
public interface Processor<P,C,R> {

    void doProcess(P param,C context,R result);

    boolean support(P param,C context,R result);

}
