package com.engine.struct;

/**
 * @auther yest
 * @date 2023/3/9 07:52
 */
public interface FlowEngine<P,C,R> {

    void initProcessor();


    R start(P param,C context);




}
