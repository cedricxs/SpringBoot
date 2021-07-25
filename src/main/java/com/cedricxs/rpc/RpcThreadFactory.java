package com.cedricxs.rpc;

import java.util.concurrent.ThreadFactory;

/**
 * @author chaxingshuo
 * @date 2021/07/24
 */
public class RpcThreadFactory implements ThreadFactory {

    private static int rpcThreadNum;

    @Override
    public Thread newThread(Runnable r) {
        return new Thread(r, "rpc-thread-" + ++rpcThreadNum);
    }
}
