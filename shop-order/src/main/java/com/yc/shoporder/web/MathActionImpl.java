package com.yc.shoporder.web;

import com.yc.shop.web.MathAction;
import org.apache.hadoop.ipc.ProtocolSignature;

/**
 * @program: shop-order
 * @description:
 * @author: 作者
 * @create: 2021-05-12 21:02
 */
public class MathActionImpl implements MathAction {

    @Override
    public int sub(int a, int b) {
        return a - b;
    }

    @Override
    public long getProtocolVersion(String s, long l) {
        return 1;
    }

    @Override
    public ProtocolSignature getProtocolSignature(String s, long l, int i) {
        return null;
    }
}
