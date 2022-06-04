/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.andriawan.event_tix.models;

/**
 *
 * @author naufalfawwaz
 */
public class Event {
    
    String title, description, status, type, eventTime;
    int quota, price, id;

    public Event(int id, String title, String description, int quota, String status, String type, int price, String eventTime) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.type = type;
        this.eventTime = eventTime;
        this.quota = quota;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String event_time) {
        this.eventTime = event_time;
    }

    public int getQuota() {
        return quota;
    }

    public void setQuota(int quota) {
        this.quota = quota;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

//    @Override
//    public int hashCode() {
//        int hash = 7;
//        hash = 31 * hash + Objects.hashCode(this.title);
//        hash = 31 * hash + Objects.hashCode(this.description);
//        hash = 31 * hash + Objects.hashCode(this.status);
//        hash = 31 * hash + Objects.hashCode(this.type);
//        hash = 31 * hash + Objects.hashCode(this.eventTime);
//        hash = 31 * hash + this.quota;
//        hash = 31 * hash + this.price;
//        hash = 31 * hash + this.id;
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Event other = (Event) obj;
//        if (this.quota != other.quota) {
//            return false;
//        }
//        if (this.price != other.price) {
//            return false;
//        }
//        if (this.id != other.id) {
//            return false;
//        }
//        if (!Objects.equals(this.title, other.title)) {
//            return false;
//        }
//        if (!Objects.equals(this.description, other.description)) {
//            return false;
//        }
//        if (!Objects.equals(this.status, other.status)) {
//            return false;
//        }
//        if (!Objects.equals(this.type, other.type)) {
//            return false;
//        }
//        return Objects.equals(this.eventTime, other.eventTime);
//    }
    
    
}
