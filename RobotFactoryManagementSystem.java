import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Robot{
     public String id;

    public Robot(String id){
        this.id = id;
    }

    public void Performtask(){
        System.out.println("-----------");
    }

    @Override
    public String toString() {
        return "Robot ID: " + id;
    }

}

class PaintingRobot extends Robot{
    
    public PaintingRobot(String id){
        super(id);
    }

    @Override
    public void Performtask(){
        super.Performtask();
        System.out.println("PaintingRobot - ID: " + id + " is Painting components ");
        try {
            Thread.sleep(1500); 
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}

class WieldingRobot extends Robot{
     
    public WieldingRobot(String id){
        super(id);
    }

    @Override
    public void Performtask(){
        super.Performtask();
        System.out.println("WeldingRobot - ID: " + id + " is Welding metal parts");
       
    }
}

class Worker extends Thread{
    public String name;
    public String robottype;
    public int count=0;
    public boolean running = true;
    
    public Worker(String name,String robottype){
        this.name = name;
        this.robottype = robottype;
    }

    public void run(){
         
             for(int i = 1 ; i <= 4 ; i++){
            try{
                Thread.sleep(100);
                System.out.println(name + " is building " + robottype + "[robots made: "+ count +"]");
                count++;
            }
            catch(InterruptedException e){
                System.out.println(e);
            }
             }
        

        System.out.println(name + " has completed his tasks [Robots made:" + count + "  Robot type: "+ robottype +"]");
    }


}


class RobotFactory {
    private String name;
    private List<Robot> robots;
    
    public RobotFactory(String name) {
        this.name = name;
        this.robots = new ArrayList<>();
    }
    
    public void addRobot(Robot robot) {
        robots.add(robot);
    }

    public List<Robot> getRobots() {
        return robots;
    }
}

public class RobotFactoryManagementSystem {
    
    public static void main(String[] args) {
         RobotFactory factory = new RobotFactory("Advanced Robotics Inc.");
            
            // Create and equip robots
            Robot robot1 = new PaintingRobot("R2-D2");
            Robot robot2 = new WieldingRobot("WALL-E");
            Robot robot3 = new PaintingRobot("C-3PO");
        
            
            factory.addRobot(robot1);
            factory.addRobot(robot2);
            factory.addRobot(robot3);
   
            Worker w1 = new Worker("bob","paintingrobot");
            Worker w2 = new Worker("mick","wieldingrobot");

            Scanner src = new Scanner(System.in);
          
            while(true){
            System.out.println("\n=== Robot Control Panel ===");
                System.out.println("1. List all robots");
                System.out.println("2. Assign task to robot");
                System.out.println("3. Assign task to Workers");
                System.out.println("4. Exit");
                System.out.print("Choose option: ");

                int choice = src.nextInt();

                switch(choice){
                    case 1: 
                    System.out.println("\nAvailable Robots:");
                    for (Robot robot : factory.getRobots()) {
                        System.out.println(robot);
                    }
                    break;

                    case 2:
                    System.out.println("\nAssigning tasks:");
                    robot1.Performtask();
                    robot2.Performtask();
                    robot3.Performtask();
                    break;

                    case 3:
                    System.out.println("\nAssigning tasks:");
                    w1.start();
                    w2.start();
                    try {
                        w1.join();  // Wait for w1 to finish
                        w2.join();  // Wait for w2 to finish
                    } catch (InterruptedException e) {
                        System.out.println("Main thread interrupted while waiting for workers.");
                    }
                    break;

                    case 4:
                    System.out.println("\n Exiting.....");
                    src.close();
                        return;
                        
                    default:
                        System.out.println("Invalid option!");
        
                }
            }
    }
}
