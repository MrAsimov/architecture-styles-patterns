/*
 * MIT License
 *
 * Copyright (c) 2017 Andy Holst
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.design.pipefilters.filters;

import com.design.component.Component;
import com.design.component.Connector;
import com.design.component.Port;
import com.design.pipefilters.pipe.Pipe;

public class ClientComponent extends Thread implements Component {

    private final Pipe pipe;
    private final Port port;

    public ClientComponent(Pipe pipe, Port port) {
        this.pipe = pipe;
        this.port = port;
    }

    @Override
    public void run() {
        int counter = 0;
        while (counter < 11) {
            port.writeMessage(Integer.toString(counter).getBytes(), pipe);

            ++counter;
        }
        pipe.setPipeMessagePrepared(true);
    }

    public boolean isPipeMessagePrepared() {
        return pipe.isPipeMessagePrepared();
    }

    @Override
    public Connector getConnector() {
        return pipe;
    }

    @Override
    public Port getPort() {
        return port;
    }
}
