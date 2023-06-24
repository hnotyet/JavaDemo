package com.engine.struct;

/**
 * @auther yest
 * @date 2023/3/9 07:36
 */
public abstract class AbstractProcessor<P,C,R> implements Processor<P,C,R>{

    @Override
    public void doProcess(P param, C context, R result) {

    }
}
