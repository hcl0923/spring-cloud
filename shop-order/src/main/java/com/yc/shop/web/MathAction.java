package com.yc.shop.web;

import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.VersionedProtocol;

/**
 * 定义接口
 */
public interface MathAction extends VersionedProtocol {
    public static final long versionID = 1L;

    public int sub(int a, int b);

    @Override
    public long getProtocolVersion(String s, long l);

    @Override
    public ProtocolSignature getProtocolSignature(String s, long l, int i);

}
