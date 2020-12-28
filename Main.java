import java.util.*;
import java.io.FileWriter; 
import java.nio.charset.*;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.FileNotFoundException;
public class Main {

    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
         File Obj1 = new File("G:\\studentdata.txt");
        List<Student> list=new ArrayList<>();
        
        try
            {
                File myObj = new File("G:\\studentdata.txt");
                Scanner myReader = new Scanner(myObj);
                while (myReader.hasNextLine())
                    {
                        String data = myReader.nextLine();
                        String arr[]=data.split(",");
                        list.add(new Student(arr[0], arr[1], Integer.parseInt(arr[2]) ,arr[3]));
                    }
                    myReader.close();
                }
        catch (FileNotFoundException e)
            {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            //debugging purpose
//         for(Student s:list) {
//             System.out.println(s.id + " " + s.name+" "+s.age+" "+s.city+"; ");
//         }
        
        while(true) {
            System.out.println("press respective number for the respective action 1.ADD , 2.Modify , 3.Delete , 4.View, 5.Save and Quit:");
            int n=in.nextInt();
            if(n==1) {
                System.out.println("Enter name,age,city :");

                String str=in.nextLine();
                while(str.equals("")) {
                    str = in.nextLine();
                }
                String arr[]=str.split(",");
                String id = RandomString.createRandomString(6);
                System.out.println("Added successfully with a new id: "+id); //Remove before submission
                list.add(new Student(id, arr[0], Integer.parseInt(arr[1]) ,arr[2]));
            }
            if(n==2){
                System.out.println("to update enter in this format id,name,age,city :");
                String str=in.nextLine();
                while(str.equals("")) {
                    str = in.nextLine();
                }
                String arr[]=str.split(",");
                
                String idf = arr[0];
                String nm = arr[1];
                Integer ag = Integer.parseInt(arr[2]);
                String ct = arr[3];
                int pos = -1,i;
                for(i=0;i<list.size();i++)
                    {
                        String st = list.get(i).id;
                        if(idf.equals(st)){
                            pos = i;
                            break;
                    }
                }
                if(pos==-1){
                    System.out.println("Element not found");
                } else{
                    list.set(pos,new Student(idf,nm,ag,ct));
                }
            }
            
            if(n == 3){
                System.out.println("Enter id to be deleted:");
                String idf = in.nextLine();
                while(idf.equals("")) {
                    idf = in.nextLine();
                }
                int pos = -1,i;
                for(i=0;i<list.size();i++)
                    {
                        String st = list.get(i).id;
                        if(idf.equals(st)){
                            pos = i;
                            break;
                    }
                }
            
                if(pos == -1){
                    System.out.println("Element not found!");
                } else{
                    list.remove(pos);
                }
            }
            
            if(n==4) {
            System.out.println("Enter id to be searched:");
            String idf = in.nextLine();
                while(idf.equals("")) {

                    idf = in.nextLine();

                }
            int pos = -1,i;
            for(i=0;i<list.size();i++)
            {
                String st = list.get(i).id;
                if(idf.equals(st)){
                    pos = i;
                    break;
                }
            }
            
            if(pos == -1){
                System.out.println("Element not found!");
            } else{
                String nm = list.get(pos).name;
                Integer ag = list.get(pos).age;
                String cty = list.get(pos).city;
                System.out.println("Name:" + nm + " Age:" + ag + " City:" + cty);
                }
            }
            if(n==5)
            {
               try
                    {
                        File myObj = new File("G:\\studentdata.txt");
                        FileWriter myWriter = new FileWriter("G:\\studentdata.txt");
                        //(myobj.createNewFile() This method returns a boolean value true if the file was successfully created, and false if the file already exists
                        if (myObj.createNewFile())
                        {
                            continue;
                        }
                        //writing the highscore into the text file
                        
                        int i=0;
                        for(i=0;i<list.size();i++){
                            String idf = list.get(i).id;
                            String nm = list.get(i).name;
                            Integer ag = list.get(i).age;
                            String cty = list.get(i).city;
                            
                            String finstr = idf+","+nm+","+ag+","+cty;
                            myWriter.write(finstr);
                            myWriter.write(System.lineSeparator());
                        }
                        myWriter.close();
                    }
                    catch (IOException e)
                    {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                    System.out.println("Save and Quit:");
                    break;
                }
            }
        }
    }
class RandomString { 
  
   static String createRandomString(int n) 
    {
        String randomString = "1234567890qwertyuiopasdfghjklzxcvbnm"; 
        StringBuilder obj = new StringBuilder(n); 
        for (int i = 0; i < n; i++) 
        {   int x = (int)(randomString.length() * Math.random());
            obj.append(randomString.charAt(x)); 
        }
         return obj.toString(); 
    } 
}

class Student{
    String id;
    String name;
    int age;
    String city;
    Student(String id,String name,int age,String city){
        this.id=id;
        this.name=name;
        this.age=age;
        this.city=city;
    }
}
