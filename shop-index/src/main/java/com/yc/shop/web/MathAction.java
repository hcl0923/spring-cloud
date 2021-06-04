package com.yc.shop.web;

import org.apache.hadoop.ipc.VersionedProtocol;

/**
 * @program:
 * @description:定义接口
 * @author: 作者
 * @create: 2021-05-09 09:23
 */
public interface MathAction extends VersionedProtocol {
    public static final long versionID = 1L;

    int sub(int a, int b);

}
