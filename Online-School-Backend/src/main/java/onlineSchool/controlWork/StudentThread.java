package onlineSchool.controlWork;

import onlineSchool.models.Students;

import java.util.Random;

public class StudentThread extends Thread {
    private Students student;
    private int taskNumber;
    private int executionTime;
    private boolean isFinished;

    public String fullName() {
        return student.getStudentName() + " " + student.getStudentLastName();
    }

    public StudentThread(Students student, int taskNumber) {
        this.student = student;
        this.setTaskNumber(taskNumber);
        this.isFinished = false;
    }

    @Override
    public void run() {
        Random rand = new Random();
        int executionTime = rand.nextInt(7) + 7;
        try {
            Thread.sleep(executionTime * 1000);
            System.out.println(student.getStudentName() + " " + student.getStudentLastName() +
                    " виконав завдання " + getTaskNumber() + " за " + executionTime + " секунд");
            this.executionTime = executionTime;
            this.isFinished = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public int getExecutionTime() {
        return executionTime;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public int getTaskNumber() {
        return taskNumber;
    }

    public void setTaskNumber(int taskNumber) {
        this.taskNumber = taskNumber;
    }

}

