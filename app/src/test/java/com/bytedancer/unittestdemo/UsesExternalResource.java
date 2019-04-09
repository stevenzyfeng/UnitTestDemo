package com.bytedancer.unittestdemo;

import org.junit.*;
import org.junit.rules.*;

// set up an external resource before a test (a file, socket, server, database connection, etc.),
// and guarantee to tear it down afterward.

public class UsesExternalResource {

    public class Server {

        public void connect() {
            // connect server
        }

        public void disconnect() {
            // disconnect server
        }
    }

    public class Client {

        public void run(Server server) {
            // run client
        }
    }

    Server myServer = new Server();

    @Rule
    public final ExternalResource resource = new ExternalResource() {
        @Override
        protected void before() {
            myServer.connect();
        }

        @Override
        protected void after() {
            myServer.disconnect();
        }
    };

    @Test
    public void testFoo() {
        new Client().run(myServer);
    }
}
