package org.apache.jmeter.protocol.mqtt.client;


import java.util.concurrent.atomic.AtomicLong;
import org.fusesource.hawtbuf.Buffer;
import org.fusesource.hawtbuf.UTF8Buffer;
import org.fusesource.mqtt.client.Listener;

public class ListenerforSubscribe implements Listener {

	public static AtomicLong count= new AtomicLong(0); 
	@Override
	public void onConnected() {
		System.out.println("Subscriber is listening");

	}

	@Override
	public void onDisconnected() {
		System.out.println("Subscriber disabled listening");

	}

	@Override
	public void onPublish(UTF8Buffer topic, Buffer body, Runnable ack) {
//		String message = new String(body.getData());
//		System.out.println("Received: "+message);
		count.getAndIncrement();		
		ack.run();

	}

	@Override
	public void onFailure(Throwable value) {
		System.out.println("Subscriber couldn't set up listener");
		System.out.println(value);
	}

}
