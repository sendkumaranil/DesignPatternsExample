# DesignPatternsExample
<h4>Design Pattern Examples in Java Language</h4>
<hr>

<b>Step-1:</b><br> create JavaProject and name it DesignPatternExample<br>
<b>Step-2:</b><br> create following packages and classes

<ul>
<li>/DesignPatternExample/src/com/designpattern/factory/ShapeProvider.java (<b>Factory Design Pattern example</b>)</li>
<li>/DesignPatternExample/src/com/designpattern/abstractfactory/FactoryProducer.java (<b>Abstract Factory Design Pattern example</b>)</li>
<li>/DesignPatternExample/src/com/designpattern/facade/ComputerStart.java (<b>Facade Design pattern example</b>)</li>
<li>/DesignPatternExample/src/com/designpattern/facade/ShapeMaker.java (<b>Facade Design pattern example</b>)</li>
<li>/DesignPatternExample/src/com/designpattern/singleton/EagerSingleton.java (<b>Singleton Design Pattern example</b>)</li>
<li>/DesignPatternExample/src/com/designpattern/singleton/EnumSingleton.java (<b>Singleton Design Pattern example</b>)</li>
<li>/DesignPatternExample/src/com/designpattern/singleton/LazySingleton.java (<b>Singleton Design Pattern example</b>)</li>
</ul>

<b>Proxy Pattern:</b>

Proxy pattern intent is to “Provide a surrogate or placeholder for another object to control access to it”. 
The definition itself is very clear and proxy pattern is used when we want to provide controlled access of a functionality.

Let’s say we have a class that can run some command on the system. 
Now if we are using it, its fine but if we want to give this program to a client application, 
it can have severe issues because client program can issue command to 
delete some system files or change some settings that you don’t want.

Superclass:

		public interface CommandExecutor {

			public void runCommand(String cmd) throws Exception;
		}
		
Subclass:

		public class CommandExecutorImpl implements CommandExecutor {

			@Override
			public void runCommand(String cmd) throws IOException {
						//some heavy implementation
				Runtime.getRuntime().exec(cmd);
				System.out.println("'" + cmd + "' command executed.");
			}
		}

Proxy Subclass:

		public class CommandExecutorProxy implements CommandExecutor {

			private boolean isAdmin;
			private CommandExecutor executor;
			
			public CommandExecutorProxy(String user, String pwd){
				if("Pankaj".equals(user) && "J@urnalD$v".equals(pwd)) isAdmin=true;
				executor = new CommandExecutorImpl();  //using subclass object to controll.
			}
			
			@Override
			public void runCommand(String cmd) throws Exception {
				if(isAdmin){
					executor.runCommand(cmd);
				}else{
					if(cmd.trim().startsWith("rm")){
						throw new Exception("rm command is not allowed for non-admin users.");
					}else{
						executor.runCommand(cmd);
					}
				}
			}
		}
Demo:

		public class ProxyPatternTest {

			public static void main(String[] args){
				CommandExecutor executor = new CommandExecutorProxy("Pankaj", "wrong_pwd");
				try {
					executor.runCommand("ls -ltr");
					executor.runCommand(" rm -rf abc.pdf");
				} catch (Exception e) {
					System.out.println("Exception Message::"+e.getMessage());
				}
			}
		}
		
Output:
'ls -ltr' command executed.
Exception Message::rm command is not allowed for non-admin users.
