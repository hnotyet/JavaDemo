package com.engine.struct;

import com.engine.struct.dto.Context;
import com.engine.struct.dto.Param;
import com.engine.struct.dto.Result;

import java.util.LinkedList;

/**
 * @auther yest
 * @date 2023/3/9 07:56
 */
public class MaterialQueryEngine implements FlowEngine<Param, Context, Result> {

    LinkedList list = new LinkedList<Processor>();

    @Override
    public void initProcessor() {
        list.add(new Validator());
        list.add(new Injector());
    }

    @Override
    public Result start(Param param, Context context) {
        




        return null;
    }
}
