package com.alibaba.tac.biz.processor;

import com.alibaba.tac.sdk.common.TacResult;
import com.alibaba.tac.sdk.domain.Context;
import com.alibaba.tac.sdk.factory.TacInfrasFactory;
import com.alibaba.tac.sdk.handler.TacHandler;
import com.alibaba.tac.sdk.infrastracture.TacLogger;
import com.tmall.itemcenter.ItemDO;
import com.tmall.itemcenter.TmallItemService;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jinshuan.li
 */
public class HelloWorldTac implements TacHandler<Object> {

    /**
     * get the logger service
     */
    private TacLogger tacLogger = TacInfrasFactory.getLogger();

    private TmallItemService tmallItemService = TacInfrasFactory.getServiceBean(TmallItemService.class);

    /**
     * implement a class which implements TacHandler interface {@link TacHandler}
     *
     * @param context
     * @return
     * @throws Exception
     */

    @Override
    public TacResult<Object> execute(Context context) throws Exception {

        // the code
        tacLogger.info("Hello World22");

        Map<String, Object> data = new HashMap<>();
        data.put("name", "hellotac");
        data.put("platform", "iPhone");
        data.put("clientVersion", "7.0.2");
        data.put("userName", "tac-userName");

        ItemDO item = tmallItemService.getItem(1L);
        data.put("item", item);
        return TacResult.newResult(data);
    }
}
