package application;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import threadResource.myThread;



@Controller
public class TestController     {
	
	//Get request to load UI
    @GetMapping("/test")
    public String greetingForm(Model model) {
    	
    	TestModule test=new TestModule();
    	
        model.addAttribute("test", test);
        
        
        return "greeting";
    }
    
    //Post request to run tests.
    @PostMapping("/test")
    public String greetingSubmit(@ModelAttribute TestModule test){
    	
    	
       
    	//Fetching tests name.
    	ArrayList<String> tnames= test.getTestNames();
    	//Number of times the user want to run the tests.
    	int times=test.getTimes();
    	//Size of the tests list.
       	int numOfTests=tnames.size();
       	
       	//Printing test names.
       	System.out.println("test names = " + tnames);
       
       //For loop to create threads with the number of tests
    	for (int i = 0; i < numOfTests; i++) {
    		
    		
    		//Fetching browser type
    		String browser=test.browser;
    		//Fetch test name to a string.
  		  	String testName=tnames.get(i);
  		  	//Fetch thread number
    		String threadName = ""+i;
    		//Creating myThread object with the test info, so multiple threads can run
    		myThread tr=new myThread(threadName, testName, times, browser);
    		//inti thread with myThread object and test info.
    		Thread t=new Thread(tr);
    		//Starting the thread (Test)
    		t.start();
    		//Printing current thread name
    		System.out.println("Thread "+ threadName);
    		
    		
    		
   		
			
		}
    	
    	
		
    	
    	
    	

return "result";
    }

}
