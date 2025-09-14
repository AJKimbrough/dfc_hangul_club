package com.dfc.hangul.model;

public class Event {
  private String title;
  private String date;
  private String time;
  private String where;
  private String desc;
  private String rsvp;

  public Event() {}
  public Event(String title, String date, String time, String where, String desc, String rsvp) {
    this.title = title; this.date = date; this.time = time; this.where = where; this.desc = desc; this.rsvp = rsvp;
  }

  public String getTitle() { return title; }
  public String getDate() { return date; }
  public String getTime() { return time; }
  public String getWhere() { return where; }
  public String getDesc() { return desc; }
  public String getRsvp() { return rsvp; }
}
