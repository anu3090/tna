package com.tedwon.flume.client;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;

/**
 * This transport wraps another transport and tracks the number of bytes read
 * and written to the transport.
 *
 * Using atomic longs so there may be some spin contention when concurrent.
 * (need to test).
 */
public class TStatsTransport extends TTransport {
  TTransport trans;

  AtomicLong bytesRead = new AtomicLong();
  AtomicLong bytesWritten = new AtomicLong();

  public TStatsTransport(TTransport trans) {
    this.trans = trans;
  }

  @Override
  public void close() {
    trans.close();
  }

  @Override
  public boolean isOpen() {
    return trans.isOpen();
  }

  @Override
  public void open() throws TTransportException {
    trans.open();
  }

  @Override
  public int read(byte[] buf, int off, int len) throws TTransportException {
    int ret = trans.read(buf, off, len);
    bytesRead.addAndGet(ret);
    return ret;
  }

  @Override
  public void flush() throws TTransportException {
    trans.flush();
  }

  public void write(byte[] buf, int off, int len) throws TTransportException {
    trans.write(buf, off, len);
    bytesWritten.addAndGet(len);
  }

  public long getBytesRead() {
    return bytesRead.get();
  }

  public long getBytesWritten() {
    return bytesWritten.get();
  }

}
