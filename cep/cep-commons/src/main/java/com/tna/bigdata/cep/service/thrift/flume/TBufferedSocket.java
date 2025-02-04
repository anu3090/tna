/**
 * Licensed to Cloudera, Inc. under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  Cloudera, Inc. licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.tna.cep.service.thrift.flume;

import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransportException;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.net.Socket;

/**
 * Simple wrapper around {@link org.apache.thrift.transport.TSocket} which adds buffering to the input and
 * output streams.
 */
public class TBufferedSocket extends TSocket {

  public TBufferedSocket(Socket socket) throws TTransportException {
    super(socket);
    wrapStreams();
  }

  public TBufferedSocket(String host, int port, int timeout) {
    super(host, port, timeout);
    wrapStreams();
  }

  public TBufferedSocket(String host, int port) {
    super(host, port);
    wrapStreams();
  }

  @Override
  public void open() throws TTransportException {
    super.open();
    wrapStreams();
  }

  private void wrapStreams() {
    if (!isOpen() || inputStream_ == null) {
      return;
    }
    inputStream_ = new BufferedInputStream(inputStream_);
    outputStream_ = new BufferedOutputStream(outputStream_);
  }

}
