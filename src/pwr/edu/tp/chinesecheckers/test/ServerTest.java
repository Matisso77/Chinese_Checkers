package pwr.edu.tp.chinesecheckers.test;

import static org.junit.Assert.*;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import org.junit.After;
import org.junit.Test;
import pwr.edu.tp.chinesecheckers.Server;

public class ServerTest {
	@After
	public void stopServer() {
		Server.getInstance().finalize();
		Server.resetInstance();
	}

	@Test
	public void initTest() {
		assertNotNull(Server.getInstance());
	}

	@Test
	public void listeningTest1() {
		Server.getInstance().startListening();
		try {
			Socket socket = new Socket("localhost", 8901);
			socket.close();
		} catch (Exception e) {
			fail();
		}
	}

	@Test(expected = IOException.class)
	public void listeningTest2() throws IOException {
		Socket socket = new Socket("localhost", 8901);
		socket.close();
	}

	@Test
	public void allocatingTest1() {
		Thread thread1 = new Thread() {
			public void run() {
				Server.getInstance().startListening();
				Server.getInstance().startAllocating();
			}
		};
		thread1.start();
		try {
			Socket socket = new Socket("localhost", 8901);
			thread1.interrupt();
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(6);
			out.writeObject("YES");
			out.flush();
			Object obj = in.readObject();
			assertTrue(obj instanceof String);
		} catch (IOException | ClassNotFoundException e) {
		}
	}

	@Test
	public void allocatingTest2() {
		Thread thread1 = new Thread() {
			public void run() {
				Server.getInstance().startListening();
				Server.getInstance().startAllocating();
			}
		};
		thread1.start();
		try {
			Socket socket = new Socket("localhost", 8901);
			thread1.interrupt();
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(4);
			out.writeObject("YES");
			out.flush();
			Object obj = in.readObject();
			assertTrue(obj instanceof String);
		} catch (IOException | ClassNotFoundException e) {
		}
	}

	@Test
	public void allocatingTest3() {
		Thread thread1 = new Thread() {
			public void run() {
				Server.getInstance().startListening();
				Server.getInstance().startAllocating();
			}
		};
		thread1.start();
		try {
			Socket socket = new Socket("localhost", 8901);
			thread1.interrupt();
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(3);
			out.writeObject("YES");
			out.flush();
			Object obj = in.readObject();
			assertTrue(obj instanceof String);
		} catch (IOException | ClassNotFoundException e) {
		}
	}

	@Test
	public void allocatingTest4() {
		Thread thread1 = new Thread() {
			public void run() {
				Server.getInstance().startListening();
				Server.getInstance().startAllocating();
			}
		};
		thread1.start();
		try {
			Socket socket = new Socket("localhost", 8901);
			thread1.interrupt();
			ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
			ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
			out.writeObject(2);
			out.writeObject("YES");
			out.flush();
			Object obj = in.readObject();
			assertTrue(obj instanceof String);
		} catch (IOException | ClassNotFoundException e) {
		}
	}

	@Test
	public void allocatingTest5() {
		Thread thread1 = new Thread() {
			public void run() {
				Server.getInstance().startListening();
				Server.getInstance().startAllocating();
			}
		};
		thread1.start();
		try {
			Socket socket1 = new Socket("localhost", 8901);
			Socket socket2 = new Socket("localhost", 8901);
			thread1.interrupt();
			ObjectInputStream in1 = new ObjectInputStream(socket1.getInputStream());
			ObjectOutputStream out1 = new ObjectOutputStream(socket1.getOutputStream());
			out1.writeObject(2);
			out1.writeObject("NO");
			out1.flush();
			ObjectInputStream in2 = new ObjectInputStream(socket2.getInputStream());
			ObjectOutputStream out2 = new ObjectOutputStream(socket2.getOutputStream());
			out2.writeObject(2);
			out2.writeObject("NO");
			out2.flush();
			Object obj = in1.readObject();
			assertTrue(obj instanceof String);
			obj = in2.readObject();
			assertTrue(obj instanceof String);
		} catch (IOException | ClassNotFoundException e) {
		}
	}

	@Test
	public void allocatingTest6() {
		Thread thread1 = new Thread() {
			public void run() {
				Server.getInstance().startListening();
				Server.getInstance().startAllocating();
			}
		};
		thread1.start();
		try {
			Socket socket1 = new Socket("localhost", 8901);
			Socket socket2 = new Socket("localhost", 8901);
			Socket socket3 = new Socket("localhost", 8901);
			thread1.interrupt();
			ObjectInputStream in1 = new ObjectInputStream(socket1.getInputStream());
			ObjectOutputStream out1 = new ObjectOutputStream(socket1.getOutputStream());
			out1.writeObject(3);
			out1.writeObject("NO");
			out1.flush();
			ObjectInputStream in2 = new ObjectInputStream(socket2.getInputStream());
			ObjectOutputStream out2 = new ObjectOutputStream(socket2.getOutputStream());
			out2.writeObject(3);
			out2.writeObject("NO");
			out2.flush();
			ObjectInputStream in3 = new ObjectInputStream(socket3.getInputStream());
			ObjectOutputStream out3 = new ObjectOutputStream(socket3.getOutputStream());
			out3.writeObject(3);
			out3.writeObject("NO");
			out3.flush();
			Object obj = in1.readObject();
			assertTrue(obj instanceof String);
			obj = in2.readObject();
			assertTrue(obj instanceof String);
			obj = in3.readObject();
			assertTrue(obj instanceof String);
		} catch (IOException | ClassNotFoundException e) {
		}
	}

	@Test
	public void allocatingTest7() {
		Thread thread1 = new Thread() {
			public void run() {
				Server.getInstance().startListening();
				Server.getInstance().startAllocating();
			}
		};
		thread1.start();
		try {
			Socket socket1 = new Socket("localhost", 8901);
			Socket socket2 = new Socket("localhost", 8901);
			Socket socket3 = new Socket("localhost", 8901);
			Socket socket4 = new Socket("localhost", 8901);
			thread1.interrupt();
			ObjectInputStream in1 = new ObjectInputStream(socket1.getInputStream());
			ObjectOutputStream out1 = new ObjectOutputStream(socket1.getOutputStream());
			out1.writeObject(4);
			out1.writeObject("NO");
			out1.flush();
			ObjectInputStream in2 = new ObjectInputStream(socket2.getInputStream());
			ObjectOutputStream out2 = new ObjectOutputStream(socket2.getOutputStream());
			out2.writeObject(4);
			out2.writeObject("NO");
			out2.flush();
			ObjectInputStream in3 = new ObjectInputStream(socket3.getInputStream());
			ObjectOutputStream out3 = new ObjectOutputStream(socket3.getOutputStream());
			out3.writeObject(4);
			out3.writeObject("NO");
			out3.flush();
			ObjectInputStream in4 = new ObjectInputStream(socket4.getInputStream());
			ObjectOutputStream out4 = new ObjectOutputStream(socket4.getOutputStream());
			out4.writeObject(4);
			out4.writeObject("NO");
			out4.flush();
			Object obj = in1.readObject();
			assertTrue(obj instanceof String);
			obj = in2.readObject();
			assertTrue(obj instanceof String);
			obj = in3.readObject();
			assertTrue(obj instanceof String);
			obj = in4.readObject();
			assertTrue(obj instanceof String);
		} catch (IOException | ClassNotFoundException e) {
		}
	}

	@Test
	public void allocatingTest8() {
		Thread thread1 = new Thread() {
			public void run() {
				Server.getInstance().startListening();
				Server.getInstance().startAllocating();
			}
		};
		thread1.start();
		try {
			Socket socket1 = new Socket("localhost", 8901);
			Socket socket2 = new Socket("localhost", 8901);
			Socket socket3 = new Socket("localhost", 8901);
			Socket socket4 = new Socket("localhost", 8901);
			Socket socket5 = new Socket("localhost", 8901);
			Socket socket6 = new Socket("localhost", 8901);
			thread1.interrupt();
			ObjectInputStream in1 = new ObjectInputStream(socket1.getInputStream());
			ObjectOutputStream out1 = new ObjectOutputStream(socket1.getOutputStream());
			out1.writeObject(6);
			out1.writeObject("NO");
			out1.flush();
			ObjectInputStream in2 = new ObjectInputStream(socket2.getInputStream());
			ObjectOutputStream out2 = new ObjectOutputStream(socket2.getOutputStream());
			out2.writeObject(6);
			out2.writeObject("NO");
			out2.flush();
			ObjectInputStream in3 = new ObjectInputStream(socket3.getInputStream());
			ObjectOutputStream out3 = new ObjectOutputStream(socket3.getOutputStream());
			out3.writeObject(6);
			out3.writeObject("NO");
			out3.flush();
			ObjectInputStream in4 = new ObjectInputStream(socket4.getInputStream());
			ObjectOutputStream out4 = new ObjectOutputStream(socket4.getOutputStream());
			out4.writeObject(6);
			out4.writeObject("NO");
			out4.flush();
			ObjectInputStream in5 = new ObjectInputStream(socket5.getInputStream());
			ObjectOutputStream out5 = new ObjectOutputStream(socket5.getOutputStream());
			out5.writeObject(6);
			out5.writeObject("NO");
			out5.flush();
			ObjectInputStream in6 = new ObjectInputStream(socket6.getInputStream());
			ObjectOutputStream out6 = new ObjectOutputStream(socket6.getOutputStream());
			out6.writeObject(6);
			out6.writeObject("NO");
			out6.flush();
			Object obj = in1.readObject();
			assertTrue(obj instanceof String);
			obj = in2.readObject();
			assertTrue(obj instanceof String);
			obj = in3.readObject();
			assertTrue(obj instanceof String);
			obj = in4.readObject();
			assertTrue(obj instanceof String);
			obj = in5.readObject();
			assertTrue(obj instanceof String);
			obj = in6.readObject();
			assertTrue(obj instanceof String);
		} catch (IOException | ClassNotFoundException e) {
		}
	}
}