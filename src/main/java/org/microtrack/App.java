package org.microtrack;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class App {

    public static void main( String[] args )
    {
        Manager manager = new Manager("Microtrack", "1234567890", "you are awesome");
        System.out.println(manager.getDataMessage());
    }
}
