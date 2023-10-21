package Main;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        // Display how the app works to the user
        new TaskManager();
        // Create an empty list/array of tasks in memory
        ArrayList<Task> tasks = new ArrayList<Task>();
        //Get user input
        System.out.print("Enter your choice: ");
        Scanner userChoice = new Scanner(System.in);
        boolean validChoice = false;
        while (validChoice == false){
            try{
                int taskAction = userChoice.nextInt();
                userChoice.nextLine();
                validChoice = true;
                while (taskAction != 5){
                    if (taskAction == 1){
                        System.out.print("Enter task title: ");
                        String title = userChoice.nextLine();
                        System.out.print("Enter task description: ");
                        String description = userChoice.nextLine();
                        new TaskManager(tasks , title , description);
                    }else if(taskAction == 2){
                        System.out.print("Enter task ID to mark as completed: ");
                        int id = userChoice.nextInt();
                        userChoice.nextLine();
                        new TaskManager(tasks,id,2);
                    }else if(taskAction == 3){
                        new TaskManager(tasks);
                    }else if(taskAction == 4){
                        System.out.print("Enter task ID to delete: ");
                        int deleteId = userChoice.nextInt();
                        userChoice.nextLine();
                        new TaskManager(tasks,deleteId,4);
                    }
                    System.out.println(" ");
                    new TaskManager();
                    System.out.print("Enter your choice: ");
                    taskAction = userChoice.nextInt();
                    userChoice.nextLine();
                }
            }catch(Exception exception){
                validChoice = false;
                System.out.println("Invaild choice");
                System.out.print("Enter your choice: ");
                userChoice.nextLine();
            }
        }
         
         userChoice.close();
         System.exit(0);

    }

   static class Task{
        int id;
        String title;
        String description;
        String completionStatus;

        Task(int id , String title ,String description, String completionStatus){
            this.id = id;
            this.title = title;
            this.description = description;
            this.completionStatus = completionStatus;
        }
    }

   static class TaskManager{
        // Display how the app works to the user
        TaskManager(){
            System.out.println("Task Manager Applicatiion");
            System.out.println("-------------------------");
            System.out.println("1. Add a task");
            System.out.println("2. Mark a task as completed");
            System.out.println("3. List tasks");
            System.out.println("4. Delete a task");
            System.out.println("5. Exit");
        }

        // Add a Task
        TaskManager(ArrayList<Task> tasks, String title , String description){
                Task newTask = new Task(tasks.size()+ 1, title, description, "[ ]");
                tasks.add(newTask);
                System.out.println("Task added successfully");
        }
        // Mark Task as complete
        TaskManager(ArrayList<Task> tasks , int id,int taskAction){
            if(taskAction == 2){
                for (int i = 0; i < tasks.size(); i++) {
                    if(tasks.get(i).id == id){
                        tasks.get(i).completionStatus = "[X]";
                        System.out.println("Task marked as completed");
                        break;
                    }else if (i+1 == tasks.size() && tasks.get(i).id != id) {
                       System.out.println("Task not found");
                    }
                }
             // delete a Task    
            }else if(taskAction == 4){
                for (int i = 0; i < tasks.size(); i++) {
                    if(tasks.get(i).id == id){
                        tasks.remove(i);
                        System.out.println("Task delelted Successfully");
                        break;
                    }else if(i+1 == tasks.size() && tasks.get(i).id != id){
                       System.out.println("Task not found");
                    }
                }
            } 
        }
        // list all Tasks 
        TaskManager(ArrayList<Task> tasks){
            if(tasks.size() > 0){
                System.out.println("Tasks:");
                for (int i = 0; i < tasks.size(); i++) {
                    System.out.println(tasks.get(i).completionStatus + " " + tasks.get(i).id + ": " + tasks.get(i).title);
                }   
            }else{
                System.out.println("No tasks found");
            }  
        }
    }
}
