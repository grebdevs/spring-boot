package se.kits.svedberg.jms.client;

import java.util.Map;

/**
 * Created by Pär Svedberg
 */
public interface JmsClient {
    public void send(String msg);
    public void send(String destination, String msg);
    public Map receive(String queue);
    public void setTimeout(Long timeout);
}
