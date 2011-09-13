package com.tedwon.pilots.cep.event;

/**
 * Representation Class for Access Log Event.
 *
 * @author <a href="mailto:idd@email.com">Ted Won</a>
 * @version 1.0
 */
public class AccessLogEvent {


    // date,querytime,username,ipAddress,page


    private String date;
    private String querytime;
    private String username;
    private String ipAddress;
    private String page;


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getQuerytime() {
        return querytime;
    }

    public void setQuerytime(String querytime) {
        this.querytime = querytime;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }
}

