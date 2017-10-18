package org.sandec.habitoaster.model;

public class Habit {

    public String habitName;
    public int numberOfDays;
    public boolean notify;
    public String notificationTime;
    public String createdDate;
    public String completedDate;
    public int completedDays;
    public boolean isCompleted;

    public Habit() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public Habit(String habitName, int numberOfDays, boolean notify, String notificationTime, String createdDate,
                 String completedDate, int completedDays, boolean isCompleted) {
        this.habitName = habitName;
        this.numberOfDays = numberOfDays;
        this.notify = notify;
        this.notificationTime = notificationTime;
        this.createdDate = createdDate;
        this.completedDate = completedDate;
        this.completedDays = completedDays;
        this.isCompleted = isCompleted;
    }

    public String getHabitName() {
        return habitName;
    }

    public void setHabitName(String habitName) {
        this.habitName = habitName;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public boolean isNotify() {
        return notify;
    }

    public void setNotify(boolean notify) {
        this.notify = notify;
    }

    public String getNotificationTime() {
        return notificationTime;
    }

    public void setNotificationTime(String notificationTime) {
        this.notificationTime = notificationTime;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCompletedDate() {
        return completedDate;
    }

    public void setCompletedDate(String completedDate) {
        this.completedDate = completedDate;
    }

    public int getCompletedDays() {
        return completedDays;
    }

    public void setCompletedDays(int completedDays) {
        this.completedDays = completedDays;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
