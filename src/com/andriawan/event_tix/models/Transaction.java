package com.andriawan.event_tix.models;

public class Transaction {
    
    public int id;
    public Event event;
    public User user;
    public String status, deadline;
    public int amount;

    public Transaction(int id, Event event, User user, String status, String deadline, int amount) {
        this.id = id;
        this.event = event;
        this.user = user;
        this.status = status;
        this.deadline = deadline;
        this.amount = amount;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getStatus() {
        return status;
    }
    
    public void setStatus(String status) {
        this.status = status;
    }
    
    public String getDeadline() {
        return deadline;
    }
    
    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }
    
    public int getAmount() {
        return amount;
    }
    
    public void setAmount(int amount) {
        this.amount = amount;
    }
    
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + amount;
        result = prime * result + ((deadline == null) ? 0 : deadline.hashCode());
        result = prime * result + ((event == null) ? 0 : event.hashCode());
        result = prime * result + id;
        result = prime * result + ((status == null) ? 0 : status.hashCode());
        result = prime * result + ((user == null) ? 0 : user.hashCode());
        return result;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (amount != other.amount)
            return false;
        if (deadline == null) {
            if (other.deadline != null)
                return false;
        } else if (!deadline.equals(other.deadline))
            return false;
        if (event == null) {
            if (other.event != null)
                return false;
        } else if (!event.equals(other.event))
            return false;
        if (id != other.id)
            return false;
        if (status == null) {
            if (other.status != null)
                return false;
        } else if (!status.equals(other.status))
            return false;
        if (user == null) {
            if (other.user != null)
                return false;
        } else if (!user.equals(other.user))
            return false;
        return true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
