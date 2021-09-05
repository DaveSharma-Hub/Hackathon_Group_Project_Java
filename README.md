README File

Required for program:
-JUnit jar files
-SQL connector driver jar file.


Compilation:

To run software, compile all java files. 
Compile Main.java, SQLConnection.java, Furniture.java, Chair.java, Desk.java, 
Filing,java, Lamp.java, cheapestOption.java, input.java,OrderForm.java and SQLConnection.java  


Test:

To compile program, call javac command on input.java with the MySQL driver jar file:
	"javac -cp .;lib\mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/input.java"

To run program, call java command on input:
	"java -cp .;lib\mysql-connector-java-8.0.23.jar edu/ucalgary/ensf409/input"


To compile test programs, call javac on test java files with SQL driver jar file and JUnit jar files:
	"javac -cp .;lib\mysql-connector-java-8.0.23.jar;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar edu/ucalgary/ensf409/SQLConnectionTest.java"

To run test files, run the JUnit run command on compiled test files:
	"java -cp .;lib\mysql-connector-java-8.0.23.jar;lib\junit-4.13.2.jar;lib\hamcrest-core-1.3.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.SQLConnectionTest"





->CheapestOption Test
Compile CheapestOptionTest.java Furniture.java Chair.java Desk.java Filing.java SQLConnection.java and cheapestOption.java 
with the correct directory edu/ucalgary/ensf409 using JUnit 4 jar files, as shown below. 

Compile,
javac -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/system-rules-1.19.0.jar edu/ucalgary/ensf409/CheapestOptionTest.java edu/ucalgary/ensf409/Chair.java edu/ucalgary/ensf409/Desk.java edu/ucalgary/ensf409/Filing.java edu/ucalgary/ensf409/Furniture.java edu/ucalgary/ensf409/Lamp.java edu/ucalgary/ensf409/SQLConnection.java edu/ucalgary/ensf409/cheapestOption.java

then,
java -cp .;lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;lib/system-rules-1.19.0.jar org.junit.runner.JUnitCore edu.ucalgary.ensf409.CheapestOptionTest


Note: .jar files are in a folder names lib and all .java in a folder named edu/ucalgary/ensf409


Video:

Attached as a downloaded MP4 video
If MP4 cannot be open, a follow the youtube link (https://youtu.be/9u4Ghm3pJMs)

